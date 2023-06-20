package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	private static String path;
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();

		return extent;
	}


	public static ExtentReports createInstance() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			String reportName = "Report.html";

			if (System.getProperty("os.name").toLowerCase().contains("mac")
					|| System.getProperty("os.name").toLowerCase().contains("linux")) {
				path = "//target//" + reportName;
			} else {
				path = "\\target\\" + reportName;
			}
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(workingDir + path);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Report");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automated Tests - Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		return extent;
	}

}
