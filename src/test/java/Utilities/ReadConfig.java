package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig()

	{

	File src= new File("./Configuration/config.properties");

	try {

	FileInputStream fis = new FileInputStream(src);
	pro = new Properties();
	pro.load(fis);

	} catch (Exception e) {

	System.out.println("Exception is " + e.getMessage());

	}

	}
	public String getUrl()
	{
		String baseurl=pro.getProperty("baseurl");
		return baseurl;
	}
	public String getFirstName()
	{
		String fname=pro.getProperty("FNAME");
		return fname;
	}
	public String getLastName()
	{
		String lname=pro.getProperty("LNAME");
		return lname;
	}
	public String getEmail()
	{
		String email=pro.getProperty("EMAIL");
		return email;
	}
	public String getCompanyName()
	{
		String cname=pro.getProperty("CNAME");
		return cname;
	}
	public String getMobileNumber()
	{
		String mnumber=pro.getProperty("MNUMBER");
		return mnumber;
	}
	public String getJobTitle()
	{
		String jtitle=pro.getProperty("JTITLE");
		return jtitle;
	}
	public String getUname()
	{
		String uname=pro.getProperty("UNAME");
		return uname;
	}
	public String getUpswd()
	{
		String pswd=pro.getProperty("PSWD");
		return pswd;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath; 
	}
	public String getIEpath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath; 
	}
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath; 
	}
	

}
