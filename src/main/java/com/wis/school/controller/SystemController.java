/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:17
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wis.school.pojo.*;
import com.wis.school.service.AdminService;
import com.wis.school.service.StudentService;
import com.wis.school.service.TeacherService;
import com.wis.school.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 系统控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@SuppressWarnings("all")
@Api(tags = "系统控制器")
@RestController
@RequestMapping("/sms/system")
public class SystemController {
    /**
     * 管理服务
     */
    @Autowired
    private AdminService adminService;
    /**
     * 教师服务
     */
    @Autowired
    private TeacherService teacherService;
    /**
     * 学生服务
     */
    @Autowired
    private StudentService studentService;


    /**
     * 获取验证码图片
     *
     * @param request  请求
     * @param response 响应
     */
    @ApiOperation("获取验证码图片")
    @GetMapping("/getVerifyCodeImage")
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response){
        /*
          获取验证码图片
         */
        BufferedImage verifyCodeImage = CreateVerifyCodeImage.getVerifyCodeImage();
        /*
          验证码
         */
        String verifyCode = String.valueOf(CreateVerifyCodeImage.getVerifyCode());
        /*
          图片传输到前端
         */
        request.getSession().setAttribute("verifyCode",verifyCode);
        try {
            ImageIO.write(verifyCodeImage,"JPEG",response.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 登录
     * 登录校验
     *
     * @param loginForm 登录表单
     * @param request   请求
     * @return {@link Result}
     */
    @PostMapping("/login")
    public Result Login(@RequestBody LoginForm loginForm,HttpServletRequest request){
        /*
          验证码校验
         */
        HttpSession session = request.getSession();
        String sessionVerifyCode = (String) session.getAttribute("verifyCode");
        String loginVerifyCode = loginForm.getVerifyCode();
        //验证码可能会失效
        if (StringUtils.isEmpty(sessionVerifyCode)){
            return Result.fail().message("验证码失效，刷新后重试");
        }
        //验证码输入错误
        if (!sessionVerifyCode.equalsIgnoreCase(loginVerifyCode)){
            System.out.println("session" + sessionVerifyCode);
            System.out.println("login" + loginVerifyCode);
            return Result.fail().message("验证码有误，刷新后重试");
        }
        //从session中移除验证码
        session.removeAttribute("verifyCode");
        /*
          用户类型校验
         */
        //存放响应的数据
        Map<String, Object> res = new LinkedHashMap<>();
        switch (loginForm.getUserType()){
            case 1:
                //管理员
                try {
                    Admin admin = adminService.login(loginForm);
                    if(admin != null){
                        res.put("token",JwtHelper.createToken(admin.getId().longValue(),1,admin.getName()));
                    }else{
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(res);
                } catch (RuntimeException e) {

//                    throw new RuntimeException(e);
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }

            case 2:
                //学生
                try {
                    Student student = studentService.login(loginForm);
                    if(student != null){
                        res.put("token",JwtHelper.createToken(student.getId().longValue(),2,student.getName()));
                    }else{
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(res);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
            case 3:
                //教师
                try {
                    Teacher teacher = teacherService.login(loginForm);
                    if(teacher != null){
                        res.put("token",JwtHelper.createToken(teacher.getId().longValue(),3,teacher.getName()));
                    }else{
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(res);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }

        }
        return Result.fail().message("查无此用户");
    }
    /**
     * 登录校验成功后从token解析信息
     *
     * @param token 令牌
     * @return {@link Result}
     */
    @GetMapping("/getInfo")
    public Result getInfoByToken(@RequestHeader("token") String token){
        // 校验是否过期
        if (JwtHelper.isExpiration(token)){
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        //解析出用户的信息  id name type
        Map<String, Object> res = new LinkedHashMap<>();
        TokenBody tokenMessage = JwtHelper.getTokenMessage(token);
        res.put("userType",tokenMessage.getUserType());
        switch (tokenMessage.getUserType()){
            case 1:
                res.put ("user",adminService.getAdminById(tokenMessage.getUserId()));
                break;
            case 2:
                res.put("user", studentService.getStudentById(tokenMessage.getUserId()));
                break;
            case 3:
                res.put("user", teacherService.getTeacherById(tokenMessage.getUserId()));
                break;

        }
        return Result.ok(res);
    }

    /**
     * 头像上传
     * 待实现 上传成功之后删除之前的头像
     * 上传不是热加载所以需要重启服务器之后才能更新上传的头像
     *
     * @param multipartFile 上传文件
     * @return {@link Result}
     */
    @ApiOperation("头像上传")
    @PostMapping("/headerImgUpload")
    public Result headerImgUpload(
            @ApiParam("二进制文件") @RequestPart("multipartFile") MultipartFile multipartFile) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String fileName = uuid.concat(multipartFile.getOriginalFilename());
        String portraitPath = "C:/Users/liyaj/IdeaProjects/school/src/main/resources/public/upload/".concat(fileName);
        try {
            multipartFile.transferTo(new File(portraitPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String headImag = "upload/" + fileName;
        return Result.ok(headImag);
    }

    /**
     * 更新密码
     *
     * @param token  令牌
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return {@link Result}
     */
    @PostMapping("/updatePwd/{oldPwd}/{newPwd}")
    public Result updatePwd(
            @RequestHeader("token") String token,
            @PathVariable("oldPwd") String oldPwd,
            @PathVariable("newPwd") String newPwd) {
        if (JwtHelper.isExpiration(token)) {
            return Result.fail().message("token失效");
        }
        TokenBody bd = JwtHelper.getTokenMessage(token);
        String oldpwd = Encode_MD5.encrypt(oldPwd);
        String newpwd = Encode_MD5.encrypt(newPwd);
        switch (bd.getUserType()) {
            case 1: {
                QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
                Admin one = adminService.getOne(
                        queryWrapper.eq("id", bd.getUserId()).eq("password", oldpwd));
                if (one != null) {
                    one.setPassword(newpwd);
                    adminService.saveOrUpdate(one);
                } else {
                    return Result.fail().message("原密码有误");
                }
                break;
            }
            case 2: {
                QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
                Student one = studentService.getOne(
                        queryWrapper.eq("id", bd.getUserId()).eq("password", oldpwd));
                if (one != null) {
                    one.setPassword(Encode_MD5.encrypt(newpwd));
                    studentService.saveOrUpdate(one);
                    break;
                } else {
                    return Result.fail().message("密码有误");
                }
            }
            case 3: {
                QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
                Teacher one = teacherService.getOne(
                        queryWrapper.eq("id", bd.getUserId()).eq("password", oldpwd));
                if (one != null) {
                    one.setPassword(Encode_MD5.encrypt(newpwd));
                    teacherService.saveOrUpdate(one);
                } else {
                    return Result.fail().message("原密码有误");
                }
            }
        }
        return Result.ok();
    }
}
