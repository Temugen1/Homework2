package SelectClass;

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
import java.util.List;

public class SelectPrac {
    @Test
    public void Prac() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/rumisky/Downloads/Techtorial.html");
        WebElement allOptions = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(allOptions);
        String expected = "UNITED STATES".trim();
        Assert.assertEquals(choice.getFirstSelectedOption().getText().trim(), expected);

        //TASK 2 find and print out all Country Options
        List<WebElement> allNations = choice.getOptions();//it will give you all countries
        int count = 0;
        for (int x = 0; x < allNations.size(); x++) {
            System.out.println(allNations.get(x).getText().trim());
            count++;
        }
        System.out.println(count);
        Thread.sleep(3000);

        //Task 3 Find  your Country and your Favorite country and travel Country
        choice.selectByVisibleText("MONGOLIA ");
        Thread.sleep(3000);
        choice.selectByValue("100");
        Thread.sleep(3000);
        choice.selectByIndex(135);


    }
}
