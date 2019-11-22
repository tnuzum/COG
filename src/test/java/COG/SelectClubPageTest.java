package COG;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPO;
import pageObjects.SelectClubPO;
import resources.base;
import resources.reusableMethods;


public class SelectClubPageTest extends base{
	
//	public static SoftAssert softAssertion= new SoftAssert();

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
	@Test (priority = 2, description="pageVerifications")
	public void pageVerifications() throws InterruptedException
		{
			SoftAssert softAssertion= new SoftAssert();
			reusableMethods.employee1Login();
			SelectClubPO sc = new SelectClubPO(driver);
			softAssertion.assertEquals(sc.getPageHeader().getText(), "Select Club");
			softAssertion.assertTrue(sc.getTopOfPageLogo().isDisplayed());
			softAssertion.assertTrue(sc.getBottomOfPageLogo().isDisplayed());
			softAssertion.assertEquals(sc.getSelectButton().getText(), "Select");
			softAssertion.assertAll();
		}
	@Test (priority = 3, description="Club Required")
	public void clubRequired()
		{
			SoftAssert softAssertion= new SoftAssert();
			SelectClubPO sc = new SelectClubPO(driver);
			sc.getSelectButton().click();
			softAssertion.assertEquals(sc.getClubRequiredMessage().getText(),"Please select Club");
			softAssertion.assertAll();
		}
	@Test (priority = 4, description="Select Club")
	public void selectClub() throws InterruptedException
		{
		SelectClubPO sc = new SelectClubPO(driver);
		Assert.assertTrue(sc.getClubDropdown().isEnabled());	   
			}
	@AfterTest
		public void teardown() throws InterruptedException
		{
			driver.close();
			driver=null;
		}
	
	
	
	

}
