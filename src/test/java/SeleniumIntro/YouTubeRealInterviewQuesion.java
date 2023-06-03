package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuesion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("chester bennington");//,Keys.ENTER
        WebElement searchButton=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(2000);
        List<WebElement>Songs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement Somewhere:Songs){
            Thread.sleep(1000);
            Somewhere.sendKeys(Keys.ARROW_DOWN);
            if (Somewhere.getAttribute("aria-label").contains("Somewhere I Belong (Official Music Video)")){
                Somewhere.click();
                break;
            }
        }
        //Thread.sleep(2000)
        //song.sendKeys(Keys.ARROW_DOWN)-->PUT THIS INSIDE OF YOUR LOOP
    }
}
