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
	static By eventBubblelocator;
	static By communityNameLocator;
	static By profileNameTextLocator;
	static By successEventMessageLocator;
	static By newClassNameLocator;
	static By announcementSectionLocator;
	static By announcementLocator;
	static By deleteAnnouncementLocator;
	static By upcomingEventsLocator;
	static By alertEventLocator;
	static By classNameSecondLocator;
	static By scrollHomeLocator;
	static By scrollDownSupportLocator;
	static By scrollUpWelcomeLocator;
	static By signupsTabLocator;
	static By welcomeMessageLocator;
	static By createClassWelcomeLocator;
	static By tourWelcomeLocator;
	static By feedLocator;
	static By membersTabLocator;
	static By inviteButtonLocator;
	static By announceOptionsLocator;
	static By allGroupsMenuLocator;
	static By yesDeleteAnnouncementLocator;
	static By alertConfirmDeleteLocator;

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
	
	public SignUpPage clickOnMySignupsTab() {
		click(signupsTabLocator);
		return SignUpPage.getSignUpPage(browser);
	}
	
	@Override
	public CreateMessagePage clickOnMyMessageButton() {
		click(messageButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}

	public MembersTabPage clickOnMembersTab() {
		click(membersTabLocator);
		return MembersTabPage.getMembersTabPage(browser);
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
	

	public HomePage thenVerifyMainFeed() {
		Assert.assertTrue(getElementSize(feedLocator) > 0, "Home Feed is not visible");
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
//		ReadJson();
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnASecondClassName() {
		click(classNameSecondLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnACommunity() {
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

	public HomePage clickOnEventBubbleButton() {
		click(eventBubblelocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyProfileName(String sText) {
		Assert.assertEquals(getAttribute(profileNameTextLocator, "data-displayname"),sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyClassname(String sText) {
		System.out.println(getText(newClassNameLocator));
		Assert.assertEquals(getText(newClassNameLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyAnnouncements(String sText) {
		System.out.println(getText(announcementSectionLocator));
		Assert.assertEquals(getText(announcementSectionLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnAnnouncement() {
		click(announcementLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnAnnouncementOptions() {
		click(announceOptionsLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnAnnouncementDeleteButton() {
		click(deleteAnnouncementLocator);
		return HomePage.getHomePage(browser);
	}

	
	public HomePage clickOnConfirmAnnouncementDeleteButton() {
		click(yesDeleteAnnouncementLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyThatPostWasSuccessful(String sText) {
		successEventMessageLocator = By.id("toast");
		System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyThatUploadWasSuccessful(String sText) {
		//successEventMessageLocator = By.id("toast");
		//System.out.println(getText(successEventMessageLocator));
		//Assert.assertEquals(getText(successEventMessageLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public CreateAlertInClassPage clickOnAlertEventButton() throws InterruptedException{
		System.out.println("Click on alert section");
		scrollIntoView(alertEventLocator);
		click(alertEventLocator);
		System.out.println("Found alert section");
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}


	public HomePage clickOnConfirmDeleteAlert() {
		click(alertConfirmDeleteLocator);
		return HomePage.getHomePage(browser);
	}
	
	public InvitationGroupPage clickOnInviteButton() {
		click(inviteButtonLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public HomePage ScrollDownHomeFeed() throws InterruptedException {
		scrollIntoView(scrollDownSupportLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyScrollDown(String sText) {
		System.out.println(getText(scrollDownSupportLocator));
		Assert.assertEquals(getText(scrollDownSupportLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage ScrollUpHomeFeed() throws InterruptedException {
		scrollIntoView(scrollUpWelcomeLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyScrollUp(String sText) {
		System.out.println(getText(scrollUpWelcomeLocator));
		Assert.assertEquals(getText(scrollUpWelcomeLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyWelcomeScreen() {
		Assert.assertEquals(getText(welcomeMessageLocator), "Welcome to Bloomz");
		Assert.assertEquals(getText(createClassLocator), "Create a Class");
		Assert.assertEquals(getText(tourWelcomeLocator), "Take Quick Tour");
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyWelcomeScreenTroop(String sText) {
		Assert.assertEquals(getText(welcomeMessageLocator), "Welcome to Bloomz");
		Assert.assertEquals(getText(createClassLocator), sText);
		Assert.assertEquals(getText(tourWelcomeLocator), "Take Quick Tour");
		return HomePage.getHomePage(browser);
	}
	
	public HomePage clickOnAllGroupsButton() {
		System.out.println("Click on All groups");
		click(allGroupsMenuLocator);
		System.out.println("Clicked on All groups");
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
			//messageButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Message Class']");
			messageTextLocator = By.xpath("//*[@id=\"messages_section\"]/article/div[2]/span");
			//eventListLocator = By.xpath("*[@id=\"posts_updatesHomeSection\"]/div[1]/article/p/span[1]");
			eventListLocator = By.xpath("//*[@id=\"posts_updatesHomeSection\"]/div[1]/article/div[3]");
			eventOptionsLocator = By.xpath("//*[@id=\"calendarViewControl\"]/nav/a[2]");
			eventOptionsEditLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			eventOptionsDeleteLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[2]/span");
			editEventDelConfirmation = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			editEventRemDelConfirmation = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[3]/span");
			eventPostComment = By.id("event_commentText");
			//sendCommentButtonLocator = By.xpath("//*[@id=\"calendarViewControl\"]/div[2]/div/form/div[2]/button");
			sendCommentButtonLocator = By.cssSelector("#calendarViewControl > div.chatInput.ng-scope > div > form > div.buttonWrapper > button");
			
			commentListLocator = By.xpath("//*[@id=\"calendarViewControl\"]/div[1]/section/div[1]/ul/li[2]");
			backButtonLocator = By.xpath("//*[@id=\"calendarViewControl\"]/nav/a[1]");
			eventBubblelocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftHome\"]/span");
			communityNameLocator = By.xpath("//*[@id=\"posts\"]/nav[1]/div[2]/ul[3]/li/ul/li/span/a");
			//profileNameTextLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftProfile\"]/span");
			profileNameTextLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftProfile\"]/span");
			newClassNameLocator = By.xpath("//*[@id=\"orgHome\"]/div/nav[1]/h1/div");
			announcementSectionLocator = By.xpath("//*[@id=\"posts_announcementsSection\"]/h1/span");
			//announcementCloseButtonLocator = By.xpath("//*[@id=\"posts_announcementsSection\"]/div/div/article/div[1]");
			announcementLocator = By.xpath("//*[@id='posts_announcementsSection']//*[contains(text(),'test announcement')]");
			announceOptionsLocator= By.xpath("//*[@id='postViewControl']//ng-switch[@on='rightButtonIsImage']//*[contains(text(),'Options')]");
			//deleteAnnouncementLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[2]/span");
			deleteAnnouncementLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains(text(),'Delete Announcement')]");
			yesDeleteAnnouncementLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains(text(), 'Yes')]");
			successEventMessageLocator = By.id("toast");
			//alertEventLocator = By.xpath("//*[@id='communityContent']/span/section[16]/div[2]/article/p/span[2]");
			alertEventLocator = By.xpath("//*[@id='posts_updatesHomeSection']//*[contains(text(),'test_alert_message')]");
			alertConfirmDeleteLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains(text(), 'Yes')]");
			classNameSecondLocator = By.xpath("//*[@id='posts']/nav[1]/div[2]/ul[4]/li/ul/li[2]/span/a");
			scrollHomeLocator = By.xpath("//*[@id='posts']/div[7]");
			scrollDownSupportLocator = By.xpath("//*[@id='postsList']/div[2]/ul/li[2]/a");
			scrollUpWelcomeLocator = By.xpath("//*[@id='welcomeTeacherCard']/div/article/div/h2");
			signupsTabLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftSignups\"]");
			welcomeMessageLocator = By.xpath("//*[@id='welcomeTeacherCard']/div/article/div/h2");
			//createClassWelcomeLocator = By.xpath("//*[@id='welcomeTeacherCard']/div/article/ul/li[4]/a");
			tourWelcomeLocator = By.xpath("//*[@id='welcomeTeacherCard']/div/article/ul/li[3]/a");
			feedLocator = By.xpath("//*[@id='communityScrollView']/h1/span[1]/div");
			membersTabLocator = By.xpath("//*[@id='communityMenu_circles']/a");

			inviteButtonLocator = By.xpath ("//div[@id='mainPanel']//a[@id='bloomzMainNav_navLeftInvite']");
			allGroupsMenuLocator = By.xpath("//*[@id='bloomzMainNav_navLeftHome']");
			
			
			return new WebHomePage(browser);
		} 
		return null;
	}

}