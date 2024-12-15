package com.stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int a, b, result = 0;
	String name, pincode;

	@Given("I have numbers {long} and {long}")
	public void acceptNumbers(long a, long b) {
		this.a = (int) a;
		this.b = (int) b;
	}

	@When("I add them")
	public void addition() {
		result = a + b;
	}

	@Then("check if the result is prime")
	public void checkIfAdditionIsPrime() {
		int count = 1;
		for (int i = 1; i <= result / 2; i++) {
			if (result % i == 0) {
				count++;
			}
		}

		if (count > 2) {
			System.out.println("Number " + result + " is not prime");
		} else {
			System.out.println("Number " + result + " is PRIME");
		}
	}

	@Given("I have first name {string}")
	public void acceptName(String name) {
		this.name = name;
	}

	@Then("Print the first name")
	public void printFName() {
		System.out.println("First Nmae: " + name);
	}

	@Given("I have following fruits:")
	public void acceptListOfFruits(DataTable fruits) {
		Map<String, List> data = fruits.asMap(String.class, List.class);

		Set<Entry<String, List>> entries = data.entrySet();

		for (Entry<String, List> entry : entries) {
			ArrayList<String> count = (ArrayList<String>) data.get(entry.getKey());

			for (String object : count) {
				System.err.print(object+",");
			}
			System.out.println();
		}
	}
	
	@Given("I have {string}")
	public void acceptPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Then("print the pincode")
	public void printPincode() {
		System.out.println(this.pincode);
	}

}
