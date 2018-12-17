package genericActionsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	static Actions act;
	
	public static void mouseHover(WebDriver driver, WebElement ele)
	{
		act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public static void dragAndDrop(WebDriver driver, WebElement srcDrag, WebElement srcDrop)
	{
		act = new Actions(driver);
		act.dragAndDrop(srcDrag, srcDrop).build().perform();
	}
	
	public static void rightMouseClick(WebDriver driver, WebElement ele)
	{
		act = new Actions(driver);
		act.contextClick(ele).build().perform();
	}
}
