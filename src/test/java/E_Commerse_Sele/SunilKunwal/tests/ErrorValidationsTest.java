package E_Commerse_Sele.SunilKunwal.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import E_Commerse_Sele.pageobjects.CartPage;
import E_Commerse_Sele.pageobjects.CheckoutPage;
import E_Commerse_Sele.pageobjects.ConfirmationPage;
import E_Commerse_Sele.pageobjects.ProductCatalogue;
import SunilKunwal.TestComponents.BaseTest;
import SunilKunwal.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void LoginErrorValidations() throws IOException {

		landingPage.loginApplication("sunilkunwal11@gmail.com", "Kunwal1@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void ProductErrorValidations() throws IOException {
		{

			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("sunilkunwal1@gmail.comm", "Kunwal1@");
			List<WebElement> Products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
			Assert.assertFalse(match);

		}

	}
}
