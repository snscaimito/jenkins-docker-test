package com.devbugger.jdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JenkinsDockerTest {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JenkinsDockerTest.class);
    }
}