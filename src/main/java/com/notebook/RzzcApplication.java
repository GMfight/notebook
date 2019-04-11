package com.notebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackages={"com.notebook"})
//@MapperScan("com.htxx.rzzc.mapper")
public class RzzcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RzzcApplication.class, args);
	}
}
