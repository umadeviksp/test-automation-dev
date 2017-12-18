package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.SchoolLocationPage;

public class AndroidSchoolLocationPage extends SchoolLocationPage  {

	By	schoolSearchTextGrayedLocator = By.id("net.bloomz:id/txtSearch");
	By	schoolSearchEditTextLocator = By.id("net.bloomz:id/edtSearch");

	
	public AndroidSchoolLocationPage(Browser<?> browser) {
		super(browser);
	}

	public SchoolLocationPage enterSchoolSearch(String schoolName) {

		click(schoolSearchTextGrayedLocator) ;
		sendText(schoolSearchEditTextLocator, schoolName);
		return this;
	}
	
	
}
