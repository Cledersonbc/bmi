package br.edu.bmi;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver driver;

	private WebDriverFactory() {

	}

	public static WebDriver getFirefoxDriver() {
		if (Objects.isNull(driver)) {
			driver = new FirefoxDriver();
		}

		return driver;
	}

}
