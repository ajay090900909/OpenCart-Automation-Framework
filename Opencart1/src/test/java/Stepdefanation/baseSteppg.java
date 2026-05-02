package Stepdefanation;

import Base.local_driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.*;
import utitlites.Waits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseSteppg {

    Account_logout account_logout;
    Forgot_passwordpg forgot_passwordpg;
    homepg homepg;
    loginpg loginpg;
    my_accountpg my_accountpg;
    Waits wait;
    WebDriver driver;
    categoriespg categoriespg;
    Search_pg search_pg;
    Cart_page cart_page;
    Properties ps;
    FileInputStream fstream;






    @Before
    public void setup() throws IOException {

        fstream=new FileInputStream("C:\\jay\\My projects\\Opencart1\\src\\test\\resources\\config.properties");
        ps=new Properties();
        ps.load(fstream);
        String browser = ps.getProperty("browser");
        String execution = ps.getProperty("execution");

        local_driver.initDriver(browser,execution);
        driver=local_driver.getDriver();
        account_logout = new Account_logout(driver);
        forgot_passwordpg = new Forgot_passwordpg(driver);
        homepg = new homepg(driver);
        loginpg = new loginpg(driver);
        my_accountpg = new my_accountpg(driver);
         wait=new Waits(driver);
         categoriespg=new categoriespg(driver);
         search_pg=new Search_pg(driver);
         cart_page=new Cart_page(driver);









    }
    public void User_login(){
        homepg.click_account();
        homepg.click_login();
        loginpg.setEmail(ps.getProperty("email"));
        loginpg.setPassword(ps.getProperty("password"));
        loginpg.submit();


    }

    public void login_with_invalid_data(){
        homepg.click_account();
        homepg.click_login();
        loginpg.setEmail("jay@123");
        loginpg.setPassword("passs");
        loginpg.submit();


    }

    @After
    public void teardown() throws IOException {
        local_driver.tearDown();
    }











}
