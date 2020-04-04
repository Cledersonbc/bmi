package br.edu.example.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class IMCTest {

	@Test
	public void calcIMC() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login
		driver.get("http://localhost:8080/");

		driver.findElement(By.id("email"))
			.sendKeys("clederson@email.com.exemplo");

		driver.findElement(By.id("password"))
			.sendKeys("Senh4Do3mail");

		driver.findElement(By.id("submit")).submit();

		// Calc IMC
		float height = 1.65F;
		float weight = 56;
		float imcExpected = weight/(height * height);
		BigDecimal expected = new BigDecimal(imcExpected)
				.setScale(2, RoundingMode.HALF_EVEN);

		driver.findElement(By.id("weight")).clear();
		driver.findElement(By.id("weight")).sendKeys("56");

		driver.findElement(By.id("height")).clear();
		driver.findElement(By.id("height")).sendKeys("1.65");

		driver.findElement(By.id("calc"))
			.click();

		// Compare Result
		String imcResult = driver.findElement(By.id("result")).getAttribute("value");

		BigDecimal result = new BigDecimal(imcResult).setScale(2, RoundingMode.HALF_EVEN);
		driver.close();
		assertEquals(result, expected);

	}

}
