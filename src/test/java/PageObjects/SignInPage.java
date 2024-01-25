package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(css="button[type='submit']")
    @CacheLookup
    WebElement siginInbtn1;
	@FindBy(css="div[class='login-errors hide']")
    @CacheLookup
    WebElement errorText;
	
	@FindBy(css="input[placeholder='Username']")
    @CacheLookup
    WebElement userName;
	@FindBy(css="input[placeholder='Password']")
    @CacheLookup
    WebElement pswd;
	@FindBy(css="p[id='statusMessage']")
    @CacheLookup
    WebElement errorTextInvalidIDPSWD;
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	public void ClickOnSignin() 
	{
		//Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(siginInbtn1));
		siginInbtn1.click();
	}
	public String ErrorTextWithoutUIDPWD()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(errorText));
		return errorText.getText();
	}
	public void setUserName(String Uname)
	{
		userName.sendKeys(Uname);
	}
	public void setUserPswd(String Upswd)
	{
		pswd.sendKeys(Upswd);
	}
	public String ErrorTextWithInvalidUIDPWD() 
	{
		//Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(errorTextInvalidIDPSWD));
		return errorTextInvalidIDPSWD.getText();
	}

}
