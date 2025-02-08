package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class SearchStudentPage {

	
	WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchStudentPage(WebDriver dr) {
        ldriver = dr;
        PageFactory.initElements(ldriver, this);
         waithelper= new WaitHelper(ldriver);
	}

//	@FindBy(how = How.ID, using="dt-search-0")
//	WebElement searchtxt;
	
	
	@FindBy(xpath="//input[@id='dt-search-0']")
	WebElement searchtxt;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> tblRow;
	
	@FindBy(xpath="//tbody/tr/td")
	List<WebElement> tblCol;
	
	
	
	public void setName(String name) {
		
		waithelper.waitForElement(searchtxt, Duration.ofSeconds(30));
		searchtxt.clear();
		searchtxt.sendKeys(name);
		
		//searchtxt.click();
	}
}
