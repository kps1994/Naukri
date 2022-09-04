package org.naukri.POM_files;



import org.naukri.Test_Base.Naukribase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Naukri_first_page extends Naukribase
{

	@FindBy(xpath="//a[contains(text(),'Register for Free')]") private WebElement nregister;
	@FindBy(xpath="//button[contains(text(),'I am a Fresher')]") private WebElement nfresherlink;
	@FindBy(id="fname") private WebElement nName;
	@FindBy(id="email") private WebElement nemail;
	@FindBy(xpath="//input[@name='password']") private WebElement npassword;
	@FindBy(xpath="//input[@name='number']") private WebElement nNumber;
	@FindBy(xpath="//body/main[1]/div[1]/div[1]/form[1]/resman-location[1]/div[1]/div[1]/div[1]/suggestor[1]/div[1]/div[1]/input[1]") private WebElement nlocation;
	@FindBy(xpath="//li[contains(text(),'Chennai')]") private WebElement nplace;
	
	public void register()
	{
		nregister.click();
	}
	
	public void fresher_link()
	{
		nfresherlink.click();
	}
	
	public void naukri_name(String name)
	{
		nName.sendKeys(name);
	}
	
	public void naukri_email(String email)
	{
		nemail.sendKeys(email);
	}
	
	public void naukri_password(String password)
	{
		npassword.sendKeys(password);
	}
	
	public void naukri_number(String number)
	{
		nNumber.sendKeys(number);
	}
	
	public void naukri_location()
	{
		nlocation.click();
	}
	
	public void naukri_place()
	{
		nplace.click();
	}
	
}
