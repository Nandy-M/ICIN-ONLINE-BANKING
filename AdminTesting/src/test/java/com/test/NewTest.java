package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public String baseUrl = "http://localhost:4201";

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
		String actualUrl = "http://localhost:4200/user-account";
		String expectedUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Successful");
		}
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void checkbookRequests() {
		// Checkbook Request Hyperlink
		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[2]/a")).click();
		// Confirm Request Button
		driver.findElement(By.xpath("/html/body/app-root/app-checkbook-requests/table/tbody/tr/td[6]/button")).click();
		System.out.println("ChequeRequest Confirmed");

	}

	@Test(priority = 5)
	public void loanRequests() throws InterruptedException {
		// Checkbook Request Hyperlink
		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[3]/a")).click();
		// Confirm Request Button
		driver.findElement(By.xpath("//*[@id=\"update\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();

		// switch focus to alert
		Alert a = driver.switchTo().alert();
		// get alert text
		String s = driver.switchTo().alert().getText();
		System.out.println("Alert text is: " + s);

		Thread.sleep(300);
		// accepting alert
		a.accept();
		System.out.println("loanRequest Confirmed");

	}

	@Test(priority = 4)
	public void authorization() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Authorization link
		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[4]/a")).click();
		// Create Account Button
		driver.findElement(By.xpath("/html/body/app-root/app-authorize-registration/table/tbody/tr/td[9]")).click();
		System.out.println("Authorized");
//	Cancel Button
//		driver.findElement(By.xpath("/html/body/app-root/app-authorize-registration/table/tbody/tr[2]/td[10]/button"))
//				.click();
//		System.out.println(" Not Authorized");

	}

	@Test(priority = 2)
	public void transactionHistory() throws InterruptedException {

		// Transaction history nav link
		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[5]/a")).click();
		System.out.println("transactionHistory displayed");
		Thread.sleep(300);
	}

	@Test(priority = 3)
	public void transferHistory() throws InterruptedException {

		// Transfer history nav link
		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[6]/a")).click();
		System.out.println("transferHistory displayed");
		Thread.sleep(300);
	}

//	@Test(priority = 6)
//	public void logout() {
//		// LogOut Button
//		driver.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/div/li/a")).click();
//		System.out.println("Logged Out");
//	}
}

