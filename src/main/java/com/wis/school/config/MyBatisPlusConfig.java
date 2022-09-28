/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 13:46
 */

package com.wis.school.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分页查询配置
 *
 * @author liyaj
 * @date 2022/09/28
 */
@Configuration
@MapperScan("com.wis.school.mapper")
public class MyBatisPlusConfig {

    /**
     * mybatisPlus拦截器
     * 分页插件
     *
     * @return {@link MybatisPlusInterceptor}
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }


}

