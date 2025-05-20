package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{
	
	//declaration
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartBtn;
	
	@FindBy(className = "product_sort_container")
	private WebElement productSortDropDown;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	//Initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getCartBtn() {
		return cartBtn;
	}


	public WebElement getProductSortDropDown() {
		return productSortDropDown;
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	//business library
	/**
	 * This method will click on the product
	 * 
	 * @param driver
	 * @param productName
	 */
	
	public void clickOnProduct(WebDriver driver,String productName)
	{
		driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
	}
	
	/**
	 * This method will log out of the application
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutBtn.click();
	}
	

	/**
	 * This method will sort for lowest price product and then click on it
	 * @param driver
	 * @param sortOption
	 * @param productname
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productname)
	{
		dropDownHandle(productSortDropDown, sortOption);
		driver.findElement(By.xpath("//div[text()='"+productname+"']")).click();
	}
	
	/**
	 * This method will click on cart button
	 */
	public void clickOnCartBtn()
	{
		cartBtn.click();
	}
}
