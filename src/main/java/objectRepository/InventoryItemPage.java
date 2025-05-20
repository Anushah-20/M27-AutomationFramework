package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	//declaration
	@FindBy(id = "add-to-cart")
	private WebElement addToCartBtn;


	//initialization
	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	//business library
	
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddToCartButton() {
		addToCartBtn.click();
	}
	

}
