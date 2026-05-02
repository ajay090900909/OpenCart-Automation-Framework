package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class local_driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser, String execution) {

        try {

            if (execution.equalsIgnoreCase("local")) {

                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new ChromeDriver());
                } else if (browser.equalsIgnoreCase("edge")) {
                    driver.set(new EdgeDriver());
                }

            } else if (execution.equalsIgnoreCase("remote")) {



                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new RemoteWebDriver(
                            new URL("http://localhost:4444"),
                            new ChromeOptions()
                    ));
                } else if (browser.equalsIgnoreCase("Firefox")) {
                    driver.set(new RemoteWebDriver(
                            new URL("http://localhost:4444"),
                            new FirefoxOptions()
                    ));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void tearDown() {
        driver.get().quit();
    }









}




