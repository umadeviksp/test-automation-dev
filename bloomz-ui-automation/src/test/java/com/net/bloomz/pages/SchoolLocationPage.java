package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.SchoolLocationPageActions;
import com.net.bloomz.pages.web.WebSchoolLocationPage;

public class SchoolLocationPage extends BasePage implements SchoolLocationPageActions {
	
	static By schoolLocator;
	static By schoolSearchEditTextLocator;

	public SchoolLocationPage(Browser<?> browser) {
		super(browser);
	}

	public static SchoolLocationPage getSchoolLocationPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			schoolLocator = By.xpath("//*[@id=\"activityTypes\"]/div/div/form/section/div/section/section[1]/span[1]");
			schoolSearchEditTextLocator = By.xpath("//*[@id=\"pickLocationId\"]");
			return new WebSchoolLocationPage(browser);
		}
		return null;
	}
	
	public CreateClassPage clickOnSchoolLocator() {
		click(schoolLocator);
		return CreateClassPage.getCreateClassPage(browser);
	}
	
	public SchoolLocationPage enterSchoolSearch(String schoolName) {
		sendText(schoolSearchEditTextLocator, schoolName);
		return this;
	}

}
