package com.notebook.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration config=new CorsConfiguration();
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		config.addAllowedOrigin("*");
		config.addExposedHeader("app-token");//		Access-Control-Allow-Expose-Headers

//		config.addAllowedOrigin("http://localhost:8086");
//		config.addExposedHeader("*");
		config.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource cs=new UrlBasedCorsConfigurationSource();
		cs.registerCorsConfiguration("/**", config);
		return new CorsFilter(cs);
	}
}
