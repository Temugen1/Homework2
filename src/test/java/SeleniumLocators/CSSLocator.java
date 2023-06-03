package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        WebElement watch = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        watch.sendKeys("Watch");
        WebElement searchButton = driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        searchButton.click();
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.etsy.com/search?q=Watch&ref=search_bar";
        System.out.println(actualURL.equals(expectedURL) ? "URL IS CORRECT" : "URL IS WRONG");
        driver.quit();


    }
}
