package com.andy.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.andy.intercepter.MyIntercepter;
import com.andy.intercepter.MySecondInterceptor;

@MapperScan("com.andy.dao")
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages="com.andy")
public class RunClass extends WebMvcConfigurerAdapter{
	@Bean
	public CharacterEncodingFilter characterEncodingFilter(){
		CharacterEncodingFilter filter=new CharacterEncodingFilter("UTF-8");
		return filter;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
        registry.addInterceptor(new MyIntercepter());
        registry.addInterceptor(new MySecondInterceptor());
        
	}
	public static void main(String[] args) {
		SpringApplication.run(RunClass.class, args);
	}
}
