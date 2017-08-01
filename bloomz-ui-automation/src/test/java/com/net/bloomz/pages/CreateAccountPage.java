package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidLandingPage;
import com.net.bloomz.pages.interfaces.CreateAccountPageActions;
import com.net.bloomz.pages.interfaces.LandingPageActions;
import com.net.bloomz.pages.web.WebCreateAccountPage;
import com.net.bloomz.pages.web.WebLandingPage;

public class CreateAccountPage extends BasePage implements CreateAccountPageActions {
	
	static By createNewClassGroupLocator;

	public CreateAccountPage(Browser<?> browser) {
		super(browser);
	}

	public static CreateAccountPage getCreateAccountPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return null; // TO DO FIX THIS
		} else if (string.equals(".iOS")) {
			
		} else {
			createNewClassGroupLocator = By.xpath("//*[@ng-click=\"launchCreateGroupClassScreen()\"]");
			
			return new WebCreateAccountPage(browser);
		}
		return null;
	}
	
	// need to fix this
	public Object clickOnCreateNewClassGroup() {
		click(createNewClassGroupLocator);
		return null; // need to fix this to GroupTypePage
//		return HomePage.getHomePage(browser);
	}

}