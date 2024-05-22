package E_Commerse_Sele.SunilKunwal.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SunilKunwal.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		{
			
			landingPage.loginApplication("sunilkunwal11@gmail.com", "Kunwal1@123");
			Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		}

	}
}
