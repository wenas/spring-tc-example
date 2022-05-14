package com.example.tcexample.tc;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// フィールドをstaticにする以外は同じ
@Testcontainers
@Log4j2
public class StaticContainerTest {

    @Container
    private static PostgreSQLContainer postgresqlContainer =
            new PostgreSQLContainer("postgres:14.2")
                    .withDatabaseName("dog")
                    .withUsername("pochi")
                    .withPassword("secret");

    private static String jdbcUrl;

    @Test
    void testCase1() {
        assertTrue(postgresqlContainer.isRunning());
        // 同一のコンテナで動いていることを確認
        if (null == jdbcUrl) {
            jdbcUrl = postgresqlContainer.getJdbcUrl();
        } else {
            // 同一のURLが返却される
            assertEquals(jdbcUrl, postgresqlContainer.getJdbcUrl());
        }
    }

    @Test
    void testCase2() {
        assertTrue(postgresqlContainer.isRunning());
        // 同一のコンテナで動いていることを確認
        if (null == jdbcUrl) {
            jdbcUrl = postgresqlContainer.getJdbcUrl();
        } else {
            // 同一のURLが返却される
            assertEquals(jdbcUrl, postgresqlContainer.getJdbcUrl());
        }
    }


}
