package pages;

import Base.basepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Cart_page extends basepage {

    public Cart_page(WebDriver driver) {

        super(driver);
    }

    //Elements
    @FindBy(xpath="//input[@name='quantity']") WebElement quantity;
    @FindBy(xpath="//i[@class='fa-solid fa-rotate']") WebElement update;
    @FindBy(xpath="//tfoot//tr[td[1][contains(text(),'Total')]]/td[2]") WebElement Before_total;








//methodes
    public void quantity(String qty) {WebElement qtyBox =quantity;qtyBox.clear();qtyBox.sendKeys(qty);}
    public void update(){update.click();}
    public String Before_total(){return  Before_total.getAttribute("value");}
    public String After_total(){return  Before_total.getAttribute("value");}



        By cartRows = By.xpath("//table//tbody//tr");


        public List<WebElement> getCartRows() {
            return driver.findElements(cartRows);
        }


        public double getUnitPrice(WebElement row) {
            String priceText = row.findElement(By.xpath("td[5]"))
                    .getText()
                    .replaceAll("[^0-9.]", "");
            return Double.parseDouble(priceText);
        }

        public int getQuantity(WebElement row) {
            String qty = row.findElement(By.xpath(".//input[@name='quantity']"))
                    .getAttribute("value");
            return Integer.parseInt(qty);
        }


        public double getTotal(WebElement row) {
            String totalText = row.findElement(By.xpath("td[6]"))
                    .getText()
                    .replaceAll("[^0-9.]", "");
            return Double.parseDouble(totalText);
        }

        public double validateCartAndGetGrandTotal() {

            List<WebElement> rows = getCartRows();
            double grandTotal = 0;

            for (WebElement row : rows) {

                double price = getUnitPrice(row);
                int qty = getQuantity(row);
                double total = getTotal(row);

                if (Math.abs(total - (price * qty)) > 0.01) {
                    throw new AssertionError("Price mismatch in cart row");
                }

                grandTotal += total;
            }

            return grandTotal;
        }


    public List<String> getAllProductNames() {

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@class='table table-bordered']//tbody//tr")
        );

        List<String> productNames = new ArrayList<>();

        for (WebElement row : rows) {

            String name = row.findElement(By.xpath("td[2]")).getText();
            productNames.add(name);
        }

        return productNames;
    }
    }










