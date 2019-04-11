package com.notebook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.notebook.filter.UserConfig;
@Component
public class WebSecurityUrlConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new UserConfig())
//		.excludePathPatterns("/error")
//		.excludePathPatterns("/rzzc/user/login")
		.addPathPatterns("/**");
	}
}
