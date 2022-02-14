package com.ecommerce;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@DisplayName("JUnit 4 Dependency Injection Example")
public class DependencyInjection {

	DependencyInjection(TestInfo testInfo) {
		assertEquals("JUnit 4 Dependency Injection Example", testInfo.getDisplayName());
	}
	
	@BeforeEach
	void init(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
	}
	
	@Test
	@DisplayName("TEST 1")
	@Tag("my-tag")
	void test(TestInfo testInfo) {
		assertEquals("TEST 1", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("my-tag"));
	}
	
	@Test
	void test2() {}
}
