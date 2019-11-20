package nuc.bean.homework_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new UserConfig();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/login.html");
        WebMvcConfigurer.super.addInterceptors(registry);
    }


}
