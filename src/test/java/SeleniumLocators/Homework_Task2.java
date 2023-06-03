package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework_Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        WebElement errorMsg=driver.findElement(By.xpath("//h3[@data-test='error']"));
        if (errorMsg.isDisplayed()){
            System.out.println(errorMsg.getText());
        }
        driver.quit();



    }
}
