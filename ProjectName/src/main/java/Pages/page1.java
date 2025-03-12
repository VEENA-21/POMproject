
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class page1 {
    WebDriver driver;
    WebDriverWait wait;

    // Locating elements 
    @FindBy(xpath = "//input[@name='username']")  
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")  
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")  
    WebElement loginButton;

    @FindBy(xpath = "//h6[contains(text(),'Dashboard')]")  
    WebElement dashboardHeading;

    // Constructor
    public page1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait
        PageFactory.initElements(driver, this);
    }

    // Get page title
    public String getTitle() {
        return driver.getTitle();
    }

    // Login method with explicit waits
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Methods to interact with elements safely
    public void enterUserName(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Check if the dashboard is visible after login
    public boolean isDashboardVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(dashboardHeading)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}








/*
package Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.page1Objects;

public class page1 extends browser {
	
	// Script related to action performed in first page(Login)
	
	
	public static void enterUserName(String user) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(page1Objects.username()));
			page1Objects.username().sendKeys(user);
		} catch(Exception e) {
			System.out.println("Error! username: "+e.getMessage());
		}
	}
	
	
	public static void enterpassword(String pass) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(page1Objects.password()));
			page1Objects.password().sendKeys(pass);
		} catch(Exception e) {
			System.out.println("Error! password: "+e.getMessage());
		}
	}
	
	
	 public static void clickLogin() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(page1Objects.loginBtn()));
	            page1Objects.loginBtn().click();
	        } catch (Exception e) {
	            System.out.println("Error clicking login button: " + e.getMessage());
	        }
	 }
	 
	 public static String getTitle() {
		 return driver.getTitle();
	 }
	 
	 */

//	public static void userNameEnter() {
//		try {
//			WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//            userField.clear();
//            userField.sendKeys("Admin");
//        } catch (Exception e) {
//            System.out.println("Error: Unable to enter username - " + e.getMessage());
//        }
//	}
//	
//	public static void passwordEnter() {
//		try {
//			WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//            passField.clear();
//            passField.sendKeys("admin123"); // Hardcoded Password
//        } catch (Exception e) {
//            System.out.println("Error: Unable to enter password - " + e.getMessage());
//        }
//	}
//	
//	public static void clickLogin() {
//		try {
//			 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
//	            loginButton.click();
//	        } catch (Exception e) {
//	            System.out.println("Error: Unable to click login button - " + e.getMessage());
//	        }
//	}


