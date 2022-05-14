package com.example.tcexample.tc;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// @Testcontainersアノテーションは起動停止を自動で行ってくれる
@Testcontainers
public class DockerComposeContainerTest {

    @Container
    private DockerComposeContainer composeContainer =
            new DockerComposeContainer(new File("docker-compose.yml"));

    @Test
    void kidou() {

    }
}
