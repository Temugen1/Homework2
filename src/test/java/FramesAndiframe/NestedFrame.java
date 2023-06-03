package FramesAndiframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void practice1() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins-*");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement iframeLeft = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(left.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle"); // middle frame
        WebElement middle = driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right"); // right frame
        WebElement right = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));
//        driver.switchTo().parentFrame(); //TOP FRAME
//        driver.switchTo().parentFrame(); //MAIN FRAME
        driver.switchTo().defaultContent(); // this will go the main HTML no matter what
        driver.switchTo().frame("frame-bottom"); //bottom frame
        WebElement bottom = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));


    }
}
