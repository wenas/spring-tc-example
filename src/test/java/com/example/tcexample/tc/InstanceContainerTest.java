package com.example.tcexample.tc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// @Testcontainersアノテーションは起動停止を自動で行ってくれる
@Testcontainers
public class InstanceContainerTest {

    // @Containerアノテーションがついたコンテナのライフサイクルを管理してくれる
    @Container
    private PostgreSQLContainer postgresqlContainer =
            new PostgreSQLContainer("postgres:14.2")
                    .withDatabaseName("cat")
                    .withUsername("tama")
                    .withPassword("secret");

    private static String jdbcUrl;

    @Test
    void testCase1() {
        assertTrue(postgresqlContainer.isRunning());
        // 違うコンテナで動いていることを確認
        if (null == jdbcUrl) {
            jdbcUrl = postgresqlContainer.getJdbcUrl();
        } else {
            // 異なるURLが返却される
            assertNotEquals(jdbcUrl, postgresqlContainer.getJdbcUrl());
        }
    }

    @Test
    void testCase2() {
        assertTrue(postgresqlContainer.isRunning());
        // 違うコンテナで動いていることを確認
        if (null == jdbcUrl) {
            jdbcUrl = postgresqlContainer.getJdbcUrl();
        } else {
            // 異なるURLが返却される
            assertNotEquals(jdbcUrl, postgresqlContainer.getJdbcUrl());
        }
    }

}
