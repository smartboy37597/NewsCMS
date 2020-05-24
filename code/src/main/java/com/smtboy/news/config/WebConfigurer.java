package com.smtboy.news.config;


import com.smtboy.news.common.Const;
import com.smtboy.news.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(LoginInterceptor())
				.addPathPatterns("/user/**")
				.addPathPatterns("/newsProgram/**")
				.addPathPatterns("/news/**")
				.excludePathPatterns("/user/checkLogin")
				.excludePathPatterns("/user/login")
				.excludePathPatterns("/user/autoLogin");
	 }

	 @Bean
	 public LoginInterceptor LoginInterceptor() {
		 return new LoginInterceptor();
	 }

}