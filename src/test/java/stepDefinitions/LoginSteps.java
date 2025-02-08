package stepDefinitions;

import java.awt.AWTException;
import java.util.logging.LogManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObject.AddStudents;
import pageObject.AttendanceFilter;
import pageObject.CollegePage;
import pageObject.IdCardPage;
import pageObject.LoginPage;
import utilities.ConfigReader;
import utilities.WaitHelper;

public class LoginSteps extends BaseClass
{

	WebDriver dr = Hooks.driver;
	/*public LoginSteps() {
		studAdd= new AddStudents(dr);
    	//System.out.println("view!!!!"+ studAdd.getTitle());
    	 college= new CollegePage(dr);
    	 idcard = new IdCardPage(dr);
    	waitHelper= new WaitHelper(dr);
	}*/
	
    
	//private static final LogManager logger = LogManager.getLogManager()  //.getLogger(LoginSteps.class);
  // Before
	@Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        System.out.println("User is on login page");
      /*  
//        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", 
        	    "C:\\Users\\hp\\eclipse-workspace\\SeleniumProject\\Qrcheckpoint\\src\\test\\resources\\drivers\\chromedriver.exe");
        Thread.sleep(400);       
        System.out.println("driver ruunnig!!!!!");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
       // dr.get("https://rudramtech.in/qrcheckpoint/admin/"); // Replace with your login URL
        String url = ConfigReader.getProperty("url");
        dr.get(url);*/
        lp = new LoginPage(dr); // Initialize the page object
    }

   /* @When("user enters username invalid {string} and invalid password {string}")
    public void user_enter_invalid_username_and_password(String username, String password) throws InterruptedException {
    	System.out.println("User enters username and password");
//    	lp.setUsername("admin@");
//        lp.setPassword("asdga@#56");
//        lp.clickLogin();
    	lp.setInvalidUserAndPass(username,password);
    	Thread.sleep(200);
    }*/
    
    
    @When("user enters valid username {string} and valid password {string}")
    public void user_enters_username_and_password(String username, String password) {
        
      //  String    user= ConfigReader.getProperty("username");
      //  String  pass= ConfigReader.getProperty("password");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//       lp.setUsername("abcd");
//       lp.setPassword("sadas@#67");
       
       
        lp.setUsername(username);
        lp.setPassword(password);
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        System.out.println("User clicks on the login button");
        lp.clickLogin();
    }
/*
    @Then("user navigates to the home page")
    public void user_navigates_to_home_page() {
        System.out.println("User navigates to the home page");
        String expectedUrl = "https://example.com/home"; // Replace with your home page URL
        String actualUrl = dr.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Navigation to home page failed!");
        }
        dr.quit();
    }*/
    
    @Then("admin can view Dashboard")
    public void admin_can_view_dashboard() throws InterruptedException {
    	
    //	lp.click_on_dashboardTab();
    	lp.exportPdfReport();
    	Thread.sleep(1000);
    	studAdd= new AddStudents(dr);
    	System.out.println("view!!!!"+ studAdd.getTitle());
    	 college= new CollegePage(dr);
    	 idcard = new IdCardPage(dr);
    	waitHelper= new WaitHelper(dr);
    	//Assert.assertEquals("College Management System", studAdd.getTitle());
    	filterAttend = new AttendanceFilter(dr);
        
        
        
    }
    
//    @Given("admin is on Dashboard")
//    public void show_dashboard() {
//    	lp.click_on_dashboardTab();
//    }
    @When("admin click on Student Details")
    public void admin_click_on_student_menu() throws InterruptedException, AWTException {
    	Thread.sleep(40);
    	//studAdd.searchMenu();
    	
    	Thread.sleep(1000);
    	studAdd.clickManu();
    	
    	System.out.println("student shows !!!!!");
         
    }
    @When("click on add student button")
    public void click_on_add_student_button() {
        studAdd.addStudent();
    }
    @Then("user can view add new student page")
    public void user_can_view_add_new_student_page() throws InterruptedException {
    	Assert.assertEquals("Attendance System Using QRcode", studAdd.getTitle());
    	System.out.println(studAdd.getTitle());
    	Thread.sleep(100);
    	System.out.println("user view details!!!");
       
    }
    
    @When("user enter student info")
    public void user_enter_student_nfo() throws InterruptedException 
    {
    	System.out.println("User enter in block info");
     //  studAdd= new AddStudents(dr);
       studAdd.setRegno("1112");
       studAdd.setName("Harsh KKK");
       studAdd.checkAcademic();
       System.out.println(studAdd);
       studAdd.setGender("Male");
       System.out.println("!!!!!!!");
       studAdd.setBirthDate("02/11/2003");
       studAdd.setMobNo("9345260000");
       String email= randomString()+"@gmail.com";
       studAdd.setEmail(email);
       System.out.println("Gmail enter successfully"+email);
       
       
       studAdd.setAddress("ABC chowk , Pune");
       studAdd.setCity("Pune");
       studAdd.setClass("TYBCOM");
       studAdd.setSemister("Semester-4");
       studAdd.setJoinDate("06/06/2024");
       studAdd.setCategory("General");
       studAdd.setParent("Prakash");
       studAdd.setParentMob("9423700511");
       Thread.sleep(500);
       
    }
    @When("click on save button")
    public void click_on_save_button() throws InterruptedException 
    {
    	
    	
    	studAdd.saveStud();
    	System.out.println("Add button shows admin ");
    	
    	
    	//alert
//    	Thread.sleep(500);
//    	Alert alert= dr.switchTo().alert();
//    	System.out.println("alert working!!!!!");
//    	System.out.println(alert.getText());
//    	alert.accept();
    }
    @And("click on cancel button")
    public void cancelStudform() throws InterruptedException, AWTException {
    	studAdd.cancelForm();
    	Thread.sleep(200);
    	//studAdd.downloadCsv();
    	Thread.sleep(2000);
    	studAdd.uploadCSVInfo();
    	System.out.println("student file upoaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    	Thread.sleep(2000);
    	
    }
    @Then("click on update icon for updating stud info")
    public void click_on_edit_icon() throws InterruptedException, AWTException {
    	studAdd.click_editBtn();
    }
    
    @And("update the information in text field")
    public void update_info_profile_and_category() throws InterruptedException, AWTException {
    	studAdd.editStudInfo();
    }
    
    
  /*  
    @Then("click on Download Dummy CSV button")
    public void downloadDummy()
    {
    	
    	studAdd.downloadCsv();
    	
    	WebElement uploadBtn1 = dr.findElement(By.xpath("//input[@name='file']"));
		uploadBtn1.click();
    	//studAdd.fileChoose();
    	//studAdd.upload1();
   
    }
    
    @When("admin choose valid CSV file")
    public void choiseFile() throws AWTException, InterruptedException {
    	System.out.println("choose file running !!!");
    	studAdd = new AddStudents(dr);
    	/*studAdd.uploadCSV();*/
    /*	if (studAdd != null) {
    	    studAdd.uploadCSV();
    	} else {
    	    System.out.println("studAdd is null. Please initialize it before calling uploadCSV.");
    	}
   
    	//System.out.println("uploading completed.");
    	Thread.sleep(500);*/
  // }
    /*
    
   @Then("user can view confirmation popup message {string}")
    public void user_can_view_confirmation_popup_message(String string) 
    {
        
    }
    
    @And("click on ok button")
    public void click_on_btn() {
    	
    }*/
//    
    
  /*  
    @Then("click on search bar and enter student name")
    public void searchStudName() {
    	
    	searchStudent.setName("Sonali Limbapure");
    }
	  
    @And("close browser")
    public void close_browser() throws InterruptedException 
    {
    	lp.logout();
    	Thread.sleep(500);
    	dr.close();
  
    }*/
    
    /* ********************************* ID Card Details *******************************************************************/
    
    @When("click on IDMenu")
    public void idCardMenutest() 
    {
         idcard.clickIdCardMenu();	
    }
    
    @Then("click on search field and enter email")
    public void enter_search_textfield() {
    	idcard.clickSearch();
    }
    
    @And("searching student email Id in table")
    public void search_idCard() {
    	
    	boolean searchStatus= idcard.searchByEmailIdCard("prachi581@gmail.com");
    	//System.out.println(searchStatus);
    	Assert.assertEquals(true, searchStatus);
    }
    @And("click on view IdCard button")
    public void click_on_viewCardBtn() {
    	
    	idcard.clickOnViewIDcardBtn();
    }
    
    @And("download IdCard PDF")
    public void download_pdf_of_Idcard() throws InterruptedException {
    	idcard.downloadIdcardPdf();
    	Thread.sleep(2000);
    	System.out.println("download IDCard PDF successfully");
    }
    
//    @Then("enter the student email in search field")
//    public void search_student_idcard_using email() {
//    	
//    }
    
    
    
    /* *********College Profile ****************************************************************************/
  
    @When("click on College Menu")
    public void collegeTest() throws InterruptedException {
    	
    	Thread.sleep(200);
    	college.clickCollegeMenu();
    }
    
    
    @And("click on searchbox text and enter email")
    public void searchCollegeTest() throws InterruptedException {
    	college.clickSearchCollege();
    	Thread.sleep(2000);
    }
    
    @Then("user searching email in table")
    public void user_find_email_In_searchbar()
    {
    	
    	boolean status=college.searchByCollegeEmail("contact@rudramtech.in");
    	if(status)
    	{
    		
    	}
    	Assert.assertEquals(true, status);
    }
    
    @And("click on college profile edit button")
    public void click_on_editBtn_college_profile_Test() throws InterruptedException {
    	college.clickEditbutton();
    	Thread.sleep(2000);
    }
    
    @Then("enter information in field")
    public void college_info_fill_and_update() throws InterruptedException, AWTException
    {
    	college.editCollegeProfileFields();
    }
    @And("scroll the page and click on edit button")
    public void scroll_college_edit_profile_page_and_submit() throws InterruptedException {
    	college.scrollPageUpdate();
    }
    
    /* *******************************Attendance Filter************************************************ */
    @Then("click on attendance filter")
    public void click_on_attendance_filter() throws InterruptedException {
    	filterAttend.clickOn_attendanceFilter_Menu();
    }
    
    
    @And("click on download attendance report")
    public void download_pdf_of_attendance_report() throws InterruptedException 
    {
    	filterAttend.downloadPdfAttendance();
    	
    }
    
    /* ******************************************************************************************* */
    @And("Logout admin")
    public void logoutAdmin() throws InterruptedException
    {
    	lp.logout();
    }
   /* @And("close the browser")
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(200);
    	dr.close();
    }*/
}
