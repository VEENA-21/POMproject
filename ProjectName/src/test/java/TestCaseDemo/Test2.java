package TestCaseDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test2 {
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeClass
    public void setup() {
        // Initialize Extent Reports
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReports/TestReport.html");
        extent.attachReporter(spark);

        System.setProperty("webdriver.chrome.driver", "C:\\JAR\\chromedriver-win64\\chromedriver.exe"); // Update path to chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger = extent.createTest("Setup - Browser Opened");
        logger.log(Status.INFO, "Browser Opened Successfully");
    }

    @Test(priority = 1)
    public void checkTitle() {
        logger = extent.createTest("Check Title");
        String actualTitle = driver.getTitle();
        try {
            Assert.assertTrue(actualTitle.contains("OrangeHRM"), "Title does not match!");
            logger.log(Status.PASS, "Title Verified: " + actualTitle);
        } catch (AssertionError e) {
            logger.log(Status.FAIL, "Title Verification Failed: Expected 'OrangeHRM', but found " + actualTitle);
            throw e;
        }
    }

    @Test(priority = 2)
    public void loginFunctionality() throws Exception {
        logger = extent.createTest("Login Functionality");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            wait.until(ExpectedConditions.urlContains("dashboard"));

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed!");
            logger.log(Status.PASS, "Login Successful");
        } catch (Exception e) {
            logger.log(Status.FAIL, "Login Failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3, dependsOnMethods = "loginFunctionality")
    public void checkMyInfo() throws Exception {
        logger = extent.createTest("Check My Info");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Info']"))).click();
            wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

            Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Failed to load My Info page!");
            logger.log(Status.PASS, "My Info Page Loaded Successfully");
        } catch (Exception e) {
            logger.log(Status.FAIL, "My Info Page Load Failed: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void close() {
        driver.quit();
        logger = extent.createTest("Close Browser");
        logger.log(Status.INFO, "Browser Closed Successfully");
        extent.flush();

        // Automatically open the report after execution
        try {
            File reportFile = new File(System.getProperty("user.dir") + "/target/ExtentReports/TestReport.html");
            java.awt.Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








/*
package TestCaseDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2 {

	WebDriver driver;
	WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Reporter.log("🔹 Browser Opened", true);
    }

    @Test(priority = 1)
    public void checkTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("OrangeHRM"), " Title does not match!");
        Reporter.log(" Title Verified", true);
    }

    
    @Test(priority = 2)
    public void loginFunctionality() {
        // Enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for the dashboard URL to load
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // Verify login success
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed!");
        Reporter.log("Login Successful", true);
    }

    @Test(priority = 3, dependsOnMethods = "loginFunctionality")
    public void checkMyInfo() {
        // Click on the "My Info" tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Info']"))).click();

        // Wait for the "ViewPersonalDetails" URL to load
        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

        // Verify the page loaded successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Failed to load the details!");
        Reporter.log("Info Verified", true);
    }
    @AfterClass
    public void close() {
    	driver.quit();
    	Reporter.log("Browser closed",true);
    }

    
}

*/
