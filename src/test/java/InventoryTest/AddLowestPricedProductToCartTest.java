package InventoryTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddLowestPricedProductToCartTest extends BaseClass {
		
		@Test(groups = "RegressionSuite")
		public void tc_02_AddLowestPricedProductToCartTest() throws EncryptedDocumentException, IOException
		{
		
		//object creation
						
				//Read Data from Excel
				String SORTOPTION = fUtil.readDataFromExcelFile("Products", 6, 3);
				String PRODUCTNAME = fUtil.readDataFromExcelFile("Products", 6, 2);
				
				//click on lowest priced product
				InventoryPage ip= new InventoryPage(driver);
				ip.clickOnLowestPriceProduct(driver,SORTOPTION,PRODUCTNAME);
				
				//driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
				
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
	
				

}


