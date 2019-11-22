package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectClubPO {

	public static WebDriver driver;

	// OBJECTS
	
		By pageHeader = By.xpath("//div[contains(@class, 'login-form')]/h3");
		By clubDropdown = By.id("ddl_clubSelection");
		By selectButton = By.id("submit");
		By clubRequiredMessage = By.xpath("//span[@for='ddl_clubSelection']");
		By topOfPageLogo = By.xpath("(//div[@class='logo'])[1]");
		By bottomOfPageLogo = By.xpath("(//div[@class='logo'])[2]");
		
		
		
	// CONSTRUCTOR
			
		public SelectClubPO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			SelectClubPO.driver = driver;
		}
	// METHODS

		public WebElement getPageHeader()
		{
			return driver.findElement(pageHeader);
		}
		public WebElement getClubDropdown()
		{
			return driver.findElement(clubDropdown);
		}
		public WebElement getSelectButton()
		{
			return driver.findElement(selectButton);
		}
		public WebElement getClubRequiredMessage()
		{
			return driver.findElement(clubRequiredMessage);
		}
				public WebElement getTopOfPageLogo()
		{
			return driver.findElement(topOfPageLogo);
		}
		public WebElement getBottomOfPageLogo()
		{
			return driver.findElement(bottomOfPageLogo);
		}
}
