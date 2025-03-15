package TestCaseDemo;

import org.openqa.selenium.WebDriver;
import Browser.browser;
import Pages.page1;
import Pages.Page2;
import ScreenShot.capture;

public class Demo {
    public static void main(String[] args) {
        WebDriver driver = null; // Declare WebDriver variable
        browser browserInstance = new browser(); // Create an instance of the browser class

        try {
            // Open browser and get driver reference without errors
            driver = browserInstance.openBrowser();
            
            // Navigate to URL
            browserInstance.navigateToUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  // Update with actual URL
            
            // Initialize login page
            page1 loginPage = new page1(driver);
            loginPage.enterUserName("Admin"); // Enter username
            loginPage.enterPassword("admin123"); // Enter password
            loginPage.clickLogin(); // Click login button
            
            // Wait for login action
            Thread.sleep(2000); 

            // Perform operation in Page2
            Page2 page2 = new Page2(driver);
            page2.selectOperation();

            // Capture screenshot
            capture.screenShot("title", driver);

        } catch (Exception e) {
            System.out.println("Test Execution failed: " + e.getMessage());
            e.printStackTrace();  // Print full stack trace for debugging
        } finally {
            // Ensure the browser is closed properly
            if (driver != null) {
                browserInstance.closeBrowser();
            }
        }
    }
}



/*
package TestCaseDemo;

import Browser.browser;
import Pages.page1;
import Pages.Page2;
import ScreenShot.capture;

public class Demo {
    public static void main(String[] args) {
        try {
            // Open browser
            browser.openBrowser();
            
            // Navigate to URL
            browser.navigateToUrl("https://example.com");  // Update with actual URL
            
            // Initialize login page
            page1 loginPage = new page1();
            loginPage.enterUserName("Admin"); // Enter username
            loginPage.enterpassword("admin123"); // Enter password
            loginPage.clickLogin(); // Click login button
            
            // Wait for login action
            Thread.sleep(2000); 

            // Perform operation in Page2
            Page2.selectOperation();

            // Capture screenshot
            capture.screenShot("title");

            // Close browser
            browser.closeBrowser();
        } catch (Exception e) {
            System.out.println("Test Execution failed: " + e.getMessage());
        }
    }
}
*/
