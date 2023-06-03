package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocatorPrac {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Temugen");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("Temugen12345678@gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("773-773-733");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("QWERTYU");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPass.sendKeys("QWERTYU");
        WebElement box = driver.findElement(By.xpath("//input[@value='0']"));
        box.click();
        WebElement privacy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacy.click();
        WebElement confirm = driver.findElement(By.xpath("//input[@type='submit']"));
        confirm.click();
        WebElement continu = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continu.click();
        Thread.sleep(3000);
        String CurrentURL = driver.getCurrentUrl();
        String expectedURLi = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(CurrentURL.equals(expectedURLi) ? "Correct" : "Wrong");
        driver.quit();

    }
}
