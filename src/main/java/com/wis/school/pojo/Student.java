/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:39
 */

package com.wis.school.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生表
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_student")
public class Student {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 学号
     */
    private String sno;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private Character gender;
    /**
     * 密码
     */
    private String password;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 地址
     */
    private String address;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 头像路径
     */
    private String portraitPath;
    /**
     * 班级信息
     */
    private String clazzName;
}
