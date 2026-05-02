package utitlites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    WebDriver driver;
    WebDriverWait wait;



    public  Waits(WebDriver driver ){
        this.driver=driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }
    public WebElement waitforVisibility(WebElement element){

        return wait.until(ExpectedConditions.visibilityOf(element));

    }

  public WebElement wait_for_click(WebElement element ) {

      return wait.until(ExpectedConditions.elementToBeClickable(element));

  }

  public boolean waitforTitle(String title) {

        return wait.until(ExpectedConditions.titleContains(title));

  }






}
