package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.WaitHelper;

public class UserCheckInOut {

	WebDriver dr;
	ConfigReader reader;
	WaitHelper wait;
	
	
	@FindBy(xpath="//a[@href='https://www.edutech.rudramtech.in/qrcheckpoint/'][normalize-space()='Visit Us']")
	WebElement visitUsBtn;
	
	@FindBy(xpath="//div[@class='row mt-3']//div[1]//div[1]//div[1]//a[1]")
	WebElement watchDemoBtn;
	
	@FindBy(id="play")
	WebElement playBtn;
	
	@FindBy(id="stop")
	WebElement stopBtn;
	
	
	//@Find(
	public UserCheckInOut(WebDriver driver)
	{
		this.dr= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	

}
