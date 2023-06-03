package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework_Task3 {
    /*
    https://www.saucedemo.com/
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.saucedemo.com/inventory.html";
        System.out.println(actualURL.equals(expectedURL)?"Correct":"Wrong");
        driver.quit();


    }
}
