package testLayer;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseClass {
	PomLogin Log;

	public LoginTest() {
		
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		try {
			initiate();	
			screenshots("Login");
			Log=new PomLogin(driver);
		}
		
		catch (Exception e) {
			System.out.println("Exception Initsetup");
			System.out.println(e);
		}
	}
	
	@Test(priority = 1)
	public void Title() {
	String actual =	Log.verify();
	System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
		
	}
	
	@DataProvider      //Data provider will read the data from excel sheet
	public Object[][] Details(){
		Object result[][] = ExcelSheet.readData("Sheet1");
		return result;
	}
	
	@Test(priority = 2, dataProvider="Details")
	public void login(String name, String password) throws Exception   {
		try {
		//Log.typeusername("Admin");
		//Log.typepassword("admin123");
		//Thread.sleep(15);
		Log.typeusername(name);
		Thread.sleep(2);
		Log.typepassword(password);
		Thread.sleep(2);
		//Log.clickbtn();
	}
		catch (NoSuchElementException e) {
			System.out.println("Exception of No such Element exception");
		System.out.println(e);
	}
	}
//	@AfterMethod
//	public void close() {
//	driver.close();
//	}
}
