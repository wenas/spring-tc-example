package com.example.tcexample.tc.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SingletonContainerTest2 extends SingletonPostgres {

    @Test
    void testCase1() {
        assertTrue(singletonPostgres.isRunning());
        System.out.println("singleton2:" + singletonPostgres.getJdbcUrl());
        System.out.println("singleton2:" + singletonPostgres.getContainerId());
    }

}
