/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:31
 */

package com.wis.school.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * clazz 班级表
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_clazz")
public class Clazz {
    /**
     * 班级编号
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 班级名称
     */
    private String name;
    /**
     * 班级人数
     */
    private Integer number;
    /**
     * 班级介绍
     */
    private String introduction;
    /**
     * 班主任
     */
    private String headmaster;
    /**
     * 班主任邮箱
     */
    private String email;
    /**
     * 班主任电话
     */
    private String telephone;
    /**
     * 年级名字
     */
    private String gradeName;
}
