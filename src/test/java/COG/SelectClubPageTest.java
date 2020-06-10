package COG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SelectClubPO;
import resources.base;
import resources.reusableMethods;

public class SelectClubPageTest extends base {

	static SoftAssert softAssertion= new SoftAssert();
	SelectClubPO sc = new SelectClubPO(driver);

	@BeforeTest
	public void initialize() throws Throwable {
		driver = initializeDriver();
		driver.get(prop.getProperty("COGLoginPage"));
		reusableMethods.employee1Login();
	}

	@Test(priority = 1, description = "Page Title")
	public void pageTitle() {
		Assert.assertEquals(driver.getTitle(), "Jonas Fitness: Compete On The Go");
	}

	@Test(priority = 2, description = "Page Verifications")
	public void pageVerifications() {
		SelectClubPO sc = new SelectClubPO(driver);
		softAssertion.assertEquals(sc.getPageHeader().getText(), "Select Club");
		softAssertion.assertTrue(sc.getTopOfPageLogo().isDisplayed());
		softAssertion.assertTrue(sc.getBottomOfPageLogo().isDisplayed());
		softAssertion.assertEquals(sc.getSelectButton().getText(), "Select");
		softAssertion.assertAll();
	}

	@Test(priority = 3, description = "Club Required")
	public void clubRequired() {
		SelectClubPO sc = new SelectClubPO(driver);
		sc.getSelectButton().click();
		softAssertion.assertEquals(sc.getClubRequiredMessage().getText(), "Please select Club");
		softAssertion.assertAll();
	}

	@Test(priority = 4, description = "Select Club")
	public void selectClub(){
		SelectClubPO sc = new SelectClubPO(driver);
		Assert.assertTrue(sc.getClubDropdown().isEnabled());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
