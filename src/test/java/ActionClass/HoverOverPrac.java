package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOverPrac {
    @Test
    public void pracMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();

        List<WebElement> allImg = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String, String> product = new HashMap<>();
        for (int x = 0; x < allImg.size(); x++) {
            Thread.sleep(1000);
            actions.moveToElement(allImg.get(x)).perform();
            product.put(BrowserUtils.getText(allNames.get(x)),BrowserUtils.getText(allPrices.get(x)));

        }System.out.println(product);
        driver.quit();


    }
}
