package com.cthu.car.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableJpaAuditing
//@EnableJpaRepositories(repositoryBaseClass = BaseRepoImpl.class)
public class MvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
				.allowedOriginPatterns("*")
				.allowedMethods("*");
	}
	
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}



