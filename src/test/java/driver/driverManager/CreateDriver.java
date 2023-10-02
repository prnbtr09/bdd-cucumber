package driver.driverManager;

import org.openqa.selenium.WebDriver;

public class CreateDriver {
    private static CreateDriver INSTANCE;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//    private WebDriver driver;

    private CreateDriver() {

    }

    public static synchronized CreateDriver getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CreateDriver();

        }
        return INSTANCE;
    }

    public void setDriver(String browser) {
        driver.set(DriverManager.getBrowserManager(browser).getDriver());
//        driver=DriverManager.getBrowserManager(browser).getDriver();
    }

    public WebDriver getDriver() {
        return driver.get();
//        return driver;
    }

}
