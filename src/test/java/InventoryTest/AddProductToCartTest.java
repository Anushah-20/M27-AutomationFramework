package InventoryTest;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenerImplementation.class)

public class AddProductToCartTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	
	public void tc_01_AddProductToCartTest() throws IOException
	{
		
		//object creation
		//FileUtility fUtil= new FileUtility();
		//SeleniumUtility sUtil= new SeleniumUtility();
		
		//Read data from properties file
		//String URL= fUtil.readDataFromPropertyFile("url");
		//String USERNAME= fUtil.readDataFromPropertyFile("username");
		//String PASSWORD= fUtil.readDataFromPropertyFile("password");
				
		//Read Data from Excel
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 2);
		
		//launch browser
		//WebDriver driver= new ChromeDriver();
		//sUtil.maximizeWindow(driver);
		//sUtil.addImplicitlyWait(driver);
		

		//load url
		//driver.get(URL);
		
		//LoginPage lp= new LoginPage(driver);
		
		//lp.loginToApp(USERNAME, PASSWORD);
		
		//click on product
		InventoryPage ip= new InventoryPage(driver);
		ip.clickOnProduct(driver,PRODUCTNAME);
		
		//add product to cart
		InventoryItemPage iip= new InventoryItemPage(driver);
		iip.clickOnAddToCartButton();
		
		//click on cart icon
		ip.clickOnCartBtn();
		
		//validate in cart
		CartPage cp = new CartPage(driver);
		String productInCart=cp.productName();
		
		
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		System.out.println(productInCart);
		
		//if(productInCart.equals(PRODUCTNAME))
		//{
		//	System.out.println("Pass");
		//	System.out.println(productInCart);
		//}
		//else
		//{
		//	System.out.println("Fail");
		//}
		
		//Logout
		
		//ip.logoutOfApp();
	}

	@Test
	
	public void sampleTest()
	{
		
		System.out.println("Sample");
	}
}
