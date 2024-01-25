package TestCase;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.FormPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SignInPage;

public class TC_HomePage_Test_001 extends BaseClass{
	HomePage homePage;
	WebDriverWait wait;
	FormPage formPage;
	LoginPage loginPage;
	SignInPage signInpage;
	
	
	@Test(priority=1)
	public void homePage() throws IOException 
	{
		homePage=new HomePage(driver);
		logger.info("Checking the Page title");
		String message_actual =homePage.getHomePageTitle();
		if(message_actual.equals(" Management Software | Entrata"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"homePage");
			Assert.assertTrue(false);
			logger.info("Login pagiled");
		}
			
	}
	@Test(priority=2)
	public void navigateToBusinessIntelligence() 
	{
		logger.info("Navigate To Entrata Business Intelligence");
		String message_actual =homePage.navigateToBISection();
		String message_expected="Entrata Business Intelligence";
		Assert.assertTrue(message_actual.contains(message_expected));
		
	}
	@Test(priority=3)
	public void checkingRequiredfieldValidation() 
	{
		homePage=new HomePage(driver);
		formPage=new FormPage(driver);
		homePage.clickToGetDemo();
		logger.info("Checking the required field validation");
		formPage.cliclkWatchDemobtn();
		String message_actual=formPage.getErrorText();	
		String message_expected="This field is required.";
		Assert.assertTrue(message_actual.contains(message_expected));
		
	}
	@Test(priority=4)
	public void fillTheForm() 
	{
		homePage=new HomePage(driver);
		formPage=new FormPage(driver);
		//homePage.clickToGetDemo();
		logger.info("Opening the form for Watch Demo");
		logger.info("Entering First Name");
		formPage.setFirstName(FNAME);
		logger.info("Entering Last Name");
		formPage.setLastName(LNAME);
		logger.info("Entering Email");
		formPage.setEmail(EMAIL);
		logger.info("Entering Company Name");
		formPage.setCompanyNamename(CNAME);
		logger.info("Entering Mobile number ");
		formPage.setMobileNumber(MNUMBER);
		logger.info("Selecting Number of unit Name");
		formPage.SelectNumberOfUnit();
		logger.info("Entering Job title");
		formPage.setJobTitle(JTITLE);
	}
	
	@Test(priority=5)
	public void validatingErrorTextOfSignin() 
	{
		homePage=new HomePage(driver);
		formPage=new FormPage(driver);
		loginPage=new LoginPage(driver);
		signInpage=new SignInPage(driver);
		formPage.cliclToHomePage();
		homePage.clickToSignInPage();
		loginPage.clickCookies();
		loginPage.PropertyManagerLogin();
		logger.info("Click to watch demo without filling form");
		signInpage.ClickOnSignin();
		logger.info("Checking the error text of sigin without entering UserName and Passwor");
		String message_actual=signInpage.ErrorTextWithoutUIDPWD();	
		System.out.println(message_actual);
		String message_expected="Please enter username and password";
		Assert.assertTrue(message_actual.contains(message_expected));	
	}
	@Test(priority=6)
	public void loginWithIvalidCredential() 
	{
		
		signInpage=new SignInPage(driver);
		signInpage.setUserName(UNAME);
		signInpage.setUserPswd(UPSWD);
		signInpage.ClickOnSignin();
		logger.info("Entering wrong Username and wrong passwor");
		String message_actual=signInpage.ErrorTextWithInvalidUIDPWD();	
		String message_expected="The username and password provided are not valid. Please try again.";
		Assert.assertTrue(message_actual.contains(message_expected));
		
	}
	
	
}
