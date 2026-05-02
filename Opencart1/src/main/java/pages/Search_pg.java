package pages;

import Base.basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_pg extends basepage {

    public Search_pg(WebDriver driver){

        super(driver);




    }


    @FindBy(xpath="//img[@title='iPhone']")
    WebElement iphone_img;

    @FindBy(css="div[id='content'] p") WebElement
    product_not_found;







public boolean iphone_isDisplayed(){


    return iphone_img.isDisplayed();
}




public void iphone_click(){

    iphone_img.click();
}





public boolean product_not_found_msg(){


    return product_not_found.isDisplayed();
}













}
