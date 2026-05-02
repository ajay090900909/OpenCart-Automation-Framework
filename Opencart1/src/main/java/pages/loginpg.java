package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpg extends Base.basepage {
    public loginpg(WebDriver driver) {
        super(driver);

    }


    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement submit;
   @FindBy(xpath = "//*[@id=\"alert\"]") WebElement  Error;


    @FindBy(xpath="//div[@class='mb-3']//a[normalize-space()='Forgotten Password']")
    WebElement Forgot_password;





    // Methods

    public boolean Login_bt_isDisplayed(){
        return submit.isDisplayed();
    }
    public void setEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    public void setPassword(String  Enter_password) {
        password.sendKeys(Enter_password);
    }

    public WebElement submit() {
        return submit;
    }

    public String Error_message(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(Error));
            return errorMsg.getText().trim();
        }





    public void Forgot_password(){

        Forgot_password.click();


    }







}


