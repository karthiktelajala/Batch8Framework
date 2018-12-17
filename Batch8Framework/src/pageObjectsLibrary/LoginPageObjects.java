package pageObjectsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	@FindBy(id="txtUsername")
	public WebElement txtUsername;
	
	@FindBy(name="txtPassword")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='btnLogin' and @type='submit']")
	public WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	public WebElement msgError;
	
	@FindBy(xpath="//div[@id='divLogo']")
	public WebElement loginPageLogo;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
}
