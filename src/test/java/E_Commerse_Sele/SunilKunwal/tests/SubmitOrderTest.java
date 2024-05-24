package E_Commerse_Sele.SunilKunwal.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import E_Commerse_Sele.pageobjects.CartPage;
import E_Commerse_Sele.pageobjects.CheckoutPage;
import E_Commerse_Sele.pageobjects.ConfirmationPage;
import E_Commerse_Sele.pageobjects.OrderPage;
import E_Commerse_Sele.pageobjects.ProductCatalogue;
import SunilKunwal.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		{

			ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
			List<WebElement> Products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(input.get("product"));
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.goToheckout();
			checkoutPage.selecctcountry("india");
			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmMessage = confirmationPage.getConfirmMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		}

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("sunilkunwal@gmail.com", "Kunwal@123");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(ordersPage.VerifyProductDisplay(productName));
	}

//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] { { "sunilkunwal@gmail.com", "Kunwal@123", "ZARA COAT 3" },
//				{ "sunilkunwal@gmail.com", "Kunwal@123", "ADIDAS ORIGINAL" } };
//	}
	
	@DataProvider
	public Object[] [] getData()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "sunilkunwal@gmail.com");
		map.put("password", "Kunwal@123");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "sunilkunwal1@gmail.comm");
		map1.put("password", "Kunwal1@");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[] [] {{map},{map1}};
	}
}
