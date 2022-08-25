package com.stepdefinition;

import org.junit.After;
import org.junit.Before;

public class HooksClass {
	@Before
	public void before() {
	System.out.println("========================BEFORE TEST=================");

	}
	@After
	public void after() {
		System.out.println("========================AFTER TEST=================");

	}
	

}
