package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPrac {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        Thread.sleep(3000);
        password.sendKeys("demo");
        WebElement submit=driver.findElement(By.xpath("//button"));
        Thread.sleep(3000);
        submit.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Dashboard");
        driver.quit();
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("DEMO!!!");
        WebElement submit=driver.findElement(By.xpath("//button"));
        submit.click();
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.xpath("//div[@id='alert']"));
        String actual = error.getText().trim();
        Assert.assertEquals(actual, "No match for Username and/or Password.");

    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement submit=driver.findElement(By.xpath("//button"));
        submit.click();
        Thread.sleep(3000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement cataloge = driver.findElement(By.cssSelector("#menu-catalog"));
        cataloge.click();
        Thread.sleep(3000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());


    }

    @Test
    public void validateBoxesFunctions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement submit=driver.findElement(By.xpath("//button"));
        submit.click();
        Thread.sleep(3000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement cataloge = driver.findElement(By.cssSelector("#menu-catalog"));
        cataloge.click();
        Thread.sleep(3000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Thread.sleep(2000);
        for (int x = 1; x < checkbox.size(); x++) {
            Thread.sleep(2000);
            Assert.assertTrue(!checkbox.get(x).isSelected() && checkbox.get(x).isEnabled() && checkbox.get(x).isDisplayed());
            checkbox.get(x).click();
            Assert.assertTrue(checkbox.get(x).isSelected());
            checkbox.get(x).sendKeys(Keys.ARROW_DOWN);


        }

    }

    @Test
    public void ascendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement submit=driver.findElement(By.xpath("//button"));
        submit.click();
        Thread.sleep(3000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement cataloge = driver.findElement(By.cssSelector("#menu-catalog"));
        cataloge.click();
        Thread.sleep(3000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        Thread.sleep(2000);

        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        List<WebElement> names = driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i < names.size(); i++) {
            actualList.add(names.get(i).getText().toLowerCase().trim());
            expectedList.add(names.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedList);
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void DescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement login = driver.findElement(By.cssSelector("#input-username"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement submit=driver.findElement(By.xpath("//button"));
        submit.click();
        Thread.sleep(3000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement cataloge = driver.findElement(By.cssSelector("#menu-catalog"));
        cataloge.click();
        Thread.sleep(3000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        Thread.sleep(2000);
        WebElement productName=driver.findElement(By.xpath("//a[.='Product Name']"));
        productName.click();
        Thread.sleep(3000);
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        List<WebElement> names = driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i < names.size(); i++) {
            actualList.add(names.get(i).getText().toLowerCase().trim());
            expectedList.add(names.get(i).getText().toLowerCase().trim());
        }
        System.out.println(actualList);
        System.out.println(expectedList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        Assert.assertEquals(actualList, expectedList);
    }
}
