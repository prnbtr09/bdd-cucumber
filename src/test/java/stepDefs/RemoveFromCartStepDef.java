package stepDefs;

import di.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RemoveFromCartStepDef {


    private WebDriver driver;
    private Context context;

    public RemoveFromCartStepDef(Context context) {
        driver = CreateDriver.getInstance().getDriver();
        this.context = context;
    }


    @When("user remove item from cart")
    public void addToCart() {

        WebElement removeCart = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + context.getContext("itemName") + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
        removeCart.click();
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + context.getContext("itemName") + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
        context.setContext("addToCartText", addToCart.getText());
    }

}
