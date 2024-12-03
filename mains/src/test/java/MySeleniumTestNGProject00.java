import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MySeleniumTestNGProject00 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create WebDriver instance
        driver = new ChromeDriver();
    }

    @Test
    public void testFormFilling() throws InterruptedException {
        // Navigate to the specified web page
        driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

        // Perform actions: Fill in the form
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("username")).sendKeys("lolyou1993");
        driver.findElement(By.id("email")).sendKeys("Johnnyboy@gmail.com");
        driver.findElement(By.id("address")).sendKeys("Block 369 ave 2");
        driver.findElement(By.id("address2")).sendKeys("Block 619 ave1");

        WebElement staticDropdown = driver.findElement(By.id("country"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(1); //Selection value
        Thread.sleep(5000L); // Pause execution for 2 second to simulate delay
        System.out.println(dropdown.getFirstSelectedOption().getText());

        WebElement staticDropdown2 = driver.findElement(By.id("state"));
        Select dropdown2 = new Select(staticDropdown2);
        dropdown2.selectByIndex(1); //Selection value
        Thread.sleep(5000L); // Pause execution for 2 second to simulate delay
        System.out.println(dropdown2.getFirstSelectedOption().getText());
        driver.findElement(By.id("same-address")).click();
        driver.findElement(By.id("save-info")).click();

        driver.findElement(By.id("zip")).sendKeys("537619");
        driver.findElement(By.id("debit")).click();
        Thread.sleep(5000L);

        driver.findElement(By.id("cc-name")).sendKeys("Mr World Wide");
        driver.findElement(By.id("cc-number")).sendKeys("6666666");
        driver.findElement(By.id("cc-expiration")).sendKeys("02/23");
        driver.findElement(By.id("cc-cvv")).sendKeys("123");
        Thread.sleep(5000L);


        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-lg")).click();
        Thread.sleep(5000L);

        // Assert the title of the page (adjust as needed)
        assertEquals("Checkout example · Bootstrap v5.3", driver.getTitle());

        // You can add more assertions or actions as required for your test

        // Optional: Add a sleep statement for demonstration purposes
        // Note: Using Thread.sleep in tests is generally discouraged due to its static nature
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
//Completed