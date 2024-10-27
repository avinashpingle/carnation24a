package com.testingshastra.annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C extends TestBase{
	
	@Test
	public void c1() {
		System.out.println("I am c1 of C");
	}

	public void c2() {
		System.out.println("I am c2 of C");
	}

	@Test
	public void c3() {
		System.out.println("I am c3 of C");
	}

	@Test
	public void c4() {
		System.out.println("I am c4 of C");
	}

}
