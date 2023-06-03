package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPrac {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneway = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneway.click();
        Thread.sleep(3000);

        WebElement allOptions = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(allOptions, "4", "value");
        WebElement allDeparture = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select Departure = new Select(allDeparture);
        String expectedDeparture = "Acapulco".trim();
        Assert.assertEquals(Departure.getFirstSelectedOption().getText().trim(), expectedDeparture);
        BrowserUtils.selectBy(allDeparture, "Paris", "text");
        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(toPort, "San Francisco", "text");
        Thread.sleep(3000);
        WebElement flyDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(flyDate, "August", "text");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(day, "15", "text");
        WebElement landDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(landDate, "December", "text");
        WebElement landDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(landDate, "15", "text");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        WebElement allAirline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select validateAirline = new Select(allAirline);
        List<WebElement> ActualAirline = validateAirline.getOptions();
        List<String> ExpectedAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        Thread.sleep(2000);
        for (int x = 0; x < ActualAirline.size(); x++) {
            Assert.assertEquals(BrowserUtils.getText(ActualAirline.get(x)).trim(), ExpectedAirline.get(x).trim());
        }
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        BrowserUtils.selectBy(airline, "Unified Airlines", "text");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(3000);
        continueButton.click();
        WebElement msg = driver.findElement(By.xpath("//font[@size='4']"));
        Assert.assertEquals(BrowserUtils.getText(msg),"After flight finder - No Seats Available");

    }
    @Test
    public void validateOrderMessageNotPro() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneway = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneway.click();
        Thread.sleep(3000);
        WebElement allOptions = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(allOptions);
        Thread.sleep(3000);
        passenger.selectByVisibleText("4 ");
        WebElement allDeparture = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select Departure = new Select(allDeparture);
        Thread.sleep(3000);
        String expectedDeparture = "Acapulco".trim();
        Assert.assertEquals(Departure.getFirstSelectedOption().getText().trim(), expectedDeparture);
        Departure.selectByVisibleText("Paris");
        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select sf = new Select(toPort);
        sf.selectByVisibleText("San Francisco");
        Thread.sleep(3000);
        WebElement flyDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select flyingOut = new Select(flyDate);
        flyingOut.selectByVisibleText("August");
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select date = new Select(day);
        date.selectByVisibleText("15");
        Thread.sleep(2000);
        WebElement landDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select landing = new Select(landDate);
        Thread.sleep(3000);
        landing.selectByVisibleText("December");
        WebElement landDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Thread.sleep(2000);
        Select returnDate = new Select(landDay);
        returnDate.selectByVisibleText("15");
        Thread.sleep(2000);
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        Thread.sleep(2000);
        firstClass.click();
        WebElement allAirline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select validateAirline = new Select(allAirline);
        Thread.sleep(2000);
        List<WebElement> ActualAirline = validateAirline.getOptions();
        List<String> ExpectedAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        Thread.sleep(2000);
        for (int x = 0; x < ActualAirline.size(); x++) {
            Assert.assertEquals(ActualAirline.get(x).getText().trim(), ExpectedAirline.get(x).trim());
        }
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select Unified = new Select(airline);
        Unified.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(3000);
        continueButton.click();
        WebElement msg = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMsg = msg.getText().trim();
        String expectedMsg = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}

