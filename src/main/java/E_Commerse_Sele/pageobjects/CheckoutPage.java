package E_Commerse_Sele.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SunilKunwal.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	Actions action;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.action = new Actions(driver); // Initialize Actions instance once
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selecctcountry;

	By results = By.cssSelector(".ta-results");

	public void selecctcountry(String countryName) {
		action.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selecctcountry.click();
	}

	public ConfirmationPage submitOrder() {
		action.moveToElement(submit).click().build().perform();
		return new ConfirmationPage(driver);
	}

}
