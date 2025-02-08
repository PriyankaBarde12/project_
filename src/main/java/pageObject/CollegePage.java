package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class CollegePage {

	
	
	WaitHelper waitHel;
	WebDriver driver;
	
	@FindBy(css="body > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)")
	@CacheLookup
	WebElement col;
	
	@FindBy(xpath="//input[@id='dt-search-0']")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(id="example")
	WebElement table;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> tblRow;
	
	@FindBy(xpath="//tbody/tr/td")
	List<WebElement> tblCol;
	
	@FindBy(xpath="//span[@class='fa fa-edit fa-1x']")
	WebElement editBtn;
	
	//college Edit Fields
	@FindBy(xpath = "//input[@id='cname']")
	WebElement colName;
	
	@FindBy(xpath="//input[@id='cemail']")
	WebElement colEmail;
	
	@FindBy(name="cmobile")
	WebElement colMobile;
	
	@FindBy(name="caddress")
	WebElement colAddress;
	
	@FindBy(name = "ccity")
	WebElement colCity;
	
	@FindBy(name="cstate")
	WebElement colState;
	
	@FindBy(name="cpin")
	WebElement colPin;
	
	//upload college logo
	@FindBy(xpath="//input[@id='f1']")
	WebElement fileUpload;
	
	@FindBy(name="sub")
	WebElement subEditBtn;
	
	
	
	public CollegePage(WebDriver dr) {

		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCollegeMenu() {
		col.click();
		
	}
	
	public void clickSearchCollege() {
		
		waitHel= new WaitHelper(driver);
		btnSearch.click();
		waitHel.waitForElement(btnSearch, Duration.ofSeconds(30));
		btnSearch.sendKeys("contact@rudramtech.in");
		
		
	}
	
	public int getNumberofCol() {
		System.out.println(tblCol.size());
		return(tblCol.size());
	}
	
	public int getNumberOfRows() {
		
		return(tblRow.size());
	}
	
	public boolean searchByCollegeEmail(String email) {
		
		boolean flag =false;
		for(int i=1; i<=getNumberOfRows(); i++)
		{
			WebElement emailId=table.findElement(By.xpath("//td[normalize-space()='contact@rudramtech.in']"));
			
			WebElement collegename= table.findElement(By.cssSelector("tbody tr td:nth-child(2)"));
			System.out.println(collegename.getText());
			
			String emailSearch= emailId.getText();
			System.out.println(emailSearch);
			System.out.println(email+" college Email");
			
			if(emailSearch.equals(email)) {
				flag=true;
			}else {
				System.out.println("Email not available in table");
			}
		}
		return flag;
	}
	
	//click 
	public void clickEditbutton() {
//		WebElement editBtn= table.findElement(By.cssSelector("tbody tr td:nth-child(7)"));
//		System.out.println(editBtn.getText());
		editBtn.click();
		//Thread.sleep(100);
		
	}
	//EdIt college Profile
	public void editCollegeProfileFields() throws InterruptedException, AWTException {
		
		colName.clear();
		colName.sendKeys("Rudram Technology Solutions");
		Thread.sleep(100);
		colEmail.clear();
		colEmail.click();
		colEmail.sendKeys("contact@rudramtech.in");

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fileUpload); //click actions
		
		   Robot rb = new Robot();
	        rb.delay(1000);
	        System.out.println("Running !!!!!");

	        // Put file path on clipboard
	        StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\892rudram-logo.jpg");
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	        System.out.println("Address copied successfully");

	        Thread.sleep(200);
	        // Simulate Ctrl+V to paste
	        rb.keyPress(KeyEvent.VK_CONTROL);
	        rb.keyPress(KeyEvent.VK_V);
	        rb.delay(500); // Small delay to ensure pasting completes
	        rb.keyRelease(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_CONTROL);
	        System.out.println("File address pasted successfully");

	        // Press Enter to confirm file selection
	        rb.keyPress(KeyEvent.VK_ENTER);
	        rb.keyRelease(KeyEvent.VK_ENTER);
	        System.out.println("File selection confirmed");
		
	}
	
	
	
	public void scrollPageUpdate() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(300);
		subEditBtn.click();
	}

}
