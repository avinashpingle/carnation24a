package com.testingshastra.annotations;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B extends TestBase{
	
	@Test
	public void b1() {
		System.out.println("I am b1 of B");
	}
	
	public void b2() {
		System.out.println("I am b2 of B");
	}
}
