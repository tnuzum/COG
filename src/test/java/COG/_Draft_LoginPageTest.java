package COG;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPO;
import resources.base;
import resources.reusableMethods;


public class _Draft_LoginPageTest extends base{
	
	public static SoftAssert softAssertion= new SoftAssert();

	@BeforeTest
		public void initialize() throws IOException
		{
			 driver = initializeDriver();
			 driver.get(prop.getProperty("COGLoginPage"));
		}
	@Test (priority = 1, description="Page Title")
		public void pageTitle()
		{
			Assert.assertEquals(driver.getTitle(),"Jonas Fitness: Compete On The Go");
		}		
	@Test (priority = 1, description="pageVerifications")
		public void pageVerifications()
		{
		
		LoginPO l = new LoginPO(driver);
		softAssertion.assertEquals(l.getUserName().getAttribute("placeholder"), "Enter your name");
		softAssertion.assertEquals(l.getPassword().getAttribute("placeholder"), "Password");
		softAssertion.assertTrue(l.getTopOfPageLogo().isDisplayed());
		softAssertion.assertTrue(l.getBottomOfPageLogo().isDisplayed());
		System.out.println(l.getLoginButton().getText());
		softAssertion.assertAll();

//		System.out.println(l.getPassword().getText());
		}
	@Test (priority = 2, description="credentialsRequired")
		public void credentialsRequired()
		{
		LoginPO l = new LoginPO(driver);
		l.getLoginButton().click();
		softAssertion.assertEquals(l.getusernameRequiredMessage().getText(),"tUser name is required");
		softAssertion.assertEquals(l.getpasswordRequiredMessage().getText(), "tPassword is required");
		softAssertion.assertAll();
		}

	@AfterTest
		public void teardown() throws InterruptedException
		{
		Thread.sleep(2000);
			driver.close();
			driver=null;
		}
	
	
	
	

}
