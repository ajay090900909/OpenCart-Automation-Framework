package Stepdefanation;

import Base.local_driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.Search_pg;
import utitlites.Waits;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class MyStepdefs extends baseSteppg {

    baseSteppg basepg;



    @Before
    public void setup() throws IOException {
        super.setup();

    }
    @After
    public void teardown() throws IOException {
        super.teardown();
    }


    //Login_Functionality

    @When("user opens URL {string}")
    public void userOpensURL(String url) {
        local_driver.getDriver().get(url);
    }


    @And("user clicks on login link")
    public void userClicksOnLoginLink() {
        homepg.click_account();
        homepg.click_login();


    }

    @And("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String Email, String Password) {
        loginpg.setEmail(Email);
        loginpg.setPassword(Password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {
        wait.wait_for_click(loginpg.submit()).click();


    }

    @Then("user should be redirected to dashboard")
    public void userShouldBeRedirectedToDashboard() {
        wait.waitforTitle("My Account");
        Assert.assertEquals(driver.getTitle(), "My Account");
        WebElement logout = wait.waitforVisibility(my_accountpg.logout());

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true); window.scrollBy(0,1000); ",
                logout
        );


        wait.wait_for_click(logout);
        logout.click();


    }




    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String error_message) {

        SoftAssert sf = new SoftAssert();
        sf.assertEquals(error_message, loginpg.Error_message());

    }


    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {


        WebElement logout = wait.waitforVisibility(my_accountpg.logout());

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true); window.scrollBy(0,1000);",
                logout
        );


        wait.wait_for_click(logout);
        logout.click();


    }




    @Then("user should logout Seccusfully and should see the page title as {string}")
    public void userShouldLogoutSeccusfullyAndShouldSeeThePageTitleAs(String Expected_title) {
        Assert.assertEquals(Expected_title, account_logout.Account_logout_pg_Title());


    }

    @And("user clicks on Forgot Password")
    public void userClicksOnForgotPassword() {
        loginpg.Forgot_password();

    }


    @Then("Forgot password page should display")
    public void forgotPasswordPageShouldDisplay() {
        Assert.assertEquals(driver.getTitle(), "Forgot Your Password?");



    }




    //Search_Functionality


    @When("user searches for {string}")
    public void userSearchesFor(String product) {
        homepg.Search(product);
       wait.wait_for_click( homepg.click_Search_button());


    }

    @Then("relevant products should be displayed")
    public void relevantProductsShouldBeDisplayed() {
       Assert.assertEquals( search_pg.iphone_isDisplayed(),true);


    }

    @Then("no product found message should be displayed")
    public void noProductFoundMessageShouldBeDisplayed() {
            Assert.assertEquals(search_pg.product_not_found_msg(),true);

    }

    @When("user types {string} in search box")
    public void userTypesInSearchBox(String text) {
        homepg.Search(text);
        wait.wait_for_click(homepg.click_Search_button());


    }


    //Cart_Functionality

    @When("user clicks on Add to Cart")
    public void userClicksOnAddToCart() {


         homepg.userClicksOnAddToCart();

    }

    @Then("product should be added to cart")
    public void productShouldBeAddedToCart() {

        String actual = homepg.Success_msg();

        Assert.assertTrue(actual.contains("Success: You have added MacBook"));


    }

    @When("user adds {string} to cart")
    public void userAddsToCart(String arg0) {
        homepg.userClicksOnAddToCart();

    }
    @And("user navigates to cart page")
    public void userNavigatesToCartPage() {

        homepg.cart_button();
        homepg.view_cart();
    }


    @When("user updates quantity to {int}")
    public void userUpdatesQuantityTo(int qu) {

        String before_total= cart_page.Before_total();
        String Quantity = String.valueOf(qu);
        cart_page.quantity(Quantity);
        cart_page.update();
        String after_total= cart_page.After_total();
        Assert.assertNotEquals(before_total, after_total);
    }

    @Then("cart total should be updated")
    public void cartTotalShouldBeUpdated() {
        Assert.assertEquals( homepg.Success_msg(),"Success: You have modified your shopping cart!");
    }

    @And("product is in cart")
    public void productIsInCart() {

        homepg.userClicksOnAddToCart();
    }

    @When("user removes the product")
    public void userRemovesTheProduct() {

        homepg.userClicksOnAddToCart();
        wait.wait_for_click(homepg.remove_button());


        Assert.assertNotEquals(homepg.Success_msg(),"Success: You have removed an item from your shopping cart!");
    }

    @Then("cart should be empty")
    public void cartShouldBeEmpty() {
        wait.waitforVisibility(homepg.Alert());
       Assert.assertEquals(homepg.Success_msg(),"Your shopping cart is empty!");
    }

    @And("user has added products to cart")
    public void userHasAddedProductsToCart() {



        List<String> products = cart_page.getAllProductNames();

            for (String product : products) {
                System.out.println(product);
            }
        }




    @Then("total price should be calculated correctly")
    public void totalPriceShouldBeCalculatedCorrectly() {
;

        double grandTotal =cart_page.validateCartAndGetGrandTotal();

        System.out.println("Grand Total: " + grandTotal);

    }






    @And("user enters invalid login details")
    public void userEntersInvalidLoginDetails() {
        homepg.click_account();
        homepg.click_login();
        loginpg.setEmail("jay@gmail.com");
        loginpg.setPassword("password");
        wait.wait_for_click(loginpg.submit()).click();


    }

    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String error_message) {
        Assert.assertEquals(loginpg.Error_message(),"Warning: No match for E-Mail Address and/or Password.");

    }
    @And("user submits empty form")
    public void userSubmitsEmptyForm() {
        homepg.click_account();
        homepg.click_login();
        wait.wait_for_click(loginpg.submit()).click();




    }

    @Then("required field messages should be shown")
    public void requiredFieldMessagesShouldBeShown() {
        Assert.assertEquals(loginpg.Error_message(),"Warning: No match for E-Mail Address and/or Password.");

    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        homepg.click_account();
        homepg.click_login();

    }

    @Then("login button should be disabled until fields are filled")
    public void loginButtonShouldBeDisabledUntilFieldsAreFilled() {

        Assert.assertEquals(loginpg.Login_bt_isDisplayed(),true);

    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String title) {
        Assert.assertEquals(driver.getTitle(),title);

    }

    @And("user logs in successfully")
    public void userLogsInSuccessfully() {

        homepg.click_account();
        homepg.click_login();
        loginpg.setEmail(ps.getProperty("email"));
        loginpg.setPassword(ps.getProperty("password"));
        wait.wait_for_click(loginpg.submit()).click();


        Assert
               .assertEquals(my_accountpg.isMyAccountpageExists(), true);
       JavascriptExecutor js=(JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView(true);", my_accountpg.logout());
       my_accountpg.logout().click();

    }

    @Then("URL should contain {string}")
    public void urlShouldContain(String url) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean isPresent = wait.until(ExpectedConditions.urlContains(url));
            Assert.assertTrue(isPresent, "URL does not contain: " + url);
    }









}