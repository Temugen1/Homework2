package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/rumisky/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR:
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String acutalheader = javaHeader.getText().trim();
        String expectedheader = "Java";
        System.out.println(acutalheader.equals(expectedheader) ? "Correct" : "False");
        driver.navigate().back();


        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
        WebElement SelenLink= driver.findElement(By.linkText("Selenium"));
        SelenLink.click();
        WebElement Selenium = driver.findElement(By.tagName("h1"));
        String acutalSelen = Selenium.getText().trim();
        String expectedSelen = "Selenium automates browsers. That's it!";
        System.out.println(acutalSelen.equals(expectedSelen) ? "Correct" : "False");
        driver.navigate().back();

        WebElement cucumberLink=driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumber=driver.findElement(By.tagName("h1"));
        String actualCuc=cucumber.getText().trim();
        String expectedcuc="Tools & techniques that elevate teams to greatness";
        System.out.println(actualCuc.equals(expectedcuc)?"Correct":"False");
        driver.navigate().back();

        WebElement testLink=driver.findElement(By.linkText("TestNG"));
        testLink.click();
        WebElement testNg= driver.findElement(By.tagName("h2"));
        String acutalTest=testNg.getText().trim();
        String expectedTest="TestNG";
        System.out.println(acutalTest.equals(expectedTest)?"Correct":"False");
        driver.navigate().back();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="file:///Users/rumisky/Downloads/Techtorial.html";
        System.out.println(actualURL.equals(expectedURL)?"Yes":"No");

        //LOCATOR PARTIALLINKTEXT:
        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());




    }
}
