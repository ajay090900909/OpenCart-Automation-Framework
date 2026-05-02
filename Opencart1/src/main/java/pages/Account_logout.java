package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_logout extends Base.basepage {
    public Account_logout(WebDriver driver){


        super(driver);
    }

     @FindBy(xpath="//h1[normalize-space()='Account Logout']")
    WebElement Account_logout ;


    @FindBy(xpath="//*[@id=\"column-right\"]/div/a[1]")WebElement login;




    public String  Account_logout_pg_Title(){

        return Account_logout.getText();



    }


    public void click_login(){

        login.click();


    }




}
