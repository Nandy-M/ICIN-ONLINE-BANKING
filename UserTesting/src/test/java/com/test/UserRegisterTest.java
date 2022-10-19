package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserRegisterTest {
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

	@Test(priority = 1)
	public void userRegister() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[3]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[1]/input")).sendKeys("Monika");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[2]/input")).sendKeys("R");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[3]/input")).sendKeys("Moni");
		
		
		
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[4]/input")).sendKeys("123456p");
//		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[5]/input"))
//				.sendKeys("17/08/2002");
		WebElement selectDate = driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[4]/input"));
		selectDate.click();
	
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[6]/input"))
				.sendKeys("7666854389");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[7]/input")).sendKeys("Mumbai");
		Select id = new Select(
				driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[8]/select")));
		id.selectByIndex(2);
		WebElement fileInput = driver
				.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[9]/input"));
		fileInput.sendKeys("D:\\pan.jpg");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[10]/input"))
				.sendKeys("abcde1234");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[11]/input"))
				.sendKeys("moni@gmail,com");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/form/div/div[12]/button")).click();
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-login/div/form/h3")));
		System.out.println("Registration Successfull");
	}

}
