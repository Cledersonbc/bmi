package br.edu.bmi.objects;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.edu.bmi.WebDriverFactory;

public class HomePage {

	private HomePage() {

	}

	public HomePage calculateBMI(double weight, double height) {
		WebDriver driver = WebDriverFactory.getFirefoxDriver();

		driver.get("http://localhost:8080/home");

		driver.findElement(byWeightField()).clear();
		driver.findElement(byWeightField()).sendKeys(String.valueOf(weight));

		driver.findElement(byHeightField()).clear();
		driver.findElement(byHeightField()).sendKeys(String.valueOf(height));

		driver.findElement(byCalcButton()).click();

		return this;
	}

	public HomePage verifyBMIisEqualTo(BigDecimal expectedBMI) {
		WebDriver driver = WebDriverFactory.getFirefoxDriver();

		String bmi = driver.findElement(By.id("result")).getAttribute("value");

		BigDecimal result = new BigDecimal(bmi).setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(result, expectedBMI);

		return this;
	}
	
	public static By byWeightField() {
		return By.id("weight");
	}

	public static By byHeightField() {
		return By.id("height");
	}

	public static By byCalcButton() {
		return By.id("calc");
	}

	public static HomePage getHomePage() {
		return new HomePage();
	}

}
