package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ClassPageActions;
import com.net.bloomz.pages.web.WebClassPage;

public class ClassPage extends BasePage implements ClassPageActions {
	
	static By mediaTabLocator;

	public ClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public ClassPage clickOnMediaTab() {
		click(mediaTabLocator);
		return ClassPage.getClassPage(browser);
	}

	public static ClassPage getClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			return new WebClassPage(browser);
		}
		return null;
	}

}
