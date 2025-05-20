package Practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddProductToCartWithGU extends BaseClass{
	
	
//Retry Analyzer code
@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	
	public void tc_01_AddProductToCartTest() throws IOException
	{
				
		//Read Data from Excel
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 4, 2);
		
		
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
		
	}

@Test
public void sample()
{
	Assert.fail();
	System.out.println("Sample");
}
}
