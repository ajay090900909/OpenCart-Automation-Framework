package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forgot_passwordpg extends Base.basepage {





    public Forgot_passwordpg(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
    WebElement page_title;





public boolean FP_page_title(){
return page_title.isDisplayed();







}



























}
