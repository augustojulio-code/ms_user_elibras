package com.user.ms_user.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    public static void loadEnv() {

        Dotenv dotenv = Dotenv.configure().load();

        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("SONAR_URL", dotenv.get("SONAR_URL"));
        System.setProperty("SONAR_TOKEN", dotenv.get("SONAR_TOKEN"));
        System.setProperty("SONAR_ORG", dotenv.get("SONAR_ORG"));
        System.setProperty("SONAR_PROJECTKEY", dotenv.get("SONAR_PROJECTKEY"));

    }

}
