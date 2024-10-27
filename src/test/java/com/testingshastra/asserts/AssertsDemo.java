package com.testingshastra.asserts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertsDemo {

	@Test
	public void myTestCase() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertEquals("Hi", "Hello");
		softly.assertEquals("hi", "Hi");
		softly.assertEquals("Hello", "Hello");
		
		softly.assertAll();
	}
}
