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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void SelectMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select choice = new Select(optionBox);// It means i will choose an option from THAT BOX
        String acutalDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedDefaultOption = "Please select an option";
        // LEVEL3 --> Assert.assertEquals(choice.getFirstSelectedOption().getText().trim(),expectedDefaultOption);
        Assert.assertEquals(acutalDefaultOption, expectedDefaultOption);
        choice.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        choice.selectByValue("1");
        Thread.sleep(2000);
        choice.selectByIndex(2);
        Thread.sleep(2000);

        List<WebElement> actualOptions = choice.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");

        for (int x = 0; x < actualOptions.size(); x++) {
            Assert.assertEquals(actualOptions.get(x).getText().trim(), expectedOptions.get(x).trim());

        }
    }
}
