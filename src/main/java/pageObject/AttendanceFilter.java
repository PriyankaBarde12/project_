package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceFilter {

	WebDriver dr;
	public AttendanceFilter(WebDriver driver) {
		this.dr= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Attendance Filter']")
	WebElement attendanceFiterMenu;
	
	
	@FindBy(xpath="//button[@id='download']")
	WebElement downloadBtn;
	
	
	public void clickOn_attendanceFilter_Menu() throws InterruptedException {
		
		Thread.sleep(2000);
		attendanceFiterMenu.click();
	}
	
	public void downloadPdfAttendance() throws InterruptedException {
		Thread.sleep(1000);
		downloadBtn.click();
	}

}
