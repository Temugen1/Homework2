package FramesAndiframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePrac {
    @Test
    public void prac() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I still love Java");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(BrowserUtils.getText(header));

    }

    @Test
    public void iframParc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavillion = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavillion.click();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        Actions actions = new Actions(driver);
        WebElement selenium = driver.findElement(By.xpath("//span[.='Selenium']"));
        actions.moveToElement(selenium).perform();
        WebElement Python = driver.findElement(By.xpath("//span[.='Selenium-Python']"));
        actions.click(Python).perform();
        BrowserUtils.switchByTitle(driver, "Selenium-Python Tutorial - qavalidation");
        WebElement header = driver.findElement(By.xpath("//h1"));
        String expectedheader = "Selenium-Python Tutorial";
        Assert.assertEquals(BrowserUtils.getText(header), expectedheader);
        List<WebElement> Link = driver.findElements(By.xpath("//p//a"));
        for (int x = 0; x < Link.size(); x++) {
            String allLinks = BrowserUtils.getText(Link.get(x));
            System.out.println(allLinks);
        }

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement catagory1 = driver.findElement(By.xpath("//a[.='Category1']"));
        catagory1.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        WebElement header2 = driver.findElement(By.xpath("//h1"));
        String expected2 = "Category Archives: SeleniumTesting";
        Assert.assertEquals(BrowserUtils.getText(header2), expected2);
        Thread.sleep(3000);
        List<WebElement> Alllink = driver.findElements(By.xpath("//h3//a"));
        for (WebElement clickable : Alllink) {
            System.out.println(BrowserUtils.getText(clickable));
        }
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement insidetheBox = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(insidetheBox));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement catagory3 = driver.findElement(By.xpath("//a[.='Category3']"));
        catagory3.click();
        BrowserUtils.switchByTitle(driver, "SoftwareTesting Archives - qavalidation");
        WebElement header3 = driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getText(header3));


    }
}
