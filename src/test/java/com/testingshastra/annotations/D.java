package com.testingshastra.annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class D extends TestBase{
	
	@Test
	public void d1() {
		System.out.println("I am d1 of D");
	}

	public void d2() {
		System.out.println("I am d2 of D");
	}

	public void d3() {
		System.out.println("I am d3 of D");
	}

	@Test
	public void cd() {
		System.out.println("I am d4 of D");
	}
}
