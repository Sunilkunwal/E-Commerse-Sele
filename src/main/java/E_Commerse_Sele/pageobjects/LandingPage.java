package E_Commerse_Sele.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SunilKunwal.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		//Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement PasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		PasswordEle.sendKeys(password);
		submit.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
