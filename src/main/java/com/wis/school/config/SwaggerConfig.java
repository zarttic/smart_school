/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 14:07
 */

package com.wis.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置信息
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wis.school"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API测试文档")
                .description("DEMO项目的接口测试文档")
                .termsOfServiceUrl("http://www.hangge.com")
                .version("1.0")
                .contact(new Contact("航歌",
                        "http://www.hangge.com",
                        "hangge@hangge.com"))
                .build();
    }
}