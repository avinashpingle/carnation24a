package com.testngdemo.testannotation;

import org.testng.annotations.Test;

public class ParametersOfTest {

	@Test
	public void m4() {
		System.out.println("I am m4");
	}
	@Test
	public void m1() {
		System.out.println("I am m1");
	}
	@Test()
	public void m3() {
		System.out.println("I am m3");
	}
	@Test(dependsOnMethods = "m3")
	public void m2() {
		System.out.println("I am m2");
	}
}
