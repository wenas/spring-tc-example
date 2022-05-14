package com.example.tcexample.tc.singleton;


import org.testcontainers.containers.PostgreSQLContainer;

public abstract class SingletonPostgres {

    public static final PostgreSQLContainer<?> singletonPostgres =
            new PostgreSQLContainer("postgres:14.2")
                    .withDatabaseName("chicken")
                    .withUsername("kenta")
                    .withPassword("secret");
    static {
        singletonPostgres.start();
    }

}
