/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 19:57
 */

package com.wis.school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录表单
 *
 * @author liyaj
 * @date 2022/09/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证代码
     */
    private String verifyCode;
    /**
     * 用户类型
     */
    private Integer userType;
}
