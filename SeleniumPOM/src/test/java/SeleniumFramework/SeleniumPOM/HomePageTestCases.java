package SeleniumFramework.SeleniumPOM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import SeleniumFramework.SeleniumPOM.TestBase;
import SeleniumFramework.SeleniumPOM.PageObjects.LandingPage;
import SeleniumFramework.SeleniumPOM.PageObjects.LandingPageComponent;
import SeleniumFramework.SeleniumPOM.PageObjects.LoginPage;

public class HomePageTestCases extends TestBase {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		this.driver = initialization();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigating to home page");
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String title = driver.getTitle();

		log.info("Validating the title of the page");
		softAssert.assertTrue(title.contains("eBooks.com"));

		LandingPageComponent landingPageComp = new LandingPageComponent(driver);

		// Explicit wait while using page factory model
		// https://stackoverflow.com/a/54177337/17003989

		WebDriverWait eWait = new WebDriverWait(driver, 10);

		eWait.until(ExpectedConditions.elementToBeClickable(landingPageComp.getLogin()));

		landingPageComp.getLogin().click();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.getUsername().sendKeys(username);

		Thread.sleep(2000);

		eWait.until(ExpectedConditions.elementToBeClickable(loginPage.getContinueBtn()));

		loginPage.getContinueBtn().click();

		loginPage.getPassword().sendKeys(password);

		loginPage.getSignIn().click();

		eWait.until(ExpectedConditions.elementToBeClickable(landingPageComp.getProfile()));

		Assert.assertEquals(landingPageComp.getProfile().getText(), username, "User  has successfully logged in");

		landingPageComp.getProfile().click();

		landingPageComp.getLogout().click();

		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {
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
