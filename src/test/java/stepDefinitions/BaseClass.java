package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pageObject.AddStudents;
import pageObject.AttendanceFilter;
import pageObject.CollegePage;
import pageObject.IdCardPage;
import pageObject.LoginPage;
import pageObject.SearchStudentPage;
import utilities.WaitHelper;

public class BaseClass {

	WebDriver dr ;
    LoginPage lp;
    AddStudents studAdd;
    JavascriptExecutor js ;
    SearchStudentPage searchStudent;
    IdCardPage idcard;
    CollegePage college;
    WaitHelper waitHelper;
    AttendanceFilter filterAttend;

	public BaseClass() {
		//college= new CollegePage(dr);
	}
	
	
	
	public static String randomString() {
		
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	
	public void scrollPage()
	{
		js= (JavascriptExecutor) dr;
		//js.executeScript("window.scrollBy(0,500)");
	}

}
