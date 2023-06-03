package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPrac {
    @Test
    public void prac() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()",yesButton);
        Actions actions = new Actions(driver);
        actions.click(yesButton).perform();
        WebElement confirmYes = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expected = "You have selected Yes";
        Assert.assertEquals(BrowserUtils.getText(confirmYes), expected);
        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        actions.click(impressiveButton).perform();
        WebElement confirmImpressive = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String expected1 = "You have selected Impressive";
        Assert.assertEquals(BrowserUtils.getText(confirmImpressive), expected1);

        WebElement noButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(!noButton.isEnabled());


    }

    @Test
    public void prac2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", copyRight);
        String expected = "Copyright © 2023";
        Assert.assertEquals(BrowserUtils.getText(copyRight), expected);
        WebElement apply = driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", apply);
        apply.click();
        Thread.sleep(2000);

        List<WebElement> ThreeOptions = driver.findElements(By.xpath("//h3[@class='lw-widget-in learnworlds-heading3 learnworlds-element learnworlds-heading3-small']"));
        List<String> expected1 = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");
        for (int x = 0; x < ThreeOptions.size(); x++) {

            Assert.assertEquals(BrowserUtils.getText(ThreeOptions.get(x)),expected1.get(x));
        }
        String acutal=BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(acutal,expectedTitle);


    }
}
