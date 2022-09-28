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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理控制器
 *
 * @author liyaj
 * @date 2022/09/27
 */
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {
    @Autowired
    private AdminService adminService;

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
    @DeleteMapping("/deleteAdmin")
    public Result deleteAdmin(@RequestBody List<Integer> ids) {
        adminService.removeByIds(ids);
        return Result.ok();
    }
}
