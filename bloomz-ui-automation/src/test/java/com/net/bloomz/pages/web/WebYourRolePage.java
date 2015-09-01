package com.net.bloomz.pages.web;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.SignUpPage;
import com.net.bloomz.pages.YourRolePage;
import com.net.bloomz.pages.interfaces.YourRolePageActions;

public class WebYourRolePage extends YourRolePage implements YourRolePageActions {

	By createNewClassButtonLocator = By.xpath("//*[contains(text(), 'Create new class')]");
	By cancelButtonLocator = By.xpath("//*[contains(text(), 'Cancel')]");

	public WebYourRolePage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignUpPage clickOnRoomParentIcon() {
		super.clickOnRoomParentIcon();
		click(createNewClassButtonLocator);
		return SignUpPage.getSignUpPage(browser);
	}

}
