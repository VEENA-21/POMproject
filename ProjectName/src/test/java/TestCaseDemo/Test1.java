package TestCaseDemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Browser.browser;
import Pages.page1;
import ScreenShot.capture;

public class Test1 {
    static WebDriver driver;
    static page1 page1;
    static browser br;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void setupExtentReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReports/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod

    // Open Brwoser
    public void openBrowser() throws Exception {
        logger = extent.createTest("Browser Setup");

        try {
            br = new browser();  // Create an instance of the browser class if methods are not static
            driver = br.openBrowser();  // Ensure openBrowser() returns a WebDriver instance
            br.navigateToUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            page1 = new page1(driver);

            logger.log(Status.INFO, "Browser opened and navigated to URL successfully.");
        } catch (Exception e) {
            logger.log(Status.FAIL, "Failed to open browser: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 1)
    public void titleTest() throws Exception {
        logger = extent.createTest("Title Test");

        String expectedTitle = "OrangeHRM";
        String actualTitle = page1.getTitle();

        try {
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
            logger.log(Status.PASS, "Page title matches: " + actualTitle);
        } catch (AssertionError e) {
            logger.log(Status.FAIL, "Page title does not match. Expected: " + expectedTitle + ", Actual: " + actualTitle);
            capture.screenShot("Title", driver);
            logger.addScreenCaptureFromPath("Screenshots/Title.png");
            throw e;
        }

        logger.log(Status.INFO, "Screenshot captured for title test");
    }

    @Test(priority = 2)
    public void loginFunctionality() throws InterruptedException {
        logger = extent.createTest("Login Functionality Test");
        
        page1.login("Admin", "admin123");  
        logger.log(Status.INFO, "Logged in with username: Admin and password: admin123");

        // Verify successful login using an element check instead of title
        boolean loginSuccess = page1.isDashboardVisible();  // Ensure isDashboardVisible() method is implemented in page1

        if (loginSuccess) {
            logger.log(Status.PASS, "Login functionality executed successfully");
        } else {
            logger.log(Status.FAIL, "Login failed. Dashboard not visible.");
            capture.screenShot("LoginFailure", driver);
            logger.addScreenCaptureFromPath("Screenshots/LoginFailure.png");
            Assert.fail("Login failed.");
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            br.closeBrowser();
            logger.log(Status.INFO, "Browser closed successfully");
        }
    }

    @AfterSuite
    public void generateReport() {
        extent.flush();
    }
}







/*
package TestCaseDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.browser;
import Pages.page1;
import ScreenShot.capture;

public class Test1 {
	WebDriver driver;

	
	@BeforeMethod
	public void open() throws Exception{
		browser.openBrowser();
		browser.navigateToUrl(null);
		
	}
	
	@Test
	
	public void title() throws Exception{
		capture.screenShot("Title");
		Assert.assertEquals(page1.getTitle(), "OrangeHRM");
		Reporter.log("Testcase1 title Assertion pass");
	}
	
	@Test(priority = 2)
    public void loginFunctionality() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterMethod
	public void close() {
		browser.closeBrowser();
	}

}
*/