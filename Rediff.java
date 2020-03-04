package rediff;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff {

	static WebDriver driver;
	//@BeforeTest
	@BeforeTest
	public static void Initilization() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies(); //
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Test
	public static void LandingPage() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		// Rediff.com: News | Rediffmail | Stock Quotes | Shopping

		if (pageTitle.equals("Rediff.com: News | Rediffmail | Stock Quotes | Shopping")) {
			System.out.println("Landing test Case is PASS");

		} else {
			System.out.println("lanidng test case is FAIL");
		}
	}

	@Test
	public static void LoginPage() {
		driver.findElement(By.xpath("//a[@class='signin']")).click();
		String loginPageTitle = driver.getTitle();
		System.out.println("Login Page Title: " + loginPageTitle);
		// Rediffmail

		if (loginPageTitle.equals("Rediffmail")) {
			System.out.println("Login Page test Case is PASS");
		} else {
			System.out.println("Landing test Case is Fail");
		}
		
		/*
		 * driver.findElement(By.
		 * xpath("//div[@class='login-form']/descendant::input[@id='login1' and @name='login']"
		 * )).sendKeys("seleniumpanda@rediffmail.com");
		 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(
		 * "Seleniumpanda@123");
		 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);
		 * // driver.findElement(By.xpath("//input[@name='proceed']")).click();
		 */	}
	
	@Test
	public static void LoginPageSequence() {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//div[@class='login-form']/descendant::input[@id='login1' and @name='login']")).sendKeys("seleniumpanda@rediffmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Seleniumpanda@123");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);
	}
	

	
	@AfterTest
	public static void tearDown() {
		driver.close();
	}

}
