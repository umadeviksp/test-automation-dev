package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateAnnouncementInClassPage;
import com.net.bloomz.pages.interfaces.CreateAnnouncementInClassPageActions;
import com.net.bloomz.pages.web.WebCreateAnnouncementInClassPage;

public class CreateAnnouncementInClassPage extends BasePage implements CreateAnnouncementInClassPageActions {
	
	static By titleFieldLocator;
	static By generalUpdateFieldLocator;
	static By postButtonLocator;

	public CreateAnnouncementInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateAnnouncementInClassPage enterTitle(String title) {
		sendText(titleFieldLocator, title);
		return CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser);
	}
	
	public CreateAnnouncementInClassPage enterGeneralUpdate(String updateText) {
		sendText(generalUpdateFieldLocator, updateText);
		return CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser);
	}

	public HomePage clickOnPostButton() {
		click(postButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public static CreateAnnouncementInClassPage getCreateAnnouncementInClassPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			titleFieldLocator = By.id("net.bloomz:id/edittitle");
			generalUpdateFieldLocator = By.id("net.bloomz:id/editdiscreption");
			postButtonLocator = By.id("net.bloomz:id/btnDone");
			return new AndroidCreateAnnouncementInClassPage(browser);
			
		} else if (string.equals(".iOS")) {
			
		} else {
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.id("addPost_postData");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			return new WebCreateAnnouncementInClassPage(browser);
		}
		return null;
	}

}
