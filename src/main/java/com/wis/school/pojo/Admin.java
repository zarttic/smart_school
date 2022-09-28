/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:26
 */

package com.wis.school.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Data
@AllArgsConstructor //有参构造
@NoArgsConstructor  //无参构造
@TableName("tb_admin") //和数据库对应
public class Admin {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)  //标记主键
    private Integer id;
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
}
