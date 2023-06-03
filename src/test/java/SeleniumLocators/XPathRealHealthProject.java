package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    public static void main(String[] args) throws InterruptedException {
        /*
        //THESE PARTS SHOULD BE DONE BY XPATH:
        1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
        2-Click Make an Appointment
        3-Login the username and password provided and Login successfully
        4-Choose the facility either HongKong or Seoul -->send keys
        5-Click apply for hospital admission box if it is displayed and validate it is selected
        6-Healthcare program 'Medicaid'
        7-Visit date should be provided -->send keys
        8-Put your comment for this box -->send keys
        9-Book your appointment
        THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
        10-Validate the header is "Appointment confirmation" (if statement)
        11-Print out the headers and values(only values) on your console.
        12)Click go to homepage and print out url
        13)Driver.quit or close.
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //Xpath
       // WebElement appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        // CSS ID
        WebElement appointment =driver.findElement(By.cssSelector("#btn-make-appointment"));

        appointment.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        firstName.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement facility = driver.findElement(By.xpath("//option[@value='Hongkong CURA Healthcare Center']"));
        facility.click();
        WebElement apply = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (apply.isDisplayed() && !apply.isSelected()) {
            apply.click();
        }
        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("05/17/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Hello can I go and get tea because i am cold");
        //WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        //CSS WITH CLASS
        WebElement bookAppointment=driver.findElement(By.cssSelector(".btn-default"));
        bookAppointment.click();
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),Appointment)]"));
        if (header.isDisplayed()) {
            System.out.println("Correct");
        }
        WebElement header1 = driver.findElement(By.xpath("//p[contains(text(),'Hongkong ')]"));
        System.out.println(header1.getText().trim());
        WebElement header2 = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(header2.getText().trim());
        WebElement header3 = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(header3.getText().trim());
        WebElement header4 = driver.findElement(By.xpath("//p[.='05/05/2023']"));
        System.out.println(header4.getText().trim());
        WebElement header5 = driver.findElement(By.xpath("//p[.='Hello can I go and get tea because i am cold']"));
        System.out.println(header5.getText().trim());
        WebElement header6 = driver.findElement(By.xpath("//a[contains(text(),'Appointment')]"));
        System.out.println(header6.getText().trim());
        WebElement homepage = driver.findElement(By.xpath("//a[contains(text(),'Go')]"));
        homepage.click();
        String acutalURl = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(acutalURl.equals(expectedURL) ? "Correct" : "Wrong");
        driver.quit();


    }
}
