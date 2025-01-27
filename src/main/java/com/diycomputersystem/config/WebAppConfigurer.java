//使Spring Boot应用程序具备处理跨域请求、提供静态资源和自定义请求拦截的能力
package com.diycomputersystem.config;

import com.diycomputersystem.interceptor.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://10.5.152.82:8082")
                .allowedOrigins("http://10.4.30.9:8081")
                .allowedOrigins("http://10.5.217.116:8081")
                .allowedOrigins("http://10.4.172.127:8080")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:D:\\Image\\swiperImgs\\");
        registry.addResourceHandler("/image/product/**").addResourceLocations("file:D:\\Image\\productImgs\\");
        registry.addResourceHandler("/image/bigType/**").addResourceLocations("file:D:\\Image\\bigTypeImgs\\");
        registry.addResourceHandler("/image/productSwiperImgs/**").addResourceLocations("file:D:\\Image\\productSwiperImgs\\");
        registry.addResourceHandler("/image/productIntroImgs/**").addResourceLocations("file:D:\\Image\\productIntroImgs\\");
        registry.addResourceHandler("/image/productParaImgs/**").addResourceLocations("file:D:\\Image\\productParaImgs\\");
    }
    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns=new String[]{"/adminLogin","/product/**","/bigType/**","/user/wxlogin","/weixinpay/**"};
        registry.addInterceptor(sysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }

    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            System.out.println("测试="+i);
        }
    }
}


