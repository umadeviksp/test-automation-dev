package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.jivesoftware.selenium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.interfaces.HomePageActions;

public class AndroidHomePage extends HomePage implements HomePageActions {

	By bloomzIconLocator = By.id("net.bloomz:id/menuBtn");

	public AndroidHomePage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public HomePage clickOnBloomzIconForMobileApp() {
		waitForElement(bloomzIconLocator);
		click(bloomzIconLocator);
		return this;
	}
	@Override
	public ClassPage clickOnAClassName() {
		this.clickOnBloomzIconForMobileApp();
		return super.clickOnAClassName();
	}

	@Override
	public SettingPage clickOnSettingButton() {
		this.clickOnBloomzIconForMobileApp();
		return super.clickOnSettingButton();
	}

}
