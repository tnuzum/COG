package COG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.DashboardPO;
import resources.base;
import resources.reusableMethods;

public class DashboardPageTest extends base {

	public static String baseURL = "https://ess-qa.dev-jfisoftware.com/";

	@BeforeTest
	public void initialize() throws Throwable {
		driver = initializeDriver();
		driver.get(prop.getProperty("COGLoginPage"));
		reusableMethods.employee1Login();
		reusableMethods.selectClub();
	}

	@Test(priority = 1, description = "Header Verifications")
	public void headerVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertTrue(d.getLogo().isDisplayed());
		Assert.assertEquals("Change Password", d.getChangePasswordLink().getText());
		Assert.assertTrue(d.getChangePasswordLink().isEnabled());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Account/ChangePassword",
				d.getChangePasswordLink().getAttribute("href"));
		Assert.assertEquals("Logoff", d.getLogoffLink().getText());
		Assert.assertTrue(d.getLogoffLink().isEnabled());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Account/Logoff", d.getLogoffLink().getAttribute("href"));
	}

	@Test(priority = 2, description = "Front Desk Tile Verifications")
	public void frontDeskTileVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertEquals("Front Desk", d.getFDeskTileTitle().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/FrontDesk/Home", d.getFDeskHomeLink().getAttribute("href"));
		Assert.assertTrue(d.getFDeskHomeLink().isEnabled());

		Assert.assertEquals("Member & Guest Enrollment", d.getFDeskMemberGuestEnroll().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/FrontDesk/PlanBuilder/Enrollment",
				d.getFDeskMemberGuestEnroll().getAttribute("href"));
		Assert.assertTrue(d.getFDeskMemberGuestEnroll().isEnabled());

		Assert.assertEquals("Check-In", d.getFDeskCheckIn().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/FrontDesk/CheckIn", d.getFDeskCheckIn().getAttribute("href"));
		Assert.assertTrue(d.getFDeskCheckIn().isEnabled());

		Assert.assertEquals("POS", d.getFDeskPOS().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Frontdesk/PointOfSale", d.getFDeskPOS().getAttribute("href"));// note
																													// lowercase
																													// 'd'
																													// in
																													// Frontdesk
		Assert.assertTrue(d.getFDeskPOS().isEnabled());

		Assert.assertEquals("Class Check-In", d.getFDeskClassCheckIn().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Frontdesk/ClassCheckIn",
				d.getFDeskClassCheckIn().getAttribute("href"));// note lowercase 'd' in Frontdesk
		Assert.assertTrue(d.getFDeskClassCheckIn().isEnabled());
	}

	@Test(priority = 3, description = "Back Office Tile Verifications")
	public void backOfficeTileVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertEquals("Back Office", d.getBOfficeTileTitle().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Backoffice/Home", d.getBOfficeHomeLink().getAttribute("href"));// note
																														// lowercase
																														// 'o'
																														// in
																														// Backoffice
		Assert.assertTrue(d.getBOfficeHomeLink().isEnabled());

		Assert.assertEquals("Member Management", d.getBOfficeMemberMgmt().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/BackOffice/MemberManagement",
				d.getBOfficeMemberMgmt().getAttribute("href"));
		Assert.assertTrue(d.getBOfficeMemberMgmt().isEnabled());

		Assert.assertEquals("Club Taxes", d.getBOfficeClubTaxes().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/BackOffice/ClubTaxes",
				d.getBOfficeClubTaxes().getAttribute("href"));
		Assert.assertTrue(d.getBOfficeClubTaxes().isEnabled());

		Assert.assertEquals("Agreement Management", d.getBOfficeAgreementMgmt().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/BackOffice/AgreementManagement",
				d.getBOfficeAgreementMgmt().getAttribute("href"));
		Assert.assertTrue(d.getBOfficeAgreementMgmt().isEnabled());

	}

	@Test(priority = 4, description = "Reporting Tile Verifications")
	public void reportingTileVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertEquals("Reporting", d.getReportingTileTitle().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Reports/Home", d.getReportingHomeLink().getAttribute("href"));
		Assert.assertTrue(d.getReportingHomeLink().isEnabled());

		Assert.assertEquals("View All Reports", d.getReportingViewAllReports().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Reports", d.getReportingViewAllReports().getAttribute("href"));
		Assert.assertTrue(d.getReportingViewAllReports().isEnabled());
	}

	@Test(priority = 5, description = "Admin Tile Verifications")
	public void adminTileVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertEquals("Admin", d.getAdminTileTitle().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Admin/Home", d.getAdminHomeLink().getAttribute("href"));
		Assert.assertTrue(d.getAdminHomeLink().isEnabled());

		Assert.assertEquals("JOL Admin", d.getAdminJOLAdmin().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Admin/JOLHome", d.getAdminJOLAdmin().getAttribute("href"));
		Assert.assertTrue(d.getAdminJOLAdmin().isEnabled());

		Assert.assertEquals("Empower ME Admin", d.getAdminEMEAdmin().getText());
		Assert.assertEquals(baseURL + "CompeteOnTheGo/Admin/MSSHome", d.getAdminEMEAdmin().getAttribute("href"));
		Assert.assertTrue(d.getAdminEMEAdmin().isEnabled());
	}

	@Test(priority = 6, description = "Footer Verifications")
	public void footerVerifications() {
		DashboardPO d = new DashboardPO(driver);
		Assert.assertEquals(baseURL + "CompeteOnTheGo/", d.getFooterHomeLink().getAttribute("href"));
		Assert.assertTrue(d.getFooterHomeLink().isEnabled());

		Assert.assertEquals(baseURL + "CompeteOnTheGo/FrontDesk", d.getFooterShoppingCart().getAttribute("href"));
		Assert.assertTrue(d.getFooterShoppingCart().isEnabled());

		Assert.assertEquals(baseURL + "CompeteOnTheGo/BackOffice", d.getFooterBackOffice().getAttribute("href"));
		Assert.assertTrue(d.getFooterBackOffice().isEnabled());

		Assert.assertEquals(baseURL + "CompeteOnTheGo/Reports", d.getFooterReports().getAttribute("href"));
		Assert.assertTrue(d.getFooterReports().isEnabled());

		Assert.assertEquals(baseURL + "CompeteOnTheGo/Admin/Home", d.getFooterAdmin().getAttribute("href"));
		Assert.assertTrue(d.getFooterAdmin().isEnabled());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
