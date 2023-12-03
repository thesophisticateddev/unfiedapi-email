package com.unifiedapi.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MicrosoftTest {
    @Test
    public void shouldNotReturnNullObject(){
        //The tenant id is for my personal id
        Microsoft testObject = new Microsoft.builder().tenantId("f8cdef31-a31e-4b4a-93e4-5f571e91255a").clientId("Soem client id").build();
        assertNotNull(testObject);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeException(){
        // Should throw a runtime exception
        Microsoft testObject = new Microsoft.builder().clientId("Soem client id").build();
    }
}
