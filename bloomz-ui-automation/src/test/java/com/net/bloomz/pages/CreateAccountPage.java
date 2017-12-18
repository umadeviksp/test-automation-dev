package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateAccountPage;
import com.net.bloomz.pages.android.AndroidLandingPage;
import com.net.bloomz.pages.interfaces.CreateAccountPageActions;
import com.net.bloomz.pages.interfaces.LandingPageActions;
import com.net.bloomz.pages.web.WebCreateAccountPage;
import com.net.bloomz.pages.web.WebLandingPage;

public class CreateAccountPage extends BasePage implements CreateAccountPageActions {
	
	static By createNewClassGroupLocator;
	static By JoinAClassGroupLocator;

	public CreateAccountPage(Browser<?> browser) {
		super(browser);
	}
	
	public GroupPage clickOnCreateNewClassGroup() {
		click(createNewClassGroupLocator);
		return GroupPage.getGroupPage(browser); 
	}
	
	public InvitePage clickOnJoinAClassGroup() {
		click(JoinAClassGroupLocator);
		return InvitePage.getInvitePage(browser); 
	}

	public static CreateAccountPage getCreateAccountPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			createNewClassGroupLocator 	= By.id("net.bloomz:id/llJoinNew");
			JoinAClassGroupLocator 		= By.id("net.bloomz:id/llJoinExisting");			
			return new AndroidCreateAccountPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			createNewClassGroupLocator = By.xpath("//*[@ng-click=\"launchCreateGroupClassScreen()\"]");
			JoinAClassGroupLocator = By.xpath("//*[@ng-click=\"launchInviteCodeScreen()\"]");
			
			return new WebCreateAccountPage(browser);
		}
		return null;
	}
	

}
