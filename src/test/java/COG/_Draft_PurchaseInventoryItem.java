package COG;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;


public class _Draft_PurchaseInventoryItem extends base{

/*
 * go to POS
 * purchase an inventory item
 * go to back office / member mgmt / transaction history, verify transaction is found
 * 
 * test 1 - pay with cash
 * test 2 - pay with account
 * 
 */

	@BeforeTest
		public void initialize() throws IOException
		{
			 driver = initializeDriver();
			 driver.get(prop.getProperty("COGLoginPage"));
		}
		
	@Test (priority = 1, description="...")
		public void pageVerifications() throws IOException
		{
		

		}
	@Test (priority = 2, description="...")
		public void pageValidations() throws IOException
		{
		

		}

	@AfterTest
		public void teardown() throws InterruptedException
		{
			driver.close();
			driver=null;
		}
	
	
	
	

}
