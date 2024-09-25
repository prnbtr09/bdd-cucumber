package seleniumInterviewChallenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Set;

public class AmazonUniqueImages {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Set<String> imagesAltText = new HashSet<>();
        String altText = driver.findElement(By.xpath("//li[@class='a-carousel-card' and @aria-hidden='false']//img")).getAttribute("alt");
        while (imagesAltText.add(altText)) {
            driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']")).click();
            altText = driver.findElement(By.xpath("//li[@class='a-carousel-card' and @aria-hidden='false']//img")).getAttribute("alt");
        }
    }
}
