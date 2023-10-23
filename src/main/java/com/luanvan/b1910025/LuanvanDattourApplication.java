package com.luanvan.b1910025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		LuanvanDattourApplication.class,
		Jsr310JpaConverters.class
})
public class LuanvanDattourApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuanvanDattourApplication.class, args);
	}

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

//	@Bean
//	public WebMvcConfigurer configure() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry reg) {
//				reg.addMapping("/**").allowedOrigins("http://127.0.0.1:5173");
//			}
//		};
//	}
}
