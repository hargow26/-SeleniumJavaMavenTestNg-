package SeleniumFramework.SeleniumPOM;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumPOM.PageObjects.LandingPage;
import SeleniumFramework.SeleniumPOM.PageObjects.LoginPage;

public class HomePageTestCases extends TestBase{
	
	@Test
	public void pincode() throws IOException, InterruptedException {
		driver=initialization();
		
		driver.get("https://ebooks.com/");
		
		LandingPage landingPage=new LandingPage(driver);
		
		ExpectedConditions.elementToBeClickable(landingPage.getLogin());
		
		//Explicit wait while using page factory model
		//https://stackoverflow.com/a/54177337/17003989
		
		WebElement element = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(landingPage.getLogin()));
		
		landingPage.getLogin().click();
		
//		Thread.sleep(5000);
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.getUsername().sendKeys("harishgowdas2607@gmail.com");
		
		loginPage.getContinueBtn().click();
		
		loginPage.getPassword().sendKeys("PracticeDaily10");
		
		loginPage.getSignIn().click();
		
	}

}
