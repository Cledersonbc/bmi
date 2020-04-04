package br.edu.bmi.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.edu.bmi.WebDriverFactory;

public class LoginPage {

	private LoginPage() {

	}

	public void login(String email, String password) {
		WebDriver driver = WebDriverFactory.getFirefoxDriver();

		driver.get("http://localhost:8080/");

		driver.findElement(byEmailField()).sendKeys(email);

		driver.findElement(byPasswordField()).sendKeys(password);

		driver.findElement(bySubmitButton()).submit();

	}

	public static By byEmailField() {
		return By.id("email");
	}

	public static By byPasswordField() {
		return By.id("password");
	}

	public static By bySubmitButton() {
		return By.id("submit");
	}

	public static LoginPage getLoginPage() {
		return new LoginPage();
	}

}
