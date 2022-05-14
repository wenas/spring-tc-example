package com.example.tcexample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Log4j2
class TodoRepositoryTest {

    @Container
    private static PostgreSQLContainer postgresqlContainer =
            (PostgreSQLContainer) new PostgreSQLContainer("postgres:14.2")
                    .withDatabaseName("todo")
                    .withInitScript("todo.sql");

    @DynamicPropertySource
    static void jdbcProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresqlContainer::getUsername);
        registry.add("spring.datasource.password", postgresqlContainer::getPassword);
        // initScriptでテーブルを作成するためflywayをOFFに
        registry.add("spring.flyway.enabled", () -> false);

        log.info(postgresqlContainer.getJdbcUrl());
        log.info(postgresqlContainer.getUsername());
        log.info(postgresqlContainer.getPassword());
    }

    @Autowired
    private TodoRepository repository;

    @Test
    @Transactional
    void addTodo() {

        Todo todo = new Todo(null, "🐱にご飯をもらう", "Doing");
        repository.save(todo);

        assertEquals(3, repository.count());
        log.info(repository.findAll());
    }




}