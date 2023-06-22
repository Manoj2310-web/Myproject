package pompackage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePackage.BaseClass;

public class PomLogin extends BaseClass {

	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOf(Username));
	
	//object repository
	
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")   //driver.findElement(By.
		WebElement Username;
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
		WebElement Password;
		@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
		WebElement Login;
	
	

	
	//initiate page elements
	public PomLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);   //initElement is static method which is used to initialize all elements.
	//super();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(Username));
	}
	
//	private void waitForElementVisibility(WebElement element) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(element.findElement((By.name("Username")) )));
//	}
	
	public void typeusername(String name) throws InterruptedException {
		
		Username.sendKeys(name);
		Thread.sleep(3000);
	}
	
	public void typepassword(String password) {
		Password.sendKeys(password);
	}
	
	public void clickbtn() {
		Login.click();
	}
	public String verify() {
		return driver.getTitle();
	}
}
