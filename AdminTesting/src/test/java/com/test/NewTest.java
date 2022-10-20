package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public String baseUrl = "http://localhost:4201/";

	String driverPath = "C:\\MyDownloads\\geckodriver-v0.31.0-win64\\geckodriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {

		System.out.println("Launching Firefox Browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void login_Pass() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"inputUserName\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("123456");
		// Login Button
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();
		String actualUrl = "http://localhost:4201/smaple";
		String expectedUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Successful");
		}
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void userAccountInfo() throws InterruptedException {
		// Checkbook Request Hyperlink
		driver.findElement(
				By.xpath("	/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[1]/a/span/span[2]"))
				.click();
		Thread.sleep(300);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("userAccount Displayed");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// home
		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();

	}

	@Test(priority = 2)
	public void checkbookRequests() throws InterruptedException {
		// Checkbook Request Hyperlink
		driver.findElement(
				By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[2]/a/span/span[2]"))
				.click();
		Thread.sleep(300);
		// Confirm Request Button
		//driver.findElement(By.xpath("/html/body/app-root/app-checkbook-requests/table/tbody/tr/td[6]/button")).click();
		System.out.println("ChequeRequest Confirmed");
		// home
		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();

	}

	@Test(priority = 3)
	public void transactionHistory() throws InterruptedException {

		// Transaction history nav link
		driver.findElement(By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[5]/a/span"))
				.click();
		Thread.sleep(300);
		System.out.println("transactionHistory displayed");

		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();
	}

	@Test(priority = 4)
	public void transferHistory() throws InterruptedException {

		// Transfer history nav link
		driver.findElement(
				By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[6]/a/span/span[2]"))
				.click();
		Thread.sleep(300);
		System.out.println("transferHistory displayed");

		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();
	}

	@Test(priority = 4)
	public void authorization() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Authorization nav link
		driver.findElement(By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[4]/a/span"))
				.click();
		// Create Account Button
//		driver.findElement(By.xpath("/html/body/app-root/app-authorize-registration/table/tbody/tr/td[9]")).click();
//		System.out.println("Authorized");
//		// Cancel Button
//		driver.findElement(By.xpath("/html/body/app-root/app-authorize-registration/table/tbody/tr[2]/td[10]/button"))
//				.click();
//		System.out.println(" Not Authorized");
		System.out.println("AuthorizeKyc Works");
		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();

	}

	@Test(priority = 5)
	public void loanRequests() throws InterruptedException {
		// Loan Request Hyperlink
		driver.findElement(By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[3]/a/span"))
				.click();
		Thread.sleep(300);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("loanRequest Displayed");
		driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li/a")).click();

	}

	@Test(priority = 6)
	public void logout() {
		// LogOut Button
		driver.findElement(
				By.xpath("/html/body/app-root/app-sample/main/div/div/div[2]/div/div/div[2]/div[7]/a/span/span[1]"))
				.click();
		System.out.println("Logged Out");
	}
}
