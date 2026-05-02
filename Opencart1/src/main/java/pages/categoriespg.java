package pages;

import Base.basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class categoriespg extends basepage {
    public categoriespg(WebDriver driver){
        super(driver);

    }


    @FindBy(xpath="//*[@id=\"category\"]")
    WebElement category;


    public boolean category_page(){

        return category.
                isDisplayed();
    }



















}
