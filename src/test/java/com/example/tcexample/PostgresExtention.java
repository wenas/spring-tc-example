package com.example.tcexample;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresExtention implements BeforeAllCallback, AfterAllCallback {

    private PostgreSQLContainer<?> postgresqlContainer;

    @Override
    public void beforeAll(ExtensionContext context) {
        postgresqlContainer =
                (PostgreSQLContainer) new PostgreSQLContainer("postgres:14.2")
                        .withDatabaseName("todo");
        postgresqlContainer.start();
        System.setProperty("spring.datasource.url", postgresqlContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", postgresqlContainer.getUsername());
        System.setProperty("spring.datasource.password", postgresqlContainer.getPassword());
    }

    @Override
    public void afterAll(ExtensionContext context) {
        // 何もしなくてもOK
    }
}

