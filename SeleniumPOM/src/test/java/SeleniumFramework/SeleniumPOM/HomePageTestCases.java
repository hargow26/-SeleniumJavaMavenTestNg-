package SeleniumFramework.SeleniumPOM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumPOM.PageObjects.LandingPage;
import SeleniumFramework.SeleniumPOM.PageObjects.LandingPageComponent;
import SeleniumFramework.SeleniumPOM.PageObjects.LoginPage;

public class HomePageTestCases extends TestBase {

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws IOException, InterruptedException {
		driver = initialization();

		driver.get("https://ebooks.com/");

		LandingPageComponent landingPageComp = new LandingPageComponent(driver);

		// Explicit wait while using page factory model
		// https://stackoverflow.com/a/54177337/17003989

		WebDriverWait eWait = new WebDriverWait(driver, 10);
		eWait.until(ExpectedConditions.elementToBeClickable(landingPageComp.getLogin()));

		landingPageComp.getLogin().click();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.getUsername().sendKeys(username);

		Thread.sleep(1000);

//		Actions actions=new Actions(driver);
//		
//		actions.sendKeys(Keys.ENTER).build().perform();

		loginPage.getContinueBtn().click();

		loginPage.getPassword().sendKeys(password);

		loginPage.getSignIn().click();

		landingPageComp.getBrowse().click();

		landingPageComp.getFeedback().click();

		eWait.until(ExpectedConditions.elementToBeClickable(landingPageComp.getProfile()));

		landingPageComp.getProfile().click();

		landingPageComp.getLogout().click();

		driver.quit();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "DummyAccount@gmail.com";
		obj[0][1] = "Test@123";
		obj[1][0] = "2ndDummyAccount@gmail.com";
		obj[1][1] = "Test@123";

		return obj;

	}

}
