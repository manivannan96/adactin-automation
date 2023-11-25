package com.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {
	public static void generateJvmReport(String jsonFile) throws FileNotFoundException, IOException {
		File file=new File(getPropertyFileValue("jvm"));
		Configuration config=new Configuration(file,"Adactin Automation");
		config.addClassifications("Browser", "chrome");
		config.addClassifications("Browser Version", "107.67");
		config.addClassifications("OS", "WIN 10");
		config.addClassifications("Sprint", "7");
		
		List<String>jsonFiles1=new ArrayList<String>();
		jsonFiles1.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles1,config);
		builder.generateReports();
		
		
	}

}


