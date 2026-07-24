package com.yashraj.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setDocumentTitle("Playwright Automation");

            spark.config().setReportName("Regression Execution");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("QA", "Yashraj");

            extent.setSystemInfo("Framework", "Playwright");

            extent.setSystemInfo("Language", "Java");
        }

        return extent;
    }

}