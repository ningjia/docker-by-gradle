package com.example.springboot.dockerbygradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerByGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerByGradleApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "启动成功：Hello World, Docker By Gradle!";
	}
}
