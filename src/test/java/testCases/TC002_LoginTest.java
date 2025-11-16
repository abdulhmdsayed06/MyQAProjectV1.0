package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_account_registration() {
		
		logger.info(" **** TC002_LoginPage **** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing Login Details");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isAccountPageDisplayed();
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info(" **** TC002_LoginPage Completed **** ");
	}
}
