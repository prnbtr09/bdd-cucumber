package hooks;

import com.aventstack.extentreports.service.ExtentService;
import driver.driverManager.CreateDriver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class hooks {
    public static WebDriver driver;


    @Before(value = "@chrome", order = 0)
    public void chromeSetUp(Scenario scenario) {
        System.out.println("I am in chrome before scenario");
        String browser = "chrome";
        CreateDriver.getInstance().setDriver(browser);
        driver = CreateDriver.getInstance().getDriver();
        ExtentService.getInstance().setSystemInfo("os", "windows");
    }


    @Before(value = "@firefox")
    public void firefoxSetUp(Scenario scenario) {
        System.out.println("I am in Firefox before scenario");
        String browser = "firefox";
        CreateDriver.getInstance().setDriver(browser);
        driver = CreateDriver.getInstance().getDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @After(value = "@chrome")
    public void chromeTearDown(Scenario scenario) {
        System.out.println("I am in chrome After Scenario");
//                scenario.attach(output, "text/html", scenario.toString());
        CreateDriver.getInstance().getDriver().quit();
        scenario.getStatus();
    }

    @After(value = "@firefox")
    public void firefoxtearDown(Scenario scenario) {
        System.out.println("I am in Firefox After Scenario");
        driver.quit();
        scenario.getStatus();


    }


    @BeforeStep()
    public void actionBeforeEachStep() {
        System.out.println("I am in before step");
    }


    @AfterStep()
    public synchronized void actionPostEachStep(Scenario scenario) {
        if (!scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshot.toString());
        }
    }
}
