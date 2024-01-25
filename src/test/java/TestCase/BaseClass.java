package TestCase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getUrl();
	//public String baseURL="https://www.entrata.com";
	String FNAME=readconfig.getFirstName();
	String LNAME=readconfig.getLastName();
	String EMAIL=readconfig.getEmail();
	String CNAME=readconfig.getCompanyName();
	String MNUMBER=readconfig.getMobileNumber();
	String JTITLE=readconfig.getJobTitle();
	String UNAME=readconfig.getUname();
	String UPSWD=readconfig.getUpswd();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("broswer")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("Entrata "); 
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))

		{

		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath()); 
		driver=new ChromeDriver();

		}

		else if(br.equals("firefox"))

		{

		System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
		driver = new FirefoxDriver();

		}

		else if(br.equals("ie"))

		{

		System.setProperty("webdriver.ie.driver", readconfig.getIEpath()); 
		driver = new InternetExplorerDriver();

		}
		driver.get(baseURL);
			
			
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen (WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts= (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs (OutputType.FILE);

		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");

		FileUtils.copyFile(source, target);

		System.out.println("Screenshot taken");
}
}
