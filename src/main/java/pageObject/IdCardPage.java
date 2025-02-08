package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class IdCardPage {

	WaitHelper waitHel;
	WebDriver driver;
	
	public IdCardPage(WebDriver dr) {
        this.driver = dr;
        PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='ID Card']")
	WebElement idCardMenu;
	
	@FindBy(xpath = "//input[@id='dt-search-0']")
	WebElement btnSearch;
	
	@FindBy(id="example")
	WebElement table;
	
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> tblRow;
	
	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> tblCol;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]/a[1]")
	WebElement viewIdCardBtn;
	
	@FindBy(xpath="//button[@id='download']")
	WebElement idCardPdfBtn;
	
	public void clickIdCardMenu() {
		System.out.println("Click on ID card Menu!!!");
		idCardMenu.click();
	}
	
	public void clickSearch() {
		
		waitHel= new WaitHelper(driver);
		btnSearch.click();
		waitHel.waitForElement(btnSearch, Duration.ofSeconds(30));
		btnSearch.sendKeys("prachi581@gmail.com");
		
		
	}
	
	public int getNumberofCol() {
		System.out.println(tblCol.size());
		return(tblCol.size());
	}
	
	public int getNumberOfRows() {
		
		return(tblRow.size());
	}
	
	public boolean searchByEmailIdCard(String email) {
		
		boolean flag =false;
		for(int i=1; i<=getNumberOfRows(); i++)
		{
			WebElement emailId=table.findElement(By.xpath("//td[normalize-space()='prachi581@gmail.com']"));
			
			//WebElement studname= table.findElement(By.cssSelector("tbody tr td:nth-child(2)"));
			//System.out.println(studname.getText());
			
			String emailSearch= emailId.getText();
			System.out.println(emailSearch);
			System.out.println(email+"  Email");
			
			if(emailSearch.equals(email)) {
				flag=true;
			}else {
				System.out.println("Student Email not available in table");
			}
		}
		return flag;
	}
	
	public void clickOnViewIDcardBtn() {
		viewIdCardBtn.click();
		
	}
	public void downloadIdcardPdf() throws InterruptedException {
		Thread.sleep(500);
		idCardPdfBtn.click();
		System.out.println("download IDCard PDF successfully "+idCardPdfBtn.getText());
	}
}
