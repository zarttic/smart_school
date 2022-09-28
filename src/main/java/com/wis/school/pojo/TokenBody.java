/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 22:21
 */

package com.wis.school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装从token里面获取的信息
 *
 * @author liyaj
 * @date 2022/09/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenBody {
    /**
     * 用户id
     */
    Long userId;
    /**
     * 用户名
     */
    String userName;
    /**
     * 用户类型
     */
    Integer userType;
}
