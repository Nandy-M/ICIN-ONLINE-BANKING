package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserLoginTest {
	public String baseUrl = "http://localhost:4200/login";

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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[1]/input")).sendKeys("Nandhini");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/input")).sendKeys("Nandy*16");
		// Login Button
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualUrl = "http://localhost:4200/home";
		String expectedUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login Successful");
		}
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void transactionHistory() throws InterruptedException {

		// Double click the button to launch an alertbox
		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[1]/a"));
		action.doubleClick(link).perform();
		Thread.sleep(8000);
		System.out.println("transactionHistory displayed");

	}

	@Test(priority = 2)
	public void transferHistory() throws InterruptedException {

		// Transfer history nav link
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		System.out.println("transferHistory displayed");

	}

	@Test(priority = 3)
	public void transferMoney() throws InterruptedException {

		// Transfer Money nav link
		driver.findElement(By.xpath("//*[@id=\"navbarsExample04\"]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-transfer-between-accounts/div/form/div[3]/input"))
				.sendKeys("ICIN7465");
		driver.findElement(By.xpath("/html/body/app-root/app-transfer-between-accounts/div/form/div[4]/input"))
				.sendKeys("39149182014");
		driver.findElement(By.xpath("/html/body/app-root/app-transfer-between-accounts/div/form/div[5]/input"))
				.sendKeys("5000");
		driver.findElement(By.xpath("/html/body/app-root/app-transfer-between-accounts/div/form/div[6]/button"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div/div/div[3]")).click();

		System.out.println("transferMoney Successfully");

	}

	@Test(priority = 4)
	public void requestChequebook() throws InterruptedException {

		// nav link
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[4]/a\n")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-cheque-book-request/div/div[2]/select")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-cheque-book-request/div/div[2]/select/option[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-cheque-book-request/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]")).click();

		System.out.println("Cheque Book Issued Successfully!!");
		Thread.sleep(5000);
		System.out.println("Chequebook requested");

	}

	@Test(priority = 5)
	public void deposit() throws InterruptedException {

		// Deposit nav link
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[5]/a\n")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-deposit/div/form/div[3]/input")).sendKeys("7000");
		driver.findElement(By.xpath("/html/body/app-root/app-deposit/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]\n")).click();

		System.out.println("Deposit Successfully");
		Thread.sleep(300);
	}

	@Test(priority = 6)
	public void WithDraw() throws InterruptedException {

		// Deposit nav link
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[6]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-withdraw/div/form/div[3]/input")).sendKeys("2000");
		driver.findElement(By.xpath("/html/body/app-root/app-withdraw/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[3]/button[1]")).click();

		System.out.println("Withdraw Successfully");
		Thread.sleep(300);
	}

	@Test(priority = 7)
	public void loanApply() throws InterruptedException {

		// Deposit nav link
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[7]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-apply-loan/div/form/div[3]/input")).sendKeys("House Loan");
		driver.findElement(By.xpath("/html/body/app-root/app-apply-loan/div/form/div[4]/input")).sendKeys("100000");

		System.out.println("Loan applied Successfully");
		Thread.sleep(300);
	}

	@Test(priority = 7)
	public void logOut() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"dropdown04\"]")).click();
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[8]/div/a[1]")).click();

		driver.findElement(By.xpath("/html/body/app-root/app-edit-profile/div[1]/form/div/div[1]/input"))
				.sendKeys("7666854389");
		driver.findElement(By.xpath("/html/body/app-root/app-edit-profile/div[1]/form/div/div[2]/input"))
				.sendKeys("Mumbai");
		driver.findElement(By.xpath("/html/body/app-root/app-edit-profile/div[1]/form/div/div[2]/div[1]/input"))
				.sendKeys("nandhini@gmail.com");
		driver.findElement(By.xpath("/html/body/app-root/app-edit-profile/div[1]/form/div/div[2]/div[2]/input"))
				.sendKeys("Nandy*16");
		driver.findElement(By.xpath("/html/body/app-root/app-edit-profile/div[1]/form/div/div[2]/div[3]/input"))
				.sendKeys("Nandy*16");
		System.out.println("Profile edited");
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"dropdown04\"]")).click();
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[8]/div/a[2]")).click();
		System.out.println("Signed Out");
	}
}
