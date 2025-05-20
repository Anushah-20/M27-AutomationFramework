package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeBtn;
	
	@FindBy(className = "inventory_item_name")
	private WebElement productName;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	public WebElement getProductName() {
		return productName;
	}
	
	
	//business library
	
	/**
	 * this method will click on continue shopping
	 */
	
	public void clickOnContinueShopping()
	{
		continueShoppingBtn.click();
	}
	
	/**
	 * This method will remove product from cart
	 */
	public void removeProductFromCart()
	{
		removeBtn.click();
	}
	
	/**
	 * This method will check out the product
	 */
	public void checkOut()
	{
		checkoutBtn.click();
	}
	
	/**
	 * This method will return the product name
	 * @return
	 */
	public String productName()
	{
		return productName.getText();
	}
}
