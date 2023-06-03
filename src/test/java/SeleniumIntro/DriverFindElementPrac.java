package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPrac {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //
        driver.get("https://the-internet.herokuapp.com/"); //url
        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int count = 0;
        for (WebElement clickable : allLinks) {
            count++;
            System.out.println(clickable.getText());
        }
        System.out.println(count);
        int count1 = 0;
        List<WebElement> length12 = driver.findElements(By.xpath("//li"));
        for (WebElement lessthan12 : length12) {
            if (lessthan12.getText().length() >= 12) {
                System.out.println(lessthan12.getText());
                count1++;
            }
        }
        System.out.println(count1);
        driver.quit();


    }
}
