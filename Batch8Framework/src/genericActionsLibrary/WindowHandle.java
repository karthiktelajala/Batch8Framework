package genericActionsLibrary;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandle 
{
	public static String getCurrentWindowSessionId(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	
	public static Set<String> getAllWindowsSessionId(WebDriver driver)
	{
		return driver.getWindowHandles();
	}
}
