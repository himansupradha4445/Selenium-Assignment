package PageObjects;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCase.BaseClass;

public class HomePage  {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath="(//div[@class='main-nav-link'])[1]")
    @CacheLookup
    WebElement Products;
	
	@FindBy(css="div.layout div.main-header:nth-child(1) div.content-cap div.main-header-grid div.header-desktop-nav.hide-on-mobile:nth-child(3) div.header-nav-item:nth-child(1) div.fat-nav div.content-cap div.fat-nav-grid div.nav-group:nth-child(1) > a.fat-nav-links:nth-child(8)")
    @CacheLookup
    WebElement EntrataBusinessIntelligence;
	
	@FindBy(xpath="(//a[@class='button-default solid-dark-button'][normalize-space()='Watch Demo'])[1]")
    @CacheLookup
    WebElement WatchDemo;
	
	@FindBy(css="a[class='button-default outline-dark-button']")
    @CacheLookup
    WebElement signInbtn;
	
	public HomePage (WebDriver driver)
		{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		}
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	public String navigateToBISection()
	{
		
		Actions ac = new Actions(driver);
		ac.moveToElement(Products).build().perform();
		return EntrataBusinessIntelligence.getText();
		
	}
	public void clickToGetDemo()
	{
		WatchDemo.click();
		
		
	}
	public void clickToSignInPage()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(signInbtn));
		signInbtn.click();
	}
}
	
	
	
	
	
	

