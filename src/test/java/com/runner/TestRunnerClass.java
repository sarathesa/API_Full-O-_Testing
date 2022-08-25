package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, snippets = SnippetType.CAMELCASE, plugin = { "pretty","json:src/test/resources/Reports/JSONReports/report.json" },
features = "src/test/resources/Features", glue = {"com.stepdefinition" }, monochrome = true)

public class TestRunnerClass extends BaseClass{
	@AfterClass
	public static void afterClass() throws IOException {
		String path = System.getProperty("user.dir");

		Reporting.generateJvmReport(path + getPropertyValue("jsonpath"));

	}
	
	
}
