package br.edu.bmi;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.edu.bmi.objects.HomePage;
import br.edu.bmi.objects.LoginPage;

public class BMITest extends BaseTestClass {

	LoginPage loginPage = LoginPage.getLoginPage();
	HomePage homePage = HomePage.getHomePage();

	@Test
	public void calcBMI() {
		String email = "clederson@email.com.example";
		String password = "P4ssword0f3mailExample";

		double height = 1.65;
		double weight = 56;
		BigDecimal expectedBMI = getExpectedBMI(weight, height);

		loginPage.login(email, password);

		homePage
			.calculateBMI(weight, height)
			.verifyBMIisEqualTo(expectedBMI);

	}

	private BigDecimal getExpectedBMI(double weight, double height) {
		double bmi = weight / (height * height);

		return new BigDecimal(bmi).setScale(2, RoundingMode.HALF_EVEN);
	}

}
