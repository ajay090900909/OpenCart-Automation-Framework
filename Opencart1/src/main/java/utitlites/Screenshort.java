package utitlites;

import Base.local_driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshort {
    WebDriver driver ;


    public String captureScreenshot( String Test_name) {


        String path = "Screenshots/" + Test_name + ".png";
        try {

            driver= local_driver.getDriver();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);

        } catch (IOException e) {
            e.printStackTrace();


        }

        return path;

    }
       }

