package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPrac() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickhere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickhere.click();
        WebElement newWindow = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(newWindow));// Open new Window
        System.out.println(driver.getWindowHandle()); // main page ID --> The Internet
        //3B69A73100F0A80658589952EA07E1C9-->mainPageID
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id : allPagesID) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        newWindow = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(newWindow));


//        String expected ="New Window";
//        Assert.assertEquals(BrowserUtils.getText(newWindow),expected);


    }

    @Test
    public void prac() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2 = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        button2.click();
        String mainId = driver.getWindowHandle();
        Set<String> allPageId = driver.getWindowHandles();
        Thread.sleep(2000);
        for (String id : allPageId) {
            if (!id.equals(mainId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(driver.findElement
                (By.xpath("//h1[@class='post-title entry-title']"))), "AlertsDemo");
        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");
        WebElement alertclick = driver.findElement(By.xpath("//button[@id='alertBox']"));
        alertclick.click();
    }
}
