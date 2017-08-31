package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidHomePage;
import com.net.bloomz.pages.interfaces.HomePageActions;
import com.net.bloomz.pages.web.WebHomePage;

public class HomePage extends BasePage implements HomePageActions {

	static By settingButtonLocator;
	static By createButtonLocator;
	static By postUpdateCards;
	static By myCalendarTabLocator;
	static By myContactsTabLocator;
	static By messagesLocator;
	static By volunteerTabLocator;
	
	static By classNameLocator;
	static By createClassLocator;
	static By messageButtonLocator;
	static By firstMessageInTrayLocator;
	static By messageTextLocator;
	static By eventListLocator;
	static By eventOptionsLocator;
	static By eventOptionsEditLocator;
	static By eventPostComment;
	static By sendCommentButtonLocator;
	static int iMessageSize;
	static By commentListLocator;
	static By backButtonLocator;
	static By eventOptionsDeleteLocator;
	static By editEventDelConfirmation;
	static By editEventRemDelConfirmation;

	// By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
	// By homeListViewLocator = By.id("net.bloomz:id/HomeListView");
	// By postTextLocator = By.id("net.bloomz:id/txtAlbumPhotoComment");
	// By homeLauncherIconLocator = By.name("Apps");
	// By bloomzAppLocator = By.name("Bloomz");
	// By homeTab = By.name("home");
	// By menuButtonLocator = By.id("net.bloomz:id/menuBtn");
	// By calendarTab = By.name("calender");
	// By messageTab = By.name("message");
	// By volunteerTab = By.name("volunteer");
	// By contactsTab = By.name("contacts");
	// By postCommentLocator = By.id("net.bloomz:id/txtAlbumPhotoPostBy");
	// By postMessageLocator = By.id("net.bloomz:id/txtPostMessage");
	// By eventNameLocator = By.id("net.bloomz:id/txtCalName");
	// By profileNameLocator = By.id("net.bloomz:id/txtProfileName");
	// By postTitleLocator = By.id("net.bloomz:id/txtPostTitle");

	public HomePage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateClassPage clickOnCreateClass() {
		click(createClassLocator);
		return CreateClassPage.getCreateClassPage(browser);
	}

	@Override
	public SettingPage clickOnSettingButton() {
		waitForElement(settingButtonLocator);
		click(settingButtonLocator);
		return SettingPage.getSettingPage(browser);
	}

	@Override
	public HomePage clickOnBloomzIconForMobileApp() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CalendarTabPage clickOnMyCalendarTab() {
		click(myCalendarTabLocator);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	@Override
	public ContactsTabPage clickOnMyContactsTab() {
		click(myContactsTabLocator);
		return ContactsTabPage.getContactsTabPage(browser);
	}
	
	@Override
	public CreateMessagePage clickOnMyMessageButton() {
		click(messageButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}

	@Override
	public CreatePage clickCreateButton() {
		click(createButtonLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public HomePage clickOnEventList() {
		click(eventListLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnEventOptions() {
		click(eventOptionsLocator);
		return HomePage.getHomePage(browser);
	}
	
	public CreateEventInClassPage clickOnEventOptionsEdit() {
		click(eventOptionsEditLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public HomePage clickOnEventOptionsDelete() {
		click(eventOptionsDeleteLocator);
		return HomePage.getHomePage(browser);
	}
	
	public CreateEventInClassPage clickOnConfirmEventDelete() {
		click(editEventDelConfirmation);
		return  CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public HomePage clickOnEventOptionsDeleteReminder() {
		click(editEventRemDelConfirmation);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyMainFeedPostShouldNotBeNull() {
		Assert.assertTrue(getElementSize(postUpdateCards) > 3, "This account doesn't contain posts");
		return HomePage.getHomePage(browser);
	}

	public HomePage thenVerifyCreateButtonShouldBeDisplayed() {
		waitForElement(createButtonLocator);
		Assert.assertTrue(browser.getActions().isClickable(createButtonLocator), "Create is not displayed");
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyMessagesShouldNotBeNull() {
		Assert.assertTrue(getElementSize(messagesLocator) > 0, "No messages are displayed");
		return HomePage.getHomePage(browser);
	}
	
	/*public HomePage getMessageSize() {
		iMessageSize = getElementSize(messagesLocator);
		//iMessageSize = getElementSize(locator);
		System.out.println(iMessageSize);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyMessages_a(String sText) {
		System.out.println(getElementSize(messagesLocator));
		Assert.assertTrue(getElementSize(messagesLocator) > iMessageSize, "New message is not sent");
		return HomePage.getHomePage(browser);
	}*/
	
	public ClassPage clickOnAClassName() {
		click(classNameLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreateMessagePage clickOnFirstMessageInTray() {
		click(firstMessageInTrayLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public HomePage ReadkOnFirstMessageInTray(String sText) {
		System.out.println(getText(messageTextLocator));
		Assert.assertEquals(getText(messageTextLocator),sText);		
		return HomePage.getHomePage(browser);
	}

	public HomePage enterPostComment() {
		sendText(eventPostComment, "comment successfully posted");
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnSendComment() {
		click(sendCommentButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyThatCommentWasSuccessful(String stext) {
		Assert.assertEquals(getText(commentListLocator) , stext);
		return HomePage.getHomePage(browser);
	}
	

	public HomePage clickOnBackButton() {
		click(backButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public static HomePage getHomePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			settingButtonLocator = By.id("net.bloomz:id/txtSetting");
			createButtonLocator = By.id("net.bloomz:id/btnStart");
			postUpdateCards = By.id("");
			myCalendarTabLocator = By.name("calendar");
			volunteerTabLocator = By.name("volunteer");
			return new AndroidHomePage(browser);
		} else if (string.contains(".iOS")) {
			settingButtonLocator = By.id("");
		} else {
			settingButtonLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftProfile\"]");
			createButtonLocator = By.xpath("//*[@data-post=\"+ Create\"]");
			postUpdateCards = By.xpath("//*[@post-message=\"postMessage\"]");
			myCalendarTabLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftMy Calendar\"]");
			myContactsTabLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftMy Contacts\"]");
			volunteerTabLocator = By.id("bloomzMainNav_navLeftVolunteers");
			
			messagesLocator = By.xpath("//*[@ng-click=\"showMessage(message)\"]");
			firstMessageInTrayLocator = By.xpath("//*[@id=\"messages_section\"]/article[1]/div[1]/h2/div");
			classNameLocator = By.xpath("//*[@id=\"posts\"]/nav[1]/div[2]/ul[4]/li/ul/li[1]/span/a");
			createClassLocator = By.xpath("//*[@id=\"welcomeTeacherCard\"]/div/article/ul/li[4]/a");
			messageButtonLocator = By.xpath ("//*[@id=\"_sidechat\"]/div/div/div[2]/button");
			messageTextLocator = By.xpath("//*[@id=\"messages_section\"]/article/div[2]/span");
			//eventListLocator = By.xpath("*[@id=\"posts_updatesHomeSection\"]/div[1]/article/p/span[1]");
			eventListLocator = By.xpath("//*[@id=\"posts_updatesHomeSection\"]/div[1]/article/div[3]");
			eventOptionsLocator = By.xpath("//*[@id=\"calendarViewControl\"]/nav/a[2]");
			eventOptionsEditLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			eventOptionsDeleteLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[2]/span");
			editEventDelConfirmation = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			editEventRemDelConfirmation = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[3]/span");
			eventPostComment = By.id("event_commentText");
			sendCommentButtonLocator = By.xpath("//*[@id=\"calendarViewControl\"]/div[2]/div/form/div[2]/button");
			
			commentListLocator = By.xpath("//*[@id=\"calendarViewControl\"]/div[1]/section/div[1]/ul/li[2]");
			backButtonLocator = By.xpath("//*[@id=\"calendarViewControl\"]/nav/a[1]");

			
			return new WebHomePage(browser);
		} 
		return null;
	}

}