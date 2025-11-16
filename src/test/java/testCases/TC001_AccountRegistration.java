package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		logger.info(" **** TC001_AccountRegistration **** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage ag = new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		ag.setFirstName(randomString().toUpperCase());
		ag.setLastName(randomString().toUpperCase());
		ag.email(randomString()+"@gmail.com");
		ag.setTelephone(randomNumber());
		String password = randomAlphaNumeric();
		ag.setPassword(password);
		ag.setConfirmPassword(password);
		ag.setPrivacyPolicy();
		ag.clickContinue();
		logger.info("Validating Expected Message.....");
		String confirmationMessage = ag.getConfirmationMsg();
		if(confirmationMessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		} else {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confirmationMessage,"Your Account Has Been Created!");
		} catch (Exception e)
		{
			Assert.fail();   
		}
		logger.info(" **** CompletedTC001_AccountRegistration **** ");
	}
}
