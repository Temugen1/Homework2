package ActionClass;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class DragAndDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMsg= BrowserUtils.getText(orangeBox);
        String expectedMsg="... Or here.";
        Assert.assertEquals(actualMsg,expectedMsg);

        String acutalColor=orangeBox.getCssValue("background-color");
        String expectedColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(acutalColor,expectedColor);

        WebElement dragCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragCircle,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String acutaledorangeBoxMsg=BrowserUtils.getText(orangeBox);
        String expectedorangeMsg="You did great!";
        Assert.assertEquals(acutaledorangeBoxMsg,expectedorangeMsg);
    }
    @Test
    public void pracDragAndDrop1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueMsg=BrowserUtils.getText(blueBox);
        String expectedMsg="Drag the small circle here ...";
        Assert.assertEquals(actualBlueMsg,expectedMsg);

        String acutalcolor=blueBox.getCssValue("background-color").trim();
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(acutalcolor,expectedColor);
        WebElement dragCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragCircle).moveToElement(blueBox).release().perform();

        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        String acutalAfterAction=BrowserUtils.getText(blueBox);
        String expectedAfterACtion="You did great!";
        Assert.assertEquals(acutalAfterAction,expectedAfterACtion);






    }

















}
