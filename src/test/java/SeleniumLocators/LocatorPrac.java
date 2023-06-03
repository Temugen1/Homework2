package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPrac {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement((By.name("firstname")));
        firstName.sendKeys("Temugen");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("THOMAS");
        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement eXP = driver.findElement(By.id("exp-3"));
        eXP.click();
        WebElement date =driver.findElement(By.id("datepicker"));
        date.sendKeys("5/16/2023");
        WebElement profession = driver.findElement(By.id("profession-0"));
        profession.click();
        WebElement auto= driver.findElement(By.id("tool-2"));
        auto.click();
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Asia");
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        String actualURL =driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualURL.equals(expectedURL)? "Correct":"Wrong");
        driver.quit();















    }
}
