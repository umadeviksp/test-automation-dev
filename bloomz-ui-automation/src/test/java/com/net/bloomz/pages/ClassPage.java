package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ClassPageActions;
import com.net.bloomz.pages.web.WebClassPage;

public class ClassPage extends BasePage implements ClassPageActions {
	
	static By createButtonLocator;
	static By eventButtonLocator;
	static By volunteerTabLocator;
	static By mediaTabLocator;
	static By updatesTabLocator;
	static By createPostButtonLocator;
	static By createAnnouncementButtonLocator;
	static By calendarTabLocator;
	static By eventDropdownLocator;

	public ClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public ClassPage clickCreateButton() {
		click(createButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreateVolunteerInClassPage createVolunteerAsk() {
		click(volunteerTabLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public ClassPage clickOnMediaTab() {
		click(mediaTabLocator);
		return ClassPage.getClassPage(browser);
	}

	public ClassPage clickOnUpdatesTab() {
		click(updatesTabLocator);
		return ClassPage.getClassPage(browser);
	}

	public CreateEventInClassPage createNewEvent() {
		clickOnEventButton();
		clickOnEventDropdown();
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreatePostInClassPage createNewPost() {
		clickOnCreateButton();
		click(createPostButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreateAnnouncementInClassPage createNewAnnouncement() {
		clickOnCreateButton();
		click(createAnnouncementButtonLocator);
		return CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser);	
	}
	
	public ClassPage clickOnCreateButton() {
		click(createButtonLocator);
		return ClassPage.getClassPage(browser);
	}	

	public ClassPage clickOnCalendarTab() { 
		click(calendarTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnEventButton() {
		click(eventButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnEventDropdown() {
		click(eventDropdownLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public static ClassPage getClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			volunteerTabLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[10]");
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			updatesTabLocator = By.xpath("//*[@id=\"communityMenu_home\"]/a");
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			createPostButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[2]/div");
			createAnnouncementButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[6]");
			calendarTabLocator = By.xpath("//*[@id=\"communityMenu_calendar\"]/a");
			eventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			eventDropdownLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[9]");
			return new WebClassPage(browser);
		}
		return null;
	}

}