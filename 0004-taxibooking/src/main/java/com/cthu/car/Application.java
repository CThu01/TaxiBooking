package com.cthu.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cthu.car.model.repo.BaseRepoImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.cthu.car")
@EnableJpaRepositories(repositoryBaseClass = BaseRepoImpl.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
