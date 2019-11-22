package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;


public class reusableWaits extends base{
	
		public static String waitForLoginPage() throws InterruptedException
	{
			// Check 1: wait for member name element
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UserName")));
//		System.out.println(DateTime+" INFO: Element is now present");
			// Check 2: wait for member name element to not be blank	
//		DashboardPO d = new DashboardPO(driver);
//		WebElement wait = d.getMyFamilyMemberCount();
//		while (wait.getText().isBlank())
//		{
////			System.out.println(DateTime+" INFO: Waiting 500ms for Family Member Count element to populate");
//			Thread.sleep(500);
//			wait.getText();
//		}
		return null;
		
	}


}
	
