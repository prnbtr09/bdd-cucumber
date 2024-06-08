package stepDefs;


import di.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.get(url);
    }


    @Given("user has entered credentials")
    public void enterCredentials(DataTable table) {
        List<Map<String, String>> credentials = table.asMaps(String.class, String.class);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(credentials.get(0).get("UserName"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(credentials.get(0).get("Password"));
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
