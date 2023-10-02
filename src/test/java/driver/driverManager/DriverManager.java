package driver.driverManager;

import driver.browserManager.BrowserManager;
import driver.browserManager.ChromeManager;
import driver.browserManager.FirefoxManager;

public class DriverManager {

    public static BrowserManager getBrowserManager(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeManager();
            case "firefox":
                return new FirefoxManager();
            default:
                throw new IllegalArgumentException("no matching browser");
        }

    }
}
