package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ClassPageActions;
import com.net.bloomz.pages.web.WebClassPage;

public class ClassPage extends BasePage implements ClassPageActions {
	
	static By mediaTabLocator;
	static By updatesTabLocator;
	static By createButtonLocator;
	static By postButtonLocator;
	static By announcementButtonLocator;

	public ClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public ClassPage clickOnMediaTab() {
		click(mediaTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnUpdatesTab() {
		click(updatesTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreatePostInClassPage createNewPost() {
		clickOnCreateButton();
		click(postButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreateAnnouncementInClassPage createNewAnnouncement() {
		clickOnCreateButton();
		click(announcementButtonLocator);
		return CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser);	
	}
	
	public ClassPage clickOnCreateButton() {
		click(createButtonLocator);
		return ClassPage.getClassPage(browser);
	}	

	public static ClassPage getClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			updatesTabLocator = By.xpath("//*[@id=\"communityMenu_home\"]/a");
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			postButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[2]/div");
			announcementButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[6]");
			return new WebClassPage(browser);
		}
		return null;
	}

}