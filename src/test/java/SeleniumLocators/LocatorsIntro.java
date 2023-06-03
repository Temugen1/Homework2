package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //Locators --> is way to locate(find) elements and manipulate on it
    public static void main(String[] args) throws InterruptedException {
        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/rumisky/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim();//it gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "Correct" : "WRONG");

        WebElement para = driver.findElement(By.id("details2"));
        System.out.println(para.getText().trim());

        //NAME LOCATOR:
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Zeus");
        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Greece");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("7738632721");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("temugent@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("123 Main st");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postal = driver.findElement(By.name("postalCode"));
        postal.sendKeys("60651");
        WebElement countrr = driver.findElement(By.name("country"));
        countrr.sendKeys("Valhala");

        //ClASS LOCATOR
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isDisplayed() ? "SELECTED" : "NOT SELECTED");
        WebElement testNG = driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed() && !testNG.isSelected()) {
            testNG.click();
        }
        System.out.println(testNG.isDisplayed() ? "SELECTED" : "NOT SELECTED");
        WebElement Cucu = driver.findElement(By.id("cond4"));
        if (Cucu.isDisplayed() && !Cucu.isSelected()) {
            Cucu.click();
        }
        System.out.println(Cucu.isDisplayed() ? "SELECTED" : "NOT SELECTED");

        //TAG NAME LOCATOR:

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement useJava=driver.findElement(By.tagName("u"));
        System.out.println(useJava.getText());

        Thread.sleep(2000);
        driver.quit();





    }
}
