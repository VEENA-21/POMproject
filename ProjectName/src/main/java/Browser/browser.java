package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {
    public static WebDriver driver;

    public WebDriver openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\JAR\\chromedriver-win64\\chromedriver.exe"); // Update path to chromedriver
        driver = new ChromeDriver();
        return driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}




/*
package Browser;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
    // Script for browser-related activities

    public static WebDriver driver;      // Declared objects globally
    public static WebDriverWait wait;
    public static Actions act;
    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;
    public static ExtentTest logger;

    
 //     Initialize ExtentReports
     
    public static void init(String reportName) {
        extent = new ExtentReports();
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//target//ExtentReports//" + reportName + ".html");
        extent.attachReporter(reporter);
        logger = extent.createTest("Initialization"); // Initialize logger for the setup
    }

    
    //  Open the browser based on the choice
     
    public static void openBrowser() throws Exception {
        logger = extent.createTest("openBrowser"); // Initialize logger for this method
        try {
            String choice = Utility.properties("browser");
            if (choice.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "C://path//to//chromedriver.exe"); // Update path to chromedriver
                driver = new ChromeDriver();
            } else if (choice.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "C://path//to//msedgedriver.exe"); // Update path to msedgedriver
                driver = new EdgeDriver();
            } else if (choice.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "C://path//to//geckodriver.exe"); // Update path to geckodriver
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser choice: " + choice);
            }
            logger.info("Browser opened successfully: " + choice);
        } catch (Exception e) {
            logger.fail("Error in Browser - openBrowser: " + e.getMessage());
            throw e; // Re-throw the exception to fail the test explicitly
        }
    }

    
     // Navigates to the URL of the application
     
    public static void navigateToUrl(String url) throws Exception {
        logger = extent.createTest("navigateToUrl"); // Initialize logger for this method
        try {
            driver.get(url); // Navigate to the provided URL
            driver.manage().window().maximize(); // Maximize the browser window
            act = new Actions(driver); // Initialize Actions class
            wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize WebDriverWait with a 30-second timeout
            wait.until(ExpectedConditions.titleIs("OrangeHRM")); // Wait until the page title is "OrangeHRM"
            logger.info("Navigated to URL: " + url);
        } catch (Exception e) {
            logger.fail("Error in Browser - navigateToUrl: " + e.getMessage());
            throw e; // Re-throw the exception to fail the test explicitly
        }
    }

    
     // Closes the Browser
     
    public static void closeBrowser() {
        logger = extent.createTest("closeBrowser"); // Initialize logger for this method
        try {
            if (driver != null) {
                driver.quit(); // Close the browser
                logger.info("Browser closed successfully");
            }
        } catch (Exception e) {
            logger.fail("Error in Browser - closeBrowser: " + e.getMessage());
        }
    }

    
     // Flush ExtentReports
     
    public static void flushReport() {
        extent.flush(); // Generate the report
    }
}

*/






















/*

package Browser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser {
	// Script for browser related activities
	
	public static WebDriver driver;      // declared objects globally
	public static WebDriverWait wait;
	public static Actions act;
	
	
	
	
	//  Open the browser based on the choice
	 
	public static void openBrowser() throws Exception {
		try {
			String choice = Utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
		}
	}
 
	
	 // Pauses the URL of the application
	 
	public static void navigateToUrl(String string) throws Exception {
		try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		} catch (Exception e) {
			System.out.println("Browser - geturl");
		}
	}
	
	 // Closes the Browser
	 
	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
		}
	}

}

*/

