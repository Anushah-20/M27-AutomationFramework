package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method related to files
 * @author ANUSHAH S
 */

public class FileUtility {
	
	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String value= p.getProperty(key);
		return value;
	}
	
	/**
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * This method will read and return the value from excel file to caller
	 * @return value
	 * @param sheetName, row, cell 
	 */
	public String readDataFromExcelFile(String sheetName, int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row rw= sh.getRow(row);
		Cell cl= rw.getCell(cell);
		String value = cl.getStringCellValue();
		return value;
	}

}
