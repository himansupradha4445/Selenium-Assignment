package PageObjects;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
	WebDriver driver;
	HomePage homePage;
	WebDriverWait wait;
	
	@FindBy(css="input[name='FirstName']")
    @CacheLookup
    WebElement Fname;
	
	@FindBy(css="input[name='LastName']")
    @CacheLookup
    WebElement Lname;
	
	@FindBy(css="input[name='Email']")
    @CacheLookup
    WebElement Email;
	
	@FindBy(css="input[name='Company']")
    @CacheLookup
    WebElement Cname;
	
	@FindBy(css="input[name='Phone']")
    @CacheLookup
    WebElement Mnumber;
	
	@FindBy(css="select[id='Unit_Count__c']")
    @CacheLookup
    WebElement Uount;
	
	@FindBy(css="input[name='Title']")
    @CacheLookup
    WebElement Jtitle;
	@FindBy(css="button[type='submit']")
    @CacheLookup
    WebElement WatchDemobtn;
	@FindBy(css="div[id='ValidMsgFirstName']")
    @CacheLookup
    WebElement validfname;
	@FindBy(css="img[id='Header_Logo']")
    @CacheLookup
    WebElement Entrata;
	
	
	
	public FormPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	public void setFirstName(String fname )
	{
		Fname.sendKeys(fname);
	}
	public void setLastName (String lname)
	{
		Lname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void setCompanyNamename(String cname )
	{
		Cname.sendKeys(cname);
	}
	public void setMobileNumber (String mnumber)
	{
		Mnumber.sendKeys(mnumber);
	}
	public void SelectNumberOfUnit()
	{
		Select options=new Select(Uount);
		options.selectByVisibleText("11 - 100");
	}
	public void setJobTitle(String jtitle)
	{
		Jtitle.sendKeys(jtitle);
	}
	public void cliclkWatchDemobtn()  
	{
		wait.until(ExpectedConditions.elementToBeClickable(WatchDemobtn));
		WatchDemobtn.click();
	}
	public String getErrorText()
	{
		return validfname.getText();
	}
	public void cliclToHomePage()
	{
		
		Entrata.click();
	}
	
}
