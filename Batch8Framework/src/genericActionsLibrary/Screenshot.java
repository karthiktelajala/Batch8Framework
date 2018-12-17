package genericActionsLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Screenshot 
{
	public static void captureScreenshot(WebDriver driver, String name)
	{
		try
		{
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File srcImg1 = screenshot.getScreenshotAs(OutputType.FILE);
			Files.copy(srcImg1, new File (".\\Screenshots\\"+name+".jpeg"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
