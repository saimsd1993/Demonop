package com.commerce.qa.testcases;

import org.testng.TestNG;

import com.commerce.qa.extentlistener.Extentreporter;

public class Noprunner {
	static TestNG testng;
	public static void main(String[] args) {
		
		Extentreporter ext=new Extentreporter();
		
		testng=new TestNG();
		testng.setTestClasses(new Class[] {Logintest.class,TC_Smoke.class});
		testng.run();
		testng.addListener(ext);
	}

}
