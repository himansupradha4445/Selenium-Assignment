package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)

	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp 
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter); 
		extent.setSystemInfo("Host name", "localhost"); 
		extent.setSystemInfo("Environemnt","QA"); 
		extent.setSystemInfo("user","Himansu");

		htmlReporter.config().setDocumentTitle("ENTRATATA TEST"); // Tile of repor
		htmlReporter.config().setReportName("Functional Test Report"); // name of the report 
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the 
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
		
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure (ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report 
		logger.log(Status.FAIL, MarkupHelper.createLabel (tr.getName(), ExtentColor.RED)); // send the passed information 1
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

		File f= new File(screenshotPath);

		if(f.exists())
		{
		try {

		logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath)); 
		    } catch (Exception e) {
		  e.printStackTrace();

		}
		}
	 }
	
	public void onTestSkipped (ITestResult tr) {

	logger =extent.createTest(tr.getName()); // create new entry in th report 
	logger.log(Status.SKIP, MarkupHelper.createLabel (tr.getName(), ExtentColor.ORANGE)); 
	}

	public void onFinish(ITestContext testContext) {

	extent.flush();

	}
	}
