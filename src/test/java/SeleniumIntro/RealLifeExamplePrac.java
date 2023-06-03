package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExamplePrac {
    public static void main(String[] args) {
        /*
         Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        String actualTitle= driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title Passed");
        }else {
            System.out.println("Title failed");
        }
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.godaddy.com/";
        System.out.println(actualURL.equals(expectedURL)? " URL is Passed":"URL is Failed");
//        if (actualURL.equals(expectedURL)){
//            System.out.println("URL is passed");
//        }else {
//            System.out.println("URL is failed");
//        }
        driver.close();
    }
}
