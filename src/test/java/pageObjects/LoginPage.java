package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement txteMailAddress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']")  WebElement btnlogin;
	
	public void setEmail(String email) {
		txteMailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnlogin.click();
	}
	
}
