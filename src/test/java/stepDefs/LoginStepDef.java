package stepDefs;


import di.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Dashboard;
import pages.LoginPage;

import java.util.List;
import java.util.Map;


public class LoginStepDef {
    private LoginPage loginPage;
    private Dashboard dashboard;
    private WebDriver driver;

    private Context context;


    public LoginStepDef(Context context) {
        driver = CreateDriver.getInstance().getDriver();
        driver.manage().window().maximize();
        this.context = context;
    }

    @Given("user has launched url {string}")
    public void launchURL(String url) {
        Assert.assertTrue(false);
        driver.get(url);
    }


    @Given("user has entered credentials")
    public void enterCredentials(DataTable dataTable) {
        loginPage = new LoginPage(driver);
        Map<String, String> map = dataTable.asMap();
        loginPage.userName.sendKeys(map.get("UserName"));
        loginPage.password.sendKeys(map.get("password"));
    }

    @Then("user verifies following Products")
    public void verifyData(List<String> products) {

        for (String product : products) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + product + "']/ancestor::div/following-sibling::div[@class='pricebar']/button")).isDisplayed());
        }

    }

    @Then("user verifies following Products and respective prices")
    public void verifyProductPrice(Map<String, String> productPriceMap) {

        for (Map.Entry<String, String> entry : productPriceMap.entrySet()) {
            WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + entry.getKey() + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
            Assert.assertTrue(productName.findElement(By.xpath("preceding-sibling::div")).getText().equals(entry.getValue()));
        }
    }

    @Then("user verifies following Products and respective prices with Label")
    public void verifyProductPriceUsingLabel(List<Map<String, String>> listOfMap) {
        for (Map<String, String> row : listOfMap) {
            WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + row.get("productName") + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
            Assert.assertTrue(productName.findElement(By.xpath("preceding-sibling::div")).getText().equals(row.get("productPrice")));
        }
    }

    @Then("user verifies following Products and respective prices with Label as List")
    public void verifyProductPriceUsingLabelList(List<List<String>> listOfList) {
        for (int i = 0; i < listOfList.size(); i++) {


            WebElement productName = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + listOfList.get(i).get(0) + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
            Assert.assertTrue(productName.findElement(By.xpath("preceding-sibling::div")).getText().equals(listOfList.get(i).get(1)));
        }

    }

    @Given("user has entered username {string} and password {string}")
    public void enteredCredentials1(String userName, String password) {
        loginPage = new LoginPage(driver);
        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
    }

    @When("User click on Login")
    public void clickOnLogin() {
        loginPage.loginButton.click();
    }

    @Then("user verify {string} on Dashboard")
    public void userVerifyDashboard(String text) {
        dashboard = new Dashboard(driver);
        Assert.assertTrue(dashboard.productsLabel.isDisplayed());
        System.out.println("resolved issues of user2");
    }

    @And("user closes the browser")
    public void quitBrowser() {
        driver.quit();
    }

    @And("user has pressed button {int}")
    public void pressButton(int button) {

    }

    @When("user has entered {string}")
    public void enterText(String text) {
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys(text);
    }

    @Then("user verify google Search List")
    public void verifyGoogleSearchList() {
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@role='listbox']//li[1]")).isDisplayed());

    }

}
