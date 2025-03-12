package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Browser.browser;

public class Page2 extends browser {

    public Page2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

  
	public static void selectOperation() {
        // Locate all menu items
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li"));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase("Leave")) {
                list.get(i).click();
                break; // Stop loop after clicking "Leave"
            }
        }
    }
}


//public class Page2 extends browser{
//	static PageObject2 obj;
//	
//	public static void select(String data) {
//		obj = PageFactory.initElements(driver, PageObject2.class);
//		
//		wait.until(ExpectedConditions.elementToBeClickable(obj.element));
//		for(int i = 0;i<obj.list.size();i++) {
//			System.out.println(obj.list.get(i).getAttribute("href"));
//			if(obj.list.get(i).getAttribute("href").equalsIgnoreCase(data));
//			{
//				obj.list.get(i).click();
//			}
//		}
//	}
