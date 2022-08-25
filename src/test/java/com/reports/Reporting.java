package com.reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJvmReport(String jsonFile) throws IOException {
		String pathoutput = System.getProperty("user.dir");

		File file = new File(pathoutput+getPropertyValue("jvmpath"));

		Configuration config = new Configuration(file, "API-OMR BRANCH TESTING");

		config.addClassifications("OS", "Windows 11");
		config.addClassifications("TestRun", "with Valid Credentials");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, config);

		builder.generateReports();

	}
}
