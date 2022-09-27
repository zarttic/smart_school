/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:36
 */

package com.wis.school.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 年级
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_grade")
public class Grade {
    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 年级名称
     */
    private String name;
    /**
     * 年级主任
     */
    private String manager;
    /**
     * 年级主任邮箱
     */
    private String email;
    /**
     * 年级主任的电话
     */
    private String telephone;
    /**
     * 年级的介绍
     */
    private String introduction;

}
