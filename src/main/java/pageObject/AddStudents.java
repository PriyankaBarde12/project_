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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddStudents {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public AddStudents(WebDriver dr) {

		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[normalize-space()='View Student Details']")
	WebElement studpage1 ;
	
	
	@FindBy(linkText = "Add Student")
	WebElement addstudBtn;
	
	@FindBy(css="input[placeholder='Reg. No']")
	WebElement regtxt;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	WebElement nametxt;
	
	@FindBy(css = "select[name='txtgender']") //use select class
	By gendertxt;
	
	@FindBy(css = "input[placeholder='Date Of Birth']")
	WebElement birthdatetxt;
	
	@FindBy(css = "input[placeholder='Mobile Number']")
	WebElement mobnotxt;
	
	@FindBy(css = "input[placeholder='Email ID']")
	WebElement emailtxt;
	
	@FindBy(css="input[placeholder='Address Details']")
	WebElement addresstxt;
	
	@FindBy(css="input[placeholder='City']")
	WebElement citytxt;
	
	@FindBy(css = "input[placeholder='Class']")
	WebElement classtxt;
	
	@FindBy(css="select[name='txtstream']")
	By streamtxt;   //use select class
	
	@FindBy(name="txtdoj")
	WebElement datejointxt;
	
	@FindBy(css = "select[name='txtcategory']")  //use select class
	WebElement categorytxt;
	
	@FindBy(css="input[placeholder='Parent Name']")
	WebElement parentNametxt;
	
	@FindBy(css="input[placeholder='Parent Mobile']")
	WebElement parentMobtxt;
	
	@FindBy(css="input[value='Add Student']")
	WebElement saveAddstudBtn;
	
	@FindBy(css = ".cancel")
	WebElement cancelstudBtn;
	
	@FindBy(name="txtacademicyear")
	WebElement yeartxt;
	
	@FindBy(xpath="//span[normalize-space()='Student Details']")
	WebElement studMenuuu;
	
	@FindBy(linkText = "Download Dummy CSV")
	WebElement downloadCsvtxt;
	
	//upload CSV file
//	@FindBy(css="//div[@class='custom-file']")
//	WebElement fileUpload;
	
	@FindBy(xpath="//div[@class='custom-file']")
	WebElement fileUploadBtn;
	
	//Edit stud
	//Update
	@FindBy(xpath="//span[@onclick='funupdate(1010)']")
	WebElement updateBtn;
	
	@FindBy(xpath = "//input[@placeholder='Full Name']")
	WebElement fnameUpdate;
	
	@FindBy(xpath="///input[@name='txtdoj']")
	WebElement dojUpdate;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement subEditBtn;
	
	//Update profile photo
	@FindBy(xpath = "//input[@id='f1']")
	WebElement profileImgtxt;
	
	@FindBy(xpath = "//input[@name='photosave']")
	WebElement profileUpdateBtn;
	
	@FindBy(xpath="//input[@name='savecat']")
	WebElement updateCategory;
	
	//View
	@FindBy(xpath="//span[@onclick='funview(1010)']")
	WebElement viewBtn;
	
	
	
	
	//delete
	@FindBy(xpath="//span[@onclick='fundel(5)']")
	WebElement deleteBtn;
	
	
	
//	public void fileChoose() {
//		fileUpload.click();
//	}
	
	public void clickManu() {
		studMenuuu.click();
	}
//	public void searchMenu() {
//		
//		List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class='nav page-navigation']"));
//	
//			for(WebElement custMenu: menuList)
//			{
//				if(custMenu.getText().equals("Student Details"))
//				{
//					custMenu.click();
////					if(studpage1.isDisplayed())
////					{
////						this.addStudent();
////					}
//				}
//				else if(custMenu.getText().equals("College Profile"))
//				{
//					
//				}
//				else {
//					
//				}
//			}
//	
//	}
	//download CSV file
	
	//Upload Student Info file
	public void uploadCSVFile() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement fileUploadElement = wait.until(ExpectedConditions.elementToBeClickable(fileUploadBtn));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fileUploadElement); //click actions
		
		Robot rb = new Robot();
        rb.delay(1000);
        System.out.println("Running !!!!!");

        // Put file path on clipboard
        StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\students.csv");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        System.out.println("Address copied successfully");

        Thread.sleep(1000);
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
	
	public void addStudent()
	{
		addstudBtn.click();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void setRegno(String num) {
		regtxt.sendKeys(num);
	}
	
	public void setName(String name) {
		nametxt.sendKeys(name);
	}


	public void checkAcademic()
	{
		if(yeartxt.isDisplayed())
		{
			System.out.println(yeartxt.getText());
		}
	}
	public void setGender(String gender)
	{
//		By gen1 = By.xpath( "//select[@name='txtgender']");
//		WebElement gen =driver.findElement(gendertxt).click();
//		Select drp= new Select(driver.findElement(gen));
//		drp.selectByVisibleText(gender);
		
			By genderDropdown = By.xpath("//select[@name='txtgender']");
		  
		    WebElement dropdownElement = driver.findElement(genderDropdown);
		    Select genderSelect = new Select(dropdownElement);
		    genderSelect.selectByVisibleText(gender);
	}
	
	
	
	
	public void setBirthDate(String date)
	{
		birthdatetxt.sendKeys(date);
	}
	
	public void setMobNo(String mobno) {
		mobnotxt.sendKeys(mobno);
	}
	
	public void setEmail(String email)
	{
		emailtxt.sendKeys(email);
	}
	
	public void setAddress(String addr)
	{
		addresstxt.sendKeys(addr);
	}
	
	
	public void setCity(String city)
	{
		citytxt.sendKeys(city);
	}
	
	public void setClass(String standredclass)
	{
		classtxt.sendKeys(standredclass);
		
	}

	public void setSemister(String semister)
	{
//		Select streSelect = new Select(driver.findElement(streamtxt));
//		streSelect.selectByVisibleText(semister);
		
		By semester = By.xpath("//select[@name='txtstream']");
		  
	    WebElement streamEle = driver.findElement(semester);
	    Select streamSel = new Select(streamEle);
	   streamSel.selectByVisibleText(semister);
	}
	
	public void setJoinDate(String join) {
		datejointxt.sendKeys(join);
	}


	public void setCategory(String cate)
	{
//		List<WebElement> catList= driver.findElements(By.cssSelector("select[name='txtcategory']"));
//		for(WebElement list : catList)
//		{
//			if(list.getText().equals(cate))
//			{
//				list.click();
//			}
//		}
		
		By catDropdown = By.xpath("//select[@name='txtcategory']");
		  
	    WebElement catElement = driver.findElement(catDropdown);
	    Select cateSelect = new Select(catElement);
	    cateSelect.selectByVisibleText(cate);
	}

	public void setParent(String name)
	{
		parentNametxt.sendKeys(name);
	}
	
	public void setParentMob(String mob)
	{
		parentMobtxt.sendKeys(mob);
	}
	
	public void saveStud() throws InterruptedException {
		saveAddstudBtn.click();
	//	driver.findElement(By.xpath("//input[@value='Add Student']"));
		
	}
	
	public void cancelForm() {
		cancelstudBtn.click();
	}
	
	public void downloadCsv()
	{
		//driver.findElement(downloadCsvtxt).click();
		if(downloadCsvtxt.isDisplayed())
		{
			System.out.println(downloadCsvtxt.getText());
			downloadCsvtxt.click();
		}
	}
	
	/*public void uploadCSV() throws AWTException, InterruptedException {
		
		
		//driver.findElement(By.xpath("//input[@name='file']")).click();
		
		//WebElement chooseFile= driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", fileUpload); //click actions
		
		
		Thread.sleep(1000); 
	
		
		Robot rb =new Robot();
		
		rb.delay(1000);
		System.out.println("running !!!!!");
		//put path to file on clipboard
		StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\students.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// we copied 
		System.out.println("address copied successfully");
		//CTR+V
		rb.keyPress(KeyEvent.VK_CONTROL);//press on Ctrl
		rb.keyPress(KeyEvent.VK_V); 
		System.out.println("file addr paste syccessfully");
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
	}*/
	
	@FindBy(xpath="//input[@value='Upload']")
	WebElement uploadBtn;
	public void upload1() {
		uploadBtn.click();
	}
	
	public void uploadCSVInfo() throws AWTException, InterruptedException 
	{
	    // Cast WebDriver to JavascriptExecutor
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Click on the file upload input using JavaScript
	    js.executeScript("arguments[0].click();", fileUploadBtn);
	    Thread.sleep(2000);
	    // Wait for the upload dialog to appear
	    Thread.sleep(1000);

	    // Use Robot class to input the file path
	    Robot rb = new Robot();
	    rb.delay(1000);

	    // Copy file path to clipboard
	    StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\students.csv");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    System.out.println("File path copied to clipboard");
	    Thread.sleep(2000);

	    // Simulate CTRL+V to paste the file path
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    System.out.println("File path pasted");

	    // Simulate ENTER key to confirm file selection
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    System.out.println("File upload confirmed");
	}

	//Edit stud info
	public void click_editBtn() throws InterruptedException, AWTException {
		
		updateBtn.click();
	}
	public void editStudInfo() throws InterruptedException, AWTException
	{
		fnameUpdate.click();
		fnameUpdate.clear();
		fnameUpdate.sendKeys("Prachiti");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(300);
	
		dojUpdate.click();
		dojUpdate.clear();
		
//		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='txtdoj']")));
//		driver.findElement(By.className("form-control"))
		
		dojUpdate.sendKeys("12-12-2025");
		
		js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(300);
	
		subEditBtn.click();
		
		
		   Robot rb = new Robot();
	        rb.delay(1000);
	        System.out.println("Running !!!!!");

	        // Put file path on clipboard
	        StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\profile.jpg");
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
	        
	        profileUpdateBtn.click();
	        
	        Thread.sleep(300);
	        updateCategory.click();
	        Thread.sleep(100);
	       
	}
	
	//View student
	public void click_viewBtn() {
		
	}
	public void viewStudent_information() {
		
	}
	
	//delete student
	public void deleteStudent_from_table() {
		
	}
}
