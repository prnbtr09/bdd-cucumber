package stepDefs;

import di.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddToCartStepDef {
    private WebDriver driver;
    private Context context;

    public AddToCartStepDef(Context context) {
        driver = CreateDriver.getInstance().getDriver();
        this.context = context;
    }


    @When("user add {string} item to cart")
    public void addToCart(String item) throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + item + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
        context.setContext("itemName", item);
        Thread.sleep(10000);
        addToCart.click();

    }


    @Then("user verify the item is removed from cart")
    public void verifyItemInCart() {

//        addToCartTxt


        WebElement addToCart = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + context.getContext("itemName") + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
        Assert.assertEquals(addToCart.getText(), context.getContext("addToCartText"));
    }


}
