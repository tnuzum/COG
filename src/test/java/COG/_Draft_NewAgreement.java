package COG;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;


public class _Draft_NewAgreement extends base{

/*
 * purchase a new agreement with existing member
 * go to member mgmt
 * cancel agreement
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
