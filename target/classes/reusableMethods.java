package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import pageObjects.LoginPO;
import pageObjects.SelectClubPO;

public class reusableMethods extends base {

	public static String employee1Login() throws InterruptedException{
		reusableWaits.waitForLoginPage(10);
		LoginPO l = new LoginPO(driver);
		l.getUserName().sendKeys(prop.getProperty("Employee1UserName"));
		l.getPassword().sendKeys(prop.getProperty("Employee1Password"));
		l.getLoginButton().click();
		reusableWaits.waitForSelectClubPage(10);
		return null;
	}

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static String selectClub()
	{
		SelectClubPO sc = new SelectClubPO(driver);
		Select s= new Select(sc.getClubDropdown());
		s.selectByVisibleText("Jonas Sports-Plex");
		sc.getSelectButton().click();
		reusableWaits.waitForDashboard(10);
		return null;
	}

	public static String getDateFormater() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String DateTime= dateFormat.format(date);
		return DateTime;
	}


}
