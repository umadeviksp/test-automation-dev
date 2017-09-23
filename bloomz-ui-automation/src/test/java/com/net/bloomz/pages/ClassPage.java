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
	static By createAlertButtonLocator;
	static By createPTCEventButtonLocator;
	static By calendarTabLocator;
	static By eventDropdownLocator;
	static By likeButtonLocator;
	static By commentButtonLocator;
	static By likeTextLocator;
	static By newClassNameLocator;
	static By upcomingEventsLocator;
	static By optionsUpcomingEventLocator;
	static By deleteUpcomingEventLocator;
	static By confirmDeleteUpcomingEventLocator;
	static By eventTitlenameLocator;
	static By membersTabLocator;

	

	
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
	
	public MediaTabPage clickOnMediaTab() {
		click(mediaTabLocator);
		return MediaTabPage.getMediaTabPage(browser);
	}

	public CreateEventInClassPage clickOnUpdatesTab() {
		click(updatesTabLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}

	public MembersTabPage clickOnMembersTab() {
		click(membersTabLocator);
		return MembersTabPage.getMembersTabPage(browser);
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
	
	public CreateAlertInClassPage createNewAlert() {
		clickOnCreateButton();
		click(createAlertButtonLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);	
	}
	
	public CreatePTCEventInClassPage createNewPTCEvent() {
		clickOnCreateButton();
		click(createPTCEventButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public ClassPage clickOnCreateButton() {
		click(createButtonLocator);
		return ClassPage.getClassPage(browser);
	}

	public CalendarTabPage clickOnCalendarTab() { 
		click(calendarTabLocator);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	public ClassPage clickOnEventButton() {
		click(eventButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnEventDropdown() {
		click(eventDropdownLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	//Uma added
	public ClassPage clickOnLikeButton() {
		click(likeButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage thenVerifyThatLikeWasSuccessful(String stext) {
		Assert.assertEquals(getText(likeTextLocator) , stext);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage thenVerifyClassname(String sText) {
		System.out.println(getText(newClassNameLocator));
		Assert.assertEquals(getText(newClassNameLocator), sText);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnUpcomingEvents() {
		click(upcomingEventsLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage readUpcomingEventTitle(String sText) {
		System.out.println(getText(eventTitlenameLocator));
		Assert.assertEquals(getText(eventTitlenameLocator), sText);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnUpcomingEventsOptions() {
		click(optionsUpcomingEventLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnUpcomingEventDelete() {
		click(deleteUpcomingEventLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnConfirmUpcomingEventDelete() {
		click(confirmDeleteUpcomingEventLocator);
		return ClassPage.getClassPage(browser);
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
			membersTabLocator = By.xpath("//*[@id=\"communityMenu_circles\"]/a");
			updatesTabLocator = By.xpath("//*[@id=\"communityMenu_home\"]/a");
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			createPostButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[2]/div");
			createAnnouncementButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[6]");
			createAlertButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[8]");
			createPTCEventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[11]");
			calendarTabLocator = By.xpath("//*[@id=\"communityMenu_calendar\"]/a");
			eventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			eventDropdownLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[9]");
			//Uma added
			likeButtonLocator = By.xpath("//*[@id=\"communityContent\"]/span/section[16]/div[2]/article/footer[1]/ul[1]/li[1]");
			commentButtonLocator = By.xpath("//*[@id=\"communityContent\"]/span/section[16]/div[2]/article/footer[1]/ul[1]/li[3]");
			likeTextLocator = By.xpath("//*[@id=\"communityContent\"]/span/section[16]/div[2]/article/footer[1]/ul[1]/li[3]");
			newClassNameLocator = By.xpath("//*[@id=\"orgHome\"]/div/nav[1]/h1/div");			
			upcomingEventsLocator = By.xpath("//section[@id='communityContent']//section[@id='posts_calendarEventsSection']/article/div");
			eventTitlenameLocator = By.xpath("//*[@id='calendarViewControl']/div[1]/section/section[1]/article/div[1]/h2/span");	
			optionsUpcomingEventLocator = By.xpath("//*[@id='calendarViewControl']/nav/a[2]");
			deleteUpcomingEventLocator = By.xpath("//*[@id='actionSheet_optionsDiv']/button[4]/span");
			confirmDeleteUpcomingEventLocator = By.xpath("//*[@id='actionSheet_optionsDiv']/button[2]/span");
						
			return new WebClassPage(browser);
		}
		return null;
	}

}