package Reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utitlites.Screenshort;

public class Extent_Report implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String reportName;

    @Override
    public void onStart(ITestContext context) {

        String timeStamp =
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                        .format(new Date());

        reportName = "Test_Report_" + timeStamp + ".html";

        sparkReporter =
                new ExtentSparkReporter(
                        System.getProperty("user.dir")
                                + "/reports/"
                                + reportName
                );

        sparkReporter.config().setDocumentTitle(
                "OpenCart Automation Report");

        sparkReporter.config().setReportName(
                "Functional Testing Report");

        sparkReporter.config().setTheme(
                Theme.DARK
        );

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

        extent.setSystemInfo(
                "Application",
                "OpenCart"
        );

        extent.setSystemInfo(
                "Environment",
                "QA"
        );

        extent.setSystemInfo(
                "User",
                System.getProperty("user.name")
        );

        String os =
                context.getCurrentXmlTest()
                        .getParameter("os");

        String browser =
                context.getCurrentXmlTest()
                        .getParameter("br");

        extent.setSystemInfo(
                "Operating System",
                os
        );

        extent.setSystemInfo(
                "Browser",
                browser
        );
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test = extent.createTest(
                result.getName()
        );

        test.pass(
                "Test Passed"
        );
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test = extent.createTest(
                result.getName()
        );

        test.fail(
                result.getThrowable()
        );

        try {

            String imgPath =
                    new Screenshort()
                            .captureScreenshot(
                                    result.getName()
                            );

            test.addScreenCaptureFromPath(
                    imgPath
            );

        }

        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        test = extent.createTest(
                result.getName()
        );

        test.skip(
                "Test Skipped"
        );
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }

}