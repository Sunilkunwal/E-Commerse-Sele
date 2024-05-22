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

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		{

			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("sunilkunwal@gmail.com", "Kunwal@123");
			List<WebElement> Products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToheckout();
			checkoutPage.selecctcountry("india");
			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmMessage = confirmationPage.getConfirmMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

	}
}
