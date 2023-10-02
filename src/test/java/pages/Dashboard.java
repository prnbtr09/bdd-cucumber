package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {


    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Products']")
    public WebElement productsLabel;


    @FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
    public WebElement backPack;
}
