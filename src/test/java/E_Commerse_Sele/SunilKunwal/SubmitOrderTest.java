package E_Commerse_Sele.SunilKunwal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import E_Commerse_Sele.pageobjects.CartPage;
import E_Commerse_Sele.pageobjects.CheckoutPage;
import E_Commerse_Sele.pageobjects.ConfirmationPage;
import E_Commerse_Sele.pageobjects.LandingPage;
import E_Commerse_Sele.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrderTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		String productName ="ZARA COAT 3";

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("sunilkunwal@gmail.com", "Kunwal@123");
		List<WebElement>Products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
	
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToheckout();
		checkoutPage.selecctcountry("ind");
		ConfirmationPage confirmationPage =checkoutPage.submitOrder();

		String confirmMessage = confirmationPage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
//		
		

	}

}
