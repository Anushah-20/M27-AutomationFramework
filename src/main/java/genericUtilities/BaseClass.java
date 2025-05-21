package genericUtilities;
/**
 * This class consists of basic configuration annotation for TestNG
 * @author ANUSHAH S
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public FileUtility fUtil= new FileUtility();
	public JavaUtility jUtil= new JavaUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
	System.out.println("====Database connection successful====");	
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL= fUtil.readDataFromPropertyFile("url");
		
		//for cross browser testing-"run time polymorphism"
		
		driver= new ChromeDriver();
		
		/*if(pValue.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(pValue.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}*/
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		//for listener
		sdriver= driver;
		
		System.out.println("===Browser Launch successful===");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD= fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("===Login to App successful===");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip= new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("===Logout of App Successful===");
	}
	
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("===Browser Closure successful===");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("===Database Closure successful===");
	}

}
