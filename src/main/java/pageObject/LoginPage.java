package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver dr) {
        driver = dr;
        PageFactory.initElements(dr, this);
    }

    @FindBy(xpath="//input[@id='inputEmailAddress']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(name = "txtadpassword")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='sub']")
    @CacheLookup
    WebElement btnLogin;

    
    
    @FindBy(xpath="//font[normalize-space()='.admin@gmail.com']")
    @CacheLookup
    WebElement lnkLogout;
    
    @FindBy(xpath="//a[normalize-space()='Signout']")
    @CacheLookup
    WebElement logoutBtn;
    
    @FindBy(xpath="//span[normalize-space()='Dashboard']")
	WebElement dashboard;
    
    @FindBy(xpath = "//b[normalize-space()='Please check your username and password.']")
    WebElement invalidMsg;
   
    //download dashBoard Report
    @FindBy(xpath="//a[normalize-space()='Export Report']")
    WebElement exportPdfBtn;
    
    
    //Invalid user and password
    public void setInvalidUserAndPass(String username,String password) throws InterruptedException {
    	txtEmail.sendKeys(username);
    	txtPassword.sendKeys(password);
    	Thread.sleep(200);
    	btnLogin.click();
    	Thread.sleep(200);
    	//System.out.println(invalidMsg.getText());
    	
    }
    public void setUsername(String username) {
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }

  
    
    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
       // System.out.println(txtPassword.getText());
    }

    public void clickLogin() 
    {
        btnLogin.click();
    }
    
    public void click_on_dashboardTab() {
    	dashboard.click();
    	
    }
    public void logout() throws InterruptedException
    {
    	lnkLogout.click();
    	Thread.sleep(40);
    	logoutBtn.click();
    }
    
    public void exportPdfReport() throws InterruptedException {
    	Thread.sleep(2000);
    	exportPdfBtn.click();
    	Thread.sleep(500);
    	
    	System.out.println("Export report downloaded successfully");
    }
    
}
