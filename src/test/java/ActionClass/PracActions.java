package ActionClass;

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

public class PracActions {
    @Test
    public void Task1DragAndDrop() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement validateBigBox = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']//p[contains(text(),'Drop here')]"));
        String acutalmsg = BrowserUtils.getText(validateBigBox);
        String expectedmsg = "Drop here";
        Assert.assertEquals(acutalmsg, expectedmsg);
        WebElement dragSquare = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        actions.dragAndDrop(dragSquare, validateBigBox).perform();

        WebElement droppedMSg = driver.findElement(By.xpath("//div[@id='droppable']//p[.='Dropped!']"));
        String acutalMsg = BrowserUtils.getText(droppedMSg);
        String expected = "Dropped!";
        Assert.assertEquals(acutalMsg, expected);

        String acutalcolor = dropBox.getCssValue("background-color").trim();
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(acutalcolor, expectedColor);
    }

    @Test
    public void Task2ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);

        WebElement accept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();
        Thread.sleep(3000);
        WebElement notAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));

        String expectedMSG = "Not Acceptable";
        Assert.assertEquals(BrowserUtils.getText(notAcceptable), expectedMSG);

        WebElement drophereMsg = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div//div[@class='drop-box ui-droppable']//p[.='Drop here']"));
        String expectedMsg = "Drop here";
        Assert.assertEquals(BrowserUtils.getText(drophereMsg), expectedMsg);
        actions.clickAndHold(notAcceptable).moveToElement(drophereMsg).release().perform();

        String expectedmsg = "Drop here";
        Assert.assertEquals(BrowserUtils.getText(drophereMsg), expectedmsg);


    }
}
