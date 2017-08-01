package com.bloomz.pages.settings;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;

import com.bloomz.pages.BasePage;
import com.bloomz.pages.ClassPage;

public class UserProfileFlyOutMenu extends BasePage {

	By settingButtonLocator = By.id("net.bloomz:id/txtSetting");
	By profileNameLocator = By.id("net.bloomz:id/txtProfileName");
	By homeButtonLocator = By.id("net.bloomz:id/caption");
	By classLocator = By.id("net.bloomz:id/txtTitle");

	public UserProfileFlyOutMenu(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}

	public AccountSettings goToAccountSettings() {
		waitForElement(settingButtonLocator);
		click(settingButtonLocator);
		return new AccountSettings(appiumDriver);

	}

	public String getUserProfileName() {
		// System.out.println(getText(profileNameLocator));
		return getText(profileNameLocator);
	}

	public ClassPage navigateToClassRoom() {
		waitForElement(classLocator);
		click(classLocator);
		return new ClassPage(appiumDriver);

	}
}
