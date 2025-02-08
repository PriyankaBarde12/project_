package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario; // Correct import
import utilities.ConfigReader;

public class Hooks {

    public Hooks() {
        // Default constructor
    }

    public static WebDriver driver;  // Static instance to keep the browser open

    @Before
    public void setUp() throws InterruptedException {
        if (driver == null) { // Ensures browser opens only once
            System.out.println("User is on login page");

            System.setProperty("webdriver.chrome.driver", 
                "C:\\Users\\hp\\eclipse-workspace\\SeleniumProject\\Qrcheckpoint\\src\\test\\resources\\drivers\\chromedriver.exe");
            
            Thread.sleep(400);       
            System.out.println("Driver running!!!!!");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            
            String url = ConfigReader.getProperty("url");
            driver.get(url);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test Failed: " + scenario.getName());
        } else {
            System.out.println("Test Passed: " + scenario.getName());
        }
        
        // Do not close the browser to reuse it in all scenarios
    }
}
