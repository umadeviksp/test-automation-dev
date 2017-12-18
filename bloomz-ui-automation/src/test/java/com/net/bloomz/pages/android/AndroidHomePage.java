package com.net.bloomz.pages.android;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateMessagePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.interfaces.HomePageActions;

public class AndroidHomePage extends HomePage implements HomePageActions {

	By bloomzIconLocator 		= By.id("net.bloomz:id/menuBtn");
	By profileNameTextLocator 	= By.id("net.bloomz:id/txtProfileSheetUserName") ;
	By messageTrayLocator 		= By.id ("net.bloomz:id/imgChatTray");

	public AndroidHomePage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public HomePage clickOnBloomzIconForMobileApp() {
//		waitForElement(bloomzIconLocator);
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
	public HomePage ScrollDownHomeFeed() throws InterruptedException {
		scrollIntoView();
		return this ;
	}
	public HomePage thenVerifyThatPostWasSuccessful(String sText) {
		//unable to verify toast message
		return HomePage.getHomePage(browser);
	}
	public HomePage thenVerifyCreateButtonShouldBeDisplayed() {
		//Not required, since create button is unclickable without email verification.
		return HomePage.getHomePage(browser);
	}
	public HomePage thenVerifyProfileName(String sText) {
		SettingPage localSettingPage = clickOnSettingButton() ;
		logger.info(getText(profileNameTextLocator));
		Assert.assertEquals(getText(profileNameTextLocator),sText);
		localSettingPage.clickOnAccountSettingsButton().clickOnGoBackButton() ;
		return HomePage.getHomePage(browser);
	}
	public CreateMessagePage clickOnMyMessageButton() {
		click(messageTrayLocator) ;
		return super.clickOnMyMessageButton() ;
	}


}
