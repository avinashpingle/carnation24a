package com.testingshastra.annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

	@BeforeClass
	public void m1() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void m2() {
		System.out.println("Before Method");
	}
	
	@BeforeTest
	public void m3() {
		System.out.println("Before Test");
	}
}
