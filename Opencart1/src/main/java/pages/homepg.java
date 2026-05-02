package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class homepg extends Base.basepage {

    public homepg(WebDriver driver){

        super(driver);

    }

    //geting the elements
    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement myaccount;


    @FindBy(xpath="//a[normalize-space()='Register']") WebElement rejester;@FindBy(xpath="//a[normalize-space()='Login']") WebElement login;
    @FindBy(xpath="//*[@id=\"navbar-menu\"]/ul/li[1]/a") WebElement Desktops;
    @FindBy(xpath="//*[@id=\"navbar-menu\"]/ul/li[1]/div/ul/li[2]/a") WebElement show_all;
    @FindBy(xpath="//input[@placeholder='Search']") WebElement search;
    @FindBy(xpath="//button[@class='btn btn-light btn-lg']") WebElement Search_button;
    @FindBy(xpath="////div[@id='content']//div[1]//div[1]//div[2]//form[1]//div[1]//button[1]")
    WebElement Mackbook_Add;
    @FindBy(xpath ="//button[normalize-space()='1 item(s) - $602.00']")WebElement cart_button;
    @FindBy(xpath="//*[@id=\"alert\"]") WebElement homepg_alert;
    @FindBy(xpath ="//strong[normalize-space()='View Cart']") WebElement view_cart;
    @FindBy(xpath ="//i[@class='fa-solid fa-circle-xmark']") WebElement remove_button;
    @FindBy(xpath="//li[@class='text-center p-4']")WebElement cart_empty;




    public void cart_button_click(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cart_button));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cart_button);
        wait.until(ExpectedConditions.elementToBeClickable(cart_button));

    }
    public void click_account() {myaccount.click();}
    public void click_rejester() {rejester.click();}
    public void  click_login() {login.click();}
    public void Desktops(){Desktops.click();show_all.click();}
    public void Search(String text){search.sendKeys(text);}
    public WebElement click_Search_button(){return Search_button;}
    public WebElement mac(){return Mackbook_Add ;};
    public void userClicksOnAddToCart() {
        By macLocator = By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//form[1]//div[1]//button[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mac = wait.until(ExpectedConditions.visibilityOfElementLocated(macLocator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", mac);
        wait.until(ExpectedConditions.elementToBeClickable(mac));
        Actions actions = new Actions(driver);
        actions.moveToElement(mac).click().perform();
    }

    public void cart_button(){
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cart_button);
        wait.until(ExpectedConditions.elementToBeClickable(cart_button));
        cart_button.click();

    }

    public String Success_msg(){
        By successMsg = By.xpath("//div[contains(@class,'alert-success')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return msg.getText();
    }
    public WebElement Alert(){return homepg_alert ;}
    public void  view_cart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(view_cart));
        view_cart.click();
    }
    public WebElement remove_button(){return remove_button;}
    public String cart_empty(){return cart_empty.getText();}





































}










