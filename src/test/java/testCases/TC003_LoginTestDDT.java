package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class , groups="Datadriven")
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info(" **** TC002_LoginTestDDT **** ");
		try {	
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickLogin();
		logger.info("Clicked on Login Link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing Login Details");
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isAccountPageDisplayed();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				ap.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				ap.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true );
			}
		}
		}  catch (Exception e) {
			Assert.fail();
		}
		
		logger.info(" **** TC002_LoginTestDDT Completed **** ");
	}
}
