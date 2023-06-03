package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultiWindows {
    @Test
    public void switchMultiWindowsPrac() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        System.out.println(driver.getTitle());
        String mainPage = driver.getWindowHandle();
        Set<String> allPage = driver.getWindowHandles();
        for (String Idcourse : allPage) {
            if (!Idcourse.equals(mainPage)) {
                driver.switchTo().window(Idcourse);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver, "Contact us");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        BrowserUtils.switchByTitle(driver, "Kickstart Your Tech Career with Our Top-Rated Coding Bootcamp");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver, "Courses");
        System.out.println(driver.getTitle());
    }

    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        button4.click();
        BrowserUtils.switchByTitle(driver, "Basic");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Temugen");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Otgonbat");
        WebElement gender = driver.findElement(By.xpath("//input[@id='malerb']"));
        gender.click();
        WebElement language = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        language.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("temugent@gmail.com");
        WebElement pass = driver.findElement(By.cssSelector("#password"));
        pass.sendKeys("Ahmed123");
        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.scrollWIthJs(driver, registerButton);
        registerButton.click();
        //WebElement registerMgs = driver.findElement(By.cssSelector("#msg"));
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#msg"))), "Registration is Successful");
//        Assert.assertEquals(BrowserUtils.getText(registerMgs), "Registration is Successful");
        BrowserUtils.switchByTitle(driver, "Window Handles");
        // WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//h1[@itemprop='name']"))), "Window Handles Practice");
//        Assert.assertEquals(BrowserUtils.getText(header), "Window Handles Practice");
        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        Thread.sleep(3000);
        WebElement clickMebutton = driver.findElement(By.cssSelector("#promptBox"));
        clickMebutton.click();
        driver.quit();


    }
}
