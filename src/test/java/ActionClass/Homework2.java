package ActionClass;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework2 {
    @Test
    public void HW2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Web Orders Login";
//        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement button = driver.findElement(By.xpath("//input[@class='button']"));
        button.click();
        BrowserUtils.switchByTitle(driver, "Web Orders");
        WebElement header1 = driver.findElement(By.xpath("//h2"));
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(BrowserUtils.getText(header1), expectedHeader);
    }

    @Test
    public void tas2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();
        WebElement viewAllProduct = driver.findElement(By.xpath("//a[.='View all products']"));
        Thread.sleep(3000);
        viewAllProduct.click();
        viewAllProduct = driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProduct.isSelected();
        WebElement header = driver.findElement(By.xpath("//div//h2"));
        String expectedHeader = "List of Products";
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        String actualURL = driver.getCurrentUrl();
        // String expectedURL= "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        Assert.assertTrue(actualURL.contains("Product"));


    }

    @Test
    public void task3() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();
        WebElement viewAll = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        viewAll.click();
        String defaultContains = driver.getCurrentUrl();
        WebElement viewProductLink = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        viewProductLink.click();
        String productLink = driver.getCurrentUrl();
        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();
        String processLink = driver.getCurrentUrl();
        String dEfault = "Default.aspx";
        Assert.assertTrue(defaultContains.contains(dEfault));
        String product = "Products.aspx";
        Assert.assertTrue(productLink.contains(product));
        String process = "Process.aspx";
        Assert.assertTrue(processLink.contains(process));



    }
    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        login.click();
        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();
        WebElement productSelect=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(productSelect,"ScreenSaver","value");
        WebElement quantity=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
        quantity.sendKeys("5");
        WebElement name=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        name.sendKeys("CodeFish IT School");
        WebElement street=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement State=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        State.sendKeys("IL");
        WebElement zipcode= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"))  ;
        zipcode.sendKeys("60018");
        WebElement masterCard=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCard.click();
        WebElement cardNumber=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement date=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        date.sendKeys("03/24");
        WebElement process=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        Thread.sleep(2000);
        process.click();
        WebElement confirmation=driver.findElement(By.xpath("//strong"));
        String expectedMsg="New order has been successfully added.";
        Assert.assertEquals(BrowserUtils.getText(confirmation),expectedMsg);
        WebElement viewAll=driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAll.click();
        WebElement viewAllOrder=driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrder.click();

        WebElement nameConfirm=driver.findElement(By.xpath("//td[.='CodeFish IT School']"));
        Thread.sleep(2000);
        //name=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));

        Assert.assertEquals(nameConfirm.getText(),BrowserUtils.getText(nameConfirm));
        WebElement screenSaver2=driver.findElement(By.xpath("//td[.='ScreenSaver']"));
        Assert.assertEquals(BrowserUtils.getText(screenSaver2),"ScreenSaver");
        WebElement date2=driver.findElement(By.xpath("//td[.='06/03/2023']"));
        Assert.assertEquals(BrowserUtils.getText(date2),"06/03/2023");
        WebElement address2=driver.findElement(By.xpath("//td[.='2200 E devon']"));
        Assert.assertEquals(BrowserUtils.getText(address2),"2200 E devon");
        WebElement city2=driver.findElement(By.xpath("//td[.='Des Plaines']"));
        Assert.assertEquals(BrowserUtils.getText(city2),"Des Plaines");
        WebElement state2=driver.findElement(By.xpath("//td[.='IL']"));
        Assert.assertEquals(BrowserUtils.getText(state2),"IL");
        WebElement zipcode2=driver.findElement(By.xpath("//td[.='60018']"));
        Assert.assertEquals(BrowserUtils.getText(zipcode2),"60018");
        WebElement mastercard2=driver.findElement(By.xpath("//td[.='MasterCard']"));
        Assert.assertEquals(BrowserUtils.getText(mastercard2),"MasterCard");
        WebElement cardNumber2=driver.findElement(By.xpath("//td[.='444993876233']"));
        Assert.assertEquals(BrowserUtils.getText(cardNumber2),"444993876233");
        WebElement expDate=driver.findElement(By.xpath("//td[.='03/24']"));
        Assert.assertEquals(BrowserUtils.getText(expDate),"03/24");



































    }

}
