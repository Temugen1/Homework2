package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptMethods {
    @Test
    public void getTitle() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        System.out.println(driver.getTitle() + " with Selenium Method");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title") + " with javaScript");
    }

    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        Actions actions = new Actions(driver);
        actions.click(aboutUs).perform();
        driver.navigate().back();
        Thread.sleep(2000);
        aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUs.click();
        Thread.sleep(2000);
        driver.navigate().back();
        aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUs.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
        driver.quit();

    }

    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement whichCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", whichCourse);
        Thread.sleep(2000);
        whichCourse.click();
    }

}
