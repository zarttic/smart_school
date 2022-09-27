/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 17:09
 */

package com.wis.school.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 身份验证上下文持有人
 *
 * @author liyaj
 * @date 2022/09/27
 */
public class AuthContextHolder {
    /**
     * 得到用户id标记
     *
     * @param request 请求
     * @return {@link Long}
     */
    public static Long getUserIdToken(HttpServletRequest request){
        return JwtHelper.getUserID(request.getHeader("token"));
    }

    /**
     * 得到用户名令牌
     *
     * @param request 请求
     * @return {@link String}
     */
    public static String getUserNameToken(HttpServletRequest request){
        return JwtHelper.getUserName( request.getHeader("token"));
    }

    /**
     * 得到用户类型令牌
     *
     * @param request 请求
     * @return {@link Integer}
     */
    public static Integer getUserTypeToken(HttpServletRequest request){
        return JwtHelper.getUserType( request.getHeader("token"));
    }
}
