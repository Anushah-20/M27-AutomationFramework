package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL= p.getProperty("url");
		String USERNAME= p.getProperty("username");
		String PASSWORD= p.getProperty("password");
		
		FileInputStream fise= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fise);
		Sheet sh= wb.getSheet("Products");
		Row rw= sh.getRow(4);
		Cell cl= rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		
		System.out.println(PRODUCTNAME);
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("login-button")).click();
	   
	    
	    driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
	   // String productName = ele.getText();
	   // ele.click();
	   // System.out.println(productName);
	    
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		
		WebElement cartProduct = driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]"));
		String cart = cartProduct.getText();
		System.out.println(cart);
		
		if(PRODUCTNAME.equals(cart))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Failed");
		}
		
		Thread.sleep(5000);
		driver.quit();

	}

}
