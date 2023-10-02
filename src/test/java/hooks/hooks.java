package hooks;

import driver.driverManager.CreateDriver;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class hooks {
    public static WebDriver driver;

    @Before(value = "@chrome", order = 0)
    public void chromeSetUp(Scenario scenario) {
        System.out.println("I am in chrome before scenario");
        String browser = "chrome";
        CreateDriver.getInstance().setDriver(browser);
        driver = CreateDriver.getInstance().getDriver();
    }


    @Before(value = "@firefox")
    public void firefoxSetUp(Scenario scenario) {
        System.out.println("I am in Firefox before scenario");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @After(value = "@chrome")
    public void chromeTearDown(Scenario scenario) {
        System.out.println("I am in chrome After Scenario");
        CreateDriver.getInstance().getDriver().quit();
        scenario.getStatus();

    }

    @After(value = "@firefox")
    public void fireFoxtearDown(Scenario scenario) {
        System.out.println("I am in Firefox After Scenario");
        driver.quit();
        scenario.getStatus();

    }


    @BeforeStep()
    public void actionBeforeEachStep() {
        System.out.println("I am in before step");
    }


    @AfterStep()
    public void actionPostEachStep() {
        System.out.println("I am in After step");
    }
}
