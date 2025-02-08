package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver ldriver;
	public WaitHelper(WebDriver dr) {
		this.ldriver= dr;
	}

	public void waitForElement(WebElement elements, Duration timeOutInsec)
	{
		WebDriverWait drWait= new WebDriverWait(ldriver, timeOutInsec);
		drWait.until(ExpectedConditions.visibilityOf(elements));
	}
}
