package br.edu.bmi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
	protected WebDriver driver;

	@BeforeSuite
	public void setupBrowser() {
		driver = WebDriverFactory.getFirefoxDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
