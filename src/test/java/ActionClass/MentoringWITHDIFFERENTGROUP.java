package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MentoringWITHDIFFERENTGROUP {
    @Test
    public void Amazon(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");
        WebElement menu=driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
        menu.click();
        WebElement books=driver.findElement(By.xpath("//div[.='Books']"));
        BrowserUtils.scrollWIthJs(driver,books);

        books.click();
        WebElement kindleBooks=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul[13]/li[12]/a"));
        BrowserUtils.scrollWIthJs(driver,kindleBooks);
        kindleBooks.click();
        WebElement BookTITLES=driver.findElement(By.xpath("//div[@class='a-box-group a-spacing-top-micro']"));





    }
}
