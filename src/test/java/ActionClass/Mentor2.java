package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Mentor2 {
    @Test
    public void books() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions= new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/fx/tile");
        List<WebElement> icons=driver.findElements(By.xpath("//div[@id='chessboard']//span[@style='transform: translateX(0px);']"));
        List<String >expectednames= Arrays.asList("Black King","Black Queen","Black Rook","Black Bishop","Black Knight","Black Pawn");
        for (int x=0;x<icons.size();x++){

            actions.moveToElement(icons.get(x)).perform();
            Thread.sleep(2000);
            Assert.assertEquals(BrowserUtils.getText(icons.get(x)),expectednames.get(x));

        }






    }
}
