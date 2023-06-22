package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.beust.jcommander.internal.Console;

import utility.TimeUtils;

public class BaseClass {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	private static TimeUtils timeUtils;
	
	// Step 1: Initialize properties and timeUtils
	static {
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\User\\OneDrive\\Desktop\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
			prop.load(file);
			timeUtils = new TimeUtils();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}
	
	// Step 2: Initialize WebDriver and open URL
	public static void initiate() {
		int pageLoadTimeout = timeUtils.timeage;
		// Set driver path, maximize window, and set page load timeout
		String browsername = prop.getProperty("browser");
		
		
		if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("geckodriver.exe");
			driver = new FirefoxDriver(options);
			
			
			System.out.println("driver for firefox");
			System.out.println(driver);
		} else if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("driver for chrome");
			System.out.println(driver);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.get(prop.getProperty("url"));
		
	
	}
	
	public static void screenshots(String Filename) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\User\\OneDrive\\Desktop\\HRmanagement\\src\\main\\java\\screenShot\\ScreenShots" + Filename+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
