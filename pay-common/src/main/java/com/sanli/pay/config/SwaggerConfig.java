package com.sanli.pay.config;

import com.sanli.pay.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.sanli.pay.controller")
                .title("Pay-System支付系统")
                .description("Pay-System支付系统相关接口文档")
                .contactName("sanli")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }

//    @Bean
//    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//        return generateBeanPostProcessor();
//    }
}
