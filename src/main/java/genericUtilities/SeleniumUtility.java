package genericUtilities;
/**
 * This class consist of reusable method with respect to java selenium tool
 * @author ANUSHAH S
 */

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * This method will add 10 seconds of implicitly wait
	 *  @param driver
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for seconds for a particular web element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will select the web element in drop down using index
	 * @param element
	 * @param index
	 */
	
	public void dropDownHandle(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select the web element in drop down using visible text
	 * @param element
	 * @param text
	 */
	
	public void dropDownHandle(WebElement element, String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will select the web element in drop down using value
	 * @param element
	 * @param value
	 */
	
	public void dropDownHandle(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to perform mouse over action on WE
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to click and hold the WE
	 * @param driver
	 * @param element
	 */
	
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 *This method is used to Double click the WE
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used to drag and drop the Source WE to Target WE
	 * @param driver
	 * @param source_element
	 * @param target_element
	 */
	
	public void dragAndDrop(WebDriver driver, WebElement source_element, WebElement target_element)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(source_element, target_element).perform();
	}
	
	/**
	 * This method is used right click on WE
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method is used scroll to WE
	 * @param driver
	 * @param element
	 */
	
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method is used to switch to the frame using index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method is used to switch to the frame using name or id
	 * @param driver
	 * @param frameIndex
	 */
	
	public void handleFrame(WebDriver driver, String framenameOrId)
	{
		driver.switchTo().frame(framenameOrId);
	}
	/**
	 * This method is used to switch to the frame using WE
	 * @param driver
	 * @param frameIndex
	 */
	
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will enter text into alert pop up
	 * @param driver
	 * @param text
	 */
	
	public void enterAlertText(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture the test of alert pop up
	 * @param driver
	 * @return
	 */
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will capture and return the path of ss to caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dst= new File(".\\Screenshot\\"+screenShotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath();
		
	}
	
}
