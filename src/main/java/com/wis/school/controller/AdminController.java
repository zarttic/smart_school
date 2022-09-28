/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 20:29
 */

package com.wis.school.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wis.school.pojo.Admin;
import com.wis.school.service.AdminService;
import com.wis.school.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Api(tags = "管理员控制器")
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {
    /**
     * 管理服务接口
     */
    @Autowired
    private AdminService adminService;

    /**
     * 得到所有管理
     *
     * @param pageNo   页面没有
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Result}
     */
    @ApiOperation("获取管理员集合")
    @GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
    public Result getAllAdmin(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            String name) {
        Page<Admin> page = new Page<>(pageNo, pageSize);
        return Result.ok(adminService.getAllAdmin(page, name));
    }

    /**
     * 保存或更新管理员
     *
     * @param admin 管理
     * @return {@link Result}
     */
    @ApiOperation("新增,修改管理员信息")
    @PostMapping("/saveOrUpdateAdmin")
    public Result saveOrUpdateAdmin(@RequestBody Admin admin) {
        adminService.saveOrUpdate(admin);
        return Result.ok();
    }

    /**
     * 删除管理员
     *
     * @param ids id
     * @return {@link Result}
     */
    @ApiOperation("删除管理")
    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(@RequestBody List<Integer> ids) {
        adminService.removeByIds(ids);
        return Result.ok();
    }
}
