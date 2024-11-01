package com.user.ms_user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.ms_user.utils.EnvLoader;

class MsUserApplicationTests {

	@BeforeAll
	public static void setup() {

		EnvLoader.loadEnv();
	}

	@Test
	void contextLoads() {

	}

}
