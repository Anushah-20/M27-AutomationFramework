package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consist of generic methods related to java
 * @author ANUSHAH S
 */

public class JavaUtility {
	/**
	 * This method will capture the current system date in required format and 
	 * return to caller
	 * @return dateInFormat
	 */
	
	public String getSystemDate()
	{
		Date d= new Date();
		SimpleDateFormat f= new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String dateInFormat = f.format(d);
		return dateInFormat;
	}

}
