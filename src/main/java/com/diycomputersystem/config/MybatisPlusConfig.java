//配置MyBatis-Plus的分页插件，使得MyBatis-Plus能够在你的Spring Boot应用程序中自动处理分页查询。
package com.diycomputersystem.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}