package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class my_accountpg extends Base.basepage {
    public my_accountpg(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h1[text()='My Account']")
    WebElement my_account;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logout;

    public  boolean isMyAccountpageExists() {

        return my_account.isDisplayed();
    }


    public WebElement logout(){
        return logout;

    }



















}













