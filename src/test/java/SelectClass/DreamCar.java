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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
        WebElement conditionCar = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(conditionCar, "new", "value");

        WebElement makeCar = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeCar, "lexus", "value");

        WebElement modelCar = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelCar, "lexus-rx_350", "value");

        WebElement priceRange = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceOptions = new Select(priceRange);
        //WebElement noPrice=priceOptions.getFirstSelectedOption();
        String expectedPrice = "No max price";
        Assert.assertEquals(priceOptions.getFirstSelectedOption().getText().trim(), expectedPrice.trim());

        WebElement miles = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(miles, "40", "value");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        //String actualHEADER=BrowserUtils.getText(header); // header.getText().trim;
        String expectedheader = "New Lexus RX 350 for sale";
        Assert.assertEquals(header.getText().trim(), expectedheader);

        WebElement priceRanges = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(priceRanges, "list_price", "value");
        Thread.sleep(2000);
        List<WebElement> lexusTitle = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement webElement : lexusTitle) {
            Assert.assertTrue(BrowserUtils.getText(webElement).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(webElement));
            //Assert.assertTrue(webElement.getText().contains("Lexus RX 350"));
        }
//        for (int x=0; x<lexusTitle.size();x++){
//            Assert.assertTrue(BrowserUtils.getText(lexusTitle.get(x)).contains("Lexus RX 350"));
        List<WebElement> CarPrices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> ActualPrice = new ArrayList<>();
        List<Integer> ExpectedPrice = new ArrayList<>();
        for (WebElement prices : CarPrices) {
            ExpectedPrice.add(Integer.parseInt(BrowserUtils.getText(prices)
                    .replace("$", "").replace(",", "")));
            ActualPrice.add(Integer.parseInt(BrowserUtils.getText(prices)
                    .replace("$", "").replace(",", "")));
            Collections.sort(ExpectedPrice);
            Assert.assertEquals(ActualPrice, ExpectedPrice);
        }
        driver.quit();
    }
}

