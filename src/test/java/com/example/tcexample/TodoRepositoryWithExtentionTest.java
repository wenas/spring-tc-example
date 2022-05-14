package com.example.tcexample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Log4j2
@ExtendWith(PostgresExtention.class)
@DirtiesContext
class TodoRepositoryWithExtentionTest {

    @Autowired
    private TodoRepository repository;

    @Test
    @Transactional
    @Sql(scripts = "classpath:data/extention_data.sql")
    void addTodo() {

        Todo todo = new Todo(null, "🐱にご飯をもらう", "Doing");
        repository.save(todo);

        assertEquals(3, repository.count());
        log.info(repository.findAll());
    }

}