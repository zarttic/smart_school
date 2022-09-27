/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:54
 */

package com.wis.school.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_teacher")
public class Teacher {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 教师号
     */
    private String tno;
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
     * 头像路径
     */
    private String portraitPath;
    /**
     * 所带班级信息
     */
    private String clazzName;
}
