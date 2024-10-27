package com.testingshastra;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	@Test
	public void firstTestCase() {
		System.out.println("My Test Case");
	}
	
	@Test
	public void secondTestCase() {
		System.out.println("Second test case");
	}
	
	@BeforeTest
	public void m1() {
		System.out.println("Before Test");
	}
}
