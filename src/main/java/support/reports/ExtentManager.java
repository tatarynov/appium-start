package support.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;


    private synchronized static ExtentHtmlReporter getReporter() {
        if (htmlReporter == null) {
            String workingDir = System.getProperty("user.dir");
            File reportPath = new File(workingDir + File.separator + "report");
            if (!reportPath.exists()) reportPath.mkdir();
            String filePath = reportPath + File.separator + "testReport.html";
            htmlReporter = new ExtentHtmlReporter(filePath);

            htmlReporter.config().setDocumentTitle("Reporting example");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setReportName("Cogniance Test Framework");
        }

        return htmlReporter;
    }

    public synchronized static ExtentReports getExtent() throws Exception {
        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(getReporter());
        }
        return extent;
    }

    public static synchronized ExtentTest startTest(String testName, String desc) throws Exception {
        test = getExtent().createTest(testName, desc);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
