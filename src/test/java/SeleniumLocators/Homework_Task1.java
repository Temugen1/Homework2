package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework_Task1 {
    public static void main(String[] args) throws InterruptedException {
        /*
            "https://demoqa.com/text-box"
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        WebElement fullName=driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Temugen Otgonbat");
        WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("Ahmet@gmail.com");
        WebElement address=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("123 main Street ");
        WebElement permanentAdress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAdress.sendKeys("321 main Street");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);
        submitButton.click();
        WebElement nameHeader=driver.findElement(By.xpath("//p[@id='name']"));
        if (fullName.isDisplayed()){
            System.out.println(nameHeader.getText());
        }
        WebElement emailheader=driver.findElement(By.xpath("//p[@id='email']"));
        if (email.isDisplayed()){
            System.out.println(emailheader.getText());
        }
        WebElement addressHeader=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if (address.isDisplayed()){
            System.out.println(addressHeader.getText());
        }
        WebElement permanentHeader=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if (permanentAdress.isDisplayed()){
            System.out.println(permanentHeader.getText());
        }
        driver.quit();









    }
}
