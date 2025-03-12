
package ScreenShot;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class capture {
    public static void screenShot(String screenshotName, WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
package ScreenShot;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Browser.browser;

public class capture extends browser{
	
	
	public static void screenShot(String name) throws Exception{
		try {
			TakesScreenshot shot = ((TakesScreenshot)driver);
			File Source = shot.getScreenshotAs(OutputType.FILE);
			String path  = System.getProperty("user.dir")+"\\target\\screenShot\\"+name+".png";
			File Destination  =new File(path);
		//	FileUtils.copyFile(Source, Destination);
			System.out.println("Screenshot saved at: "+path);
		}catch(Exception e) {
			System.out.println("Errorwhile taking the screenshot: "+e.getMessage());
			
		}
	}
*/
	
	
//	public static void screenShot(String name) throws Exception { 
//		try {
//			TakesScreenshot shot = ((TakesScreenshot) driver);
//			File source = shot.getScreenshotAs(OutputType.FILE);
//			String path = System.getProperty("user.dir") + "\\target\\ScreenShot\\" + name + ".png";
//			File destination = new File(path);
//			FileUtils.copyFile(source, destination);
//		} catch (Exception e) {
//			System.out.println("Screenshot");
//		}

