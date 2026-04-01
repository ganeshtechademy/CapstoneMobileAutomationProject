package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extent-report.html");
            reporter.config().setReportName("Mobile Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

          //  extent.setSystemInfo("Tester", "QA Team");
          //  extent.setSystemInfo("Platform", "Android");
        }
        return extent;
    }
}