package driver.browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager implements BrowserManager {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
         ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }
}
