package com.thoughtworks.training;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SpringAppTest {
    @Test
    public void testAppHasAGreeting() {
        SpringApp classUnderTest = new SpringApp();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

}