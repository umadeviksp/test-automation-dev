package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMediaTabPage;
import com.net.bloomz.pages.interfaces.CreateMediaTabPageActions;
import com.net.bloomz.pages.web.WebCreateMediaTabPage;

public class MediaTabPage extends BasePage {

	static By photosMediaLocator;
	static By selectMediaLocator;

	public MediaTabPage(Browser<?> browser) {
		super(browser);
	}

	public static MediaTabPage getMediaTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			photosMediaLocator = By.id("net.bloomz:id/llMainView");
			return new AndroidMediaTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			photosMediaLocator = By.xpath("//*[@id='communityContent']/div/section/h1/span[1]");
			selectMediaLocator = By.xpath("//*[@id='communityContent']/div/section/h1/a");
			return new WebCreateMediaTabPage(browser);
		}
		return null;
	}

	public MediaTabPage thenVerifyElementExists() {
		Assert.assertTrue(getElementSize(selectMediaLocator) > 0, "Media Tab is not displayed");
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	
}
