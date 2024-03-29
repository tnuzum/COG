package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	public static WebDriver driver;
	public static Properties prop; //or, public static Properties prop = new Properties(); this was recommended to resolve an NPE, but I didn't need it
	public static Logger log =LogManager.getLogger(base.class.getName());
	static String projectPath = System.getProperty("user.dir");

	public WebDriver initializeDriver() throws IOException {
		
		DesiredCapabilities dcch = DesiredCapabilities.chrome();
		dcch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dcch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		prop = new Properties();
		FileInputStream fis=new FileInputStream(projectPath + "\\src\\main\\java\\resources\\properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String testEnvironment = prop.getProperty("test_environment");

		if (testEnvironment.equals("grid")){
			if (browserName.equals("Chrome")) {
				log.info("Chrome Browser: Running Tests on Selenium Grid");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName("chrome");
				dc.setPlatform(Platform.WINDOWS);
				System.setProperty("webdriver.chrome.driver", "c:\\WebDrivers\\chromedriver.exe");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);}
			if (browserName.equals("Firefox")) {
				log.info("Firefox Browser: Running Tests on Selenium Grid");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName("firefox");
				dc.setPlatform(Platform.WINDOWS);
				System.setProperty("webdriver.gecko.driver","c:\\WebDrivers\\geckodriver.exe");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);}
			if (browserName.equals("Edge")) {
				log.info("Edge Browser: Running Tests on Selenium Grid");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName("MicrosoftEdge");
				dc.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);}
		/*	if (browserName.equals("IE")) {
				log.info("IE Browser: Running Tests on Selenium Grid");
				DesiredCapabilities dc =
				DesiredCapabilities.internetExplorer();
				dc.setCapability("ignoreZoomSetting", true);
//				dc.setBrowserName("internetexplorer");
				dc.setPlatform(Platform.WINDOWS);
//				System.setProperty("webdriver.ie.driver","c:\\WebDrivers\\IEDriverServer.exe");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);}*/
		}
		else {
		if (testEnvironment.equals("local")){
			if (browserName.equals("Chrome")) {
				ChromeOptions co = new ChromeOptions();
				co.merge(dcch);
				System.setProperty("webdriver.chrome.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\chromedriver.exe");
				driver = new ChromeDriver(co);
			}
			if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			if (browserName.equals("Edge")) {
				System.setProperty("webdriver.edge.driver",
						projectPath + "\\src\\main\\java\\webDrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			if (browserName.equals("IE")) {
				InternetExplorerOptions options = new InternetExplorerOptions();
				System.setProperty("webdriver.ie.driver",projectPath + "\\src\\main\\java\\webdrivers\\IEDriverServer.exe");
				options.setCapability("ignoreZoomSetting", true);
				driver = new InternetExplorerDriver(options); 
				}
			}
		}
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");//or, DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
		Date date = new Date();
		String DateTime= dateFormat.format(date);
		System.out.println(DateTime+" INFO: WebDriver Initialized");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

/*	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(projectPath + "\\JonasFitness\\screenshots\\" + result + "screenshot.png"));
	}
*/
}


