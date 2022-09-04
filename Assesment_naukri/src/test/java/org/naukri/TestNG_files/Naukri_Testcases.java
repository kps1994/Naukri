package org.naukri.TestNG_files;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.naukri.Data_driven_files.Exceldataprovider;
import org.naukri.POM_files.Naukri_first_page;
import org.naukri.Test_Base.Naukribase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Naukri_Testcases extends Naukribase

{
	
	public static Logger log = LogManager.getLogger(Naukri_Testcases.class);
	
  @Test(dataProvider = "dp")
  public void register(String Name, String Email, String Password, String Number) throws InterruptedException 
  {
	  Naukri_first_page nfg= PageFactory.initElements(driver, Naukri_first_page.class);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  nfg.register();
	  log.info("Registration button is clicked");
	  Reporter.log("Registration button is clicked");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  nfg.fresher_link();
	  log.info("Fresher registration is selected");
	  Reporter.log("Fresher registration is selected");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  nfg.naukri_name(Name);
	  log.info("Name for the registration is entered");
	  Reporter.log("Name for the registration is entered");
	  nfg.naukri_email(Email);
	  log.info("Email ID for the registration is entered");
	  Reporter.log("Email ID for the registration is entered");
	  nfg.naukri_password(Password);
	  log.info("Password for the registration is entered");
	  Reporter.log("Password for the registration is entered");
	  nfg.naukri_number(Number);
	  log.info("Contact number for the registration is entered");
	  Reporter.log("Contact number for the registration is entered");
	  nfg.naukri_location();
	  nfg.naukri_place();
	  log.info("Location for the registration is entered");
	  Reporter.log("Location for the registration is entered");
  }
  
  @DataProvider
  public Object[][] dp() throws Exception 
  {
	  Exceldataprovider ec= new Exceldataprovider("C:\\Users\\kps\\eclipse-workspace\\Assesment_naukri\\Assesment_naukri\\src\\test\\java\\Drives and files\\Datasheet.xlsx");
		int Totalrow=ec.getRowCount("Sheet1");
		Object [][]data= new Object [Totalrow][4];
		for(int i=0;i<Totalrow;i++)
		{
		data[i][0]=ec.getCellData("Sheet1", i, 0);
		data[i][1]=ec.getCellData("Sheet1", i, 1);
		data[i][2]=ec.getCellData("Sheet1", i, 2);
		data[i][3]=ec.getCellData("Sheet1", i, 3);
		}
	    return data;
	    };
  
  
  @BeforeMethod
  public void setup()
  {
	  initializations();
	  log.info("Application is launched");
	  Reporter.log("Application is launched");
  }

  @AfterMethod
  public void afterClass() 
  {
	  
  }

}
