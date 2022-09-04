package org.naukri.Test_Base;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.naukri.TestNG_files.Naukri_Testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Naukribase
{
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger(Naukri_Testcases.class);
	 
public static void initializations()

     {
	PropertyConfigurator.configure("log4j.properties");
	 log.info("browser launching");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\kps\\eclipse-workspace\\Assesment_naukri\\Assesment_naukri\\src\\test\\java\\Drives and files\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("start-maximized"); // open Browser in maximized mode
		 options.addArguments("disable-infobars"); // disabling infobars
		 options.addArguments("--disable-extensions"); // disabling extensions
		 options.addArguments("--disable-gpu"); // applicable to windows os only
		 options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		// options.addArguments("--no-sandbox"); // Bypass OS security model
		  driver = new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.get("https://my.naukri.com/");
		
	 }
	 
	 
		
		
}


