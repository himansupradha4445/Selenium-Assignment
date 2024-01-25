package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(css="a[title='Client Login Button']")
    @CacheLookup
    WebElement propertyManagerLogin;
	@FindBy(css="button[id='rcc-confirm-button']")
    @CacheLookup
    WebElement cookie;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	public void PropertyManagerLogin() 
	{
		propertyManagerLogin.click();
	}
	public void clickCookies() 
	{
		cookie.click();
	}
	
	
	
	
	
}
