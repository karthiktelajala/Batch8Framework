package testBaseLibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
	public WebDriver driver;
	String log4jPath = "log4jProperties";
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public void initializeTest(String browser, String url)
	{
		launchBrowser(browser);
		log.info(browser+"is lauched...");
		getURL(url);
		log.info("Navigated to the url: "+url);
		PropertyConfigurator.configure(log4jPath);
	}
	public void launchBrowser(String browser) 
	{		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//To Launch Chrome Browser
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//To Launch Firefox Browser
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			//To Launch IE Browser
			System.setProperty("webdriver.ie.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			//To Launch Edge Browser
			System.setProperty("webdriver.edge.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		//to Maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}
}
