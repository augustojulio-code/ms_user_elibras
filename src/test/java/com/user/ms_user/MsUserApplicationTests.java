package com.user.ms_user;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.ms_user.utils.EnvLoader;

@SpringBootTest
class MsUserApplicationTests {

	@BeforeAll
	public static void setup() {
		EnvLoader.loadEnv();
	}

	@Test
	void contextLoads() {

		assertTrue(true);
	}

}
