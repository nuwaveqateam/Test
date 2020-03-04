package rediff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_UsingTestNG {
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void RediffInitialize() {
		WebDriverManager.firefoxdriver().setup();
	      driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.get("http://rediff.com");
		 
	}
	
	@Test
	public static void ValidatingLandingPageOfRediff() {
		System.out.println(driver.getTitle());  //give you the title of the page in the output console
		String LandingPageTitle = driver.getTitle();
		if(LandingPageTitle.equals("Rediff.com: News | Rediffmail | Stock Quotes | Shopping")) {
			System.out.println("This is a valid test case");
		}else {
			System.out.println("This is an invalid test case");
		}
	}
	
	@Test
	public static void LoginPageOfRediff() {
		driver.findElement(By.xpath("//a[@class = 'signin']")).click();
		String LoginPageTitle = driver.getTitle();
		if(LoginPageTitle.equals("Rediffmail")) {
			System.out.println("This is a valid test case");
		}else {
			System.out.println("this is an invalid test case");
		}
		
		boolean RediffLogo = driver.findElement(By.xpath("//div[@class = 'floatL']/descendant::img[1]")).isDisplayed();
		if(RediffLogo ==true ) {
			System.out.println("This is a valid test case");
		}else {
			System.out.println("this is not a valid test case");
		}
		
		boolean usernamefield = driver.findElement(By.xpath("//input[@id = 'login1']")).isEnabled();
		if(usernamefield == true) {
			System.out.println("this is a valid test case");
		}else {
			System.out.println("this is an invalid test case");
		}	
	}
	
	@Test(enabled = true)
      public static void checkingAlert(){
		
		//driver.findElement(By.xpath("//a[@class = 'signin']")).click();
		driver.findElement(By.xpath("//input[@id = 'login1']")).clear();
		driver.findElement(By.xpath("//input[@id = 'password']")).clear();
		
		boolean signinButton = driver.findElement(By.xpath("//input[@name = 'proceed']")).isEnabled();
		if(signinButton == true) {
			driver.findElement(By.xpath("//input[@name = 'proceed']")).click();
		} else {
			System.out.println("this button is not Enabled");
		}	
		Alert alert = driver.switchTo().alert();
		System.out.println("the text inside the alert is : " + alert.getText());
		alert.accept();
		
}
	
	@Test
	public static void RediffProfileName() throws Exception  {
		driver.findElement(By.xpath("//input[@id = 'login1']")).sendKeys("seleniumpanda@rediffmail.com");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Seleniumpanda@123");
		driver.findElement(By.xpath("//input[@name = 'proceed']")).click();
		System.out.println(driver.getTitle());
		System.out.println("CurrentURL of the Inbox page of Rediff is : " + driver.getCurrentUrl());
		
		String TitleofInboxpage = driver.getTitle();
		if(TitleofInboxpage.equals("Rediffmail")) {
			System.out.println(" this is a valid chutiyapa execution");
		}else {
			System.out.println("this is invalid chutiyapa execution");
		}
		
		String CurrentURLofInboxpage = driver.getCurrentUrl();
		System.out.println("the current URL of Inbox page is : " + driver.getCurrentUrl());
		if(CurrentURLofInboxpage.equals("https://mail.rediff.com/cgi-bin/login.cgi")) {
			System.out.println("this is a chodu valid execution");
		}else {
			System.out.println("this in chodu invalid execution");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.xpath("/div[@class='rd_header']/div/div[2]/a[2]"));
		driver.switchTo().frame("newTabTopFrame");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",ele);

		System.out.println("******************************************");

		
		
	
	System.out.println("after logout the title of the page is : " + driver.getTitle());
				
		 
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
