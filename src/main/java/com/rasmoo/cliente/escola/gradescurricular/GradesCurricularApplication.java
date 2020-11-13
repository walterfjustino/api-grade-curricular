package com.rasmoo.cliente.escola.gradescurricular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GradesCurricularApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GradesCurricularApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GradesCurricularApplication.class, args);
	}

}
