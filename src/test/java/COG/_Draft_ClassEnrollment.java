package COG;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;


public class _Draft_ClassEnrollment extends base{

/*
 * go to class checkin
 * select class
 * checkin member
 * click remove
 * 
 * test 1 - remove check-in only, confirm still enrolled
 * test 2 - remove check-in and un-enroll
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
