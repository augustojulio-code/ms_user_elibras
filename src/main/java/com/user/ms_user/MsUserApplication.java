package com.user.ms_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.user.ms_user.utils.EnvLoader;

@SpringBootApplication
public class MsUserApplication {

	public static void main(String[] args) {
		EnvLoader.loadEnv();
		SpringApplication.run(MsUserApplication.class, args);
	}

}
