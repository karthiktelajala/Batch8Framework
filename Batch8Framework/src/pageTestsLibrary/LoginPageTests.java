package pageTestsLibrary;


import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericActionsLibrary.ExcelFile;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTests extends TestBase
{
	public static final Logger log = Logger.getLogger(LoginPageTests.class.getName());
	String url = "https://opensource-demo.orangehrmlive.com/";
	String filePath = "./TestData/Credentials.xlsx";
	LoginPageActions loginPageActions;
	
	@Parameters(value="browser")
	
	@BeforeMethod
	public void testInitializer(String browser)
	{
		log.info("Test is being initialized...");
		initializeTest(browser, url);
	}
	
	@Test(priority=1)
	public void verifyLoginPageLogo()
	{
		loginPageActions = new LoginPageActions(driver);
		Assert.assertTrue(loginPageActions.isLogoDisplayed());
	}
	
	@Test(priority=2)
	public void loginWithValidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 1, 0);
		String password = ExcelFile.readExcel(filePath, 0, 1, 1);
		loginPageActions.login(username, password);
		
		String expTitle = "OrangeHRM";
		String actTitle = loginPageActions.getLoginPageTitle(driver);
		log.info("Comparing the actual Title: "+actTitle+" with expcted Title: "+expTitle);
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(priority=3)
	public void loginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		
		String username = ExcelFile.readExcel(filePath, 0, 2, 0);
		String password = ExcelFile.readExcel(filePath, 0, 2, 1);
		loginPageActions.login(username,password);
		
		String expMessage = "Invalid credentials";
		String actMessage = loginPageActions.getLoginError();
		Assert.assertEquals(actMessage, expMessage);
	}
	
	@AfterMethod
	public void testClosure()
	{
		closeBrowser();
	}
}
