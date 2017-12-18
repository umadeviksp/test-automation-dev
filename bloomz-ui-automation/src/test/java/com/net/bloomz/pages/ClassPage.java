package com.net.bloomz.pages;

import java.io.IOException;
import java.io.Reader;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidClassPage;
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
	static By editCoverPhotoButton;
	static By uploadNewPhotoButtonLocator;
	static By mascotPhotoLocator;
	static By postNoCommentsLocator;
	static By groupSettingsLocator;
	static By communityMenuLocator;
	static By readPostNoCommentsTitle;
	static By readNoCommentsTitle;
	static By accessCodeButtonLocator;
	static By accessCodeParentsLocator;
	static By classCodeTextLocator;
	static By doneButtonLocator;
	static By createEventButtonLocator;
	static By signupSheetButtonLocator;

	
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
	
	public ClassPage clickOnAccessCodes() {
		click(accessCodeButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	
	public ClassPage clickOnForParentsAccessCodes() {
		click(accessCodeParentsLocator);
		return ClassPage.getClassPage(browser);
	}
	
	
	public ClassPage clickOnDoneButton() {
		click(doneButtonLocator);
		return ClassPage.getClassPage(browser);
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
	
	public CreateEventInClassPage clickOnEventOption() {
		click(createEventButtonLocator);
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
	

	public ClassPage readPostNoCommentsTitle(String sText) {
		System.out.println(getText(readPostNoCommentsTitle));
		Assert.assertEquals(getText(readPostNoCommentsTitle), sText);
		return ClassPage.getClassPage(browser);
	}

	public ClassPage readNoCommentsTitle(String sText) {
		System.out.println(getText(readNoCommentsTitle));
		Assert.assertEquals(getText(readNoCommentsTitle), sText);
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
	
	public ClassPage verifyImageUploadSuccessfully(String image) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassPage clickOnEditCoverPhotoButton() {
		click(editCoverPhotoButton);
		return ClassPage.getClassPage(browser);
	}

	public ClassPage clickOnUploadNewPhotoButton() {
		click(uploadNewPhotoButtonLocator);
		return ClassPage.getClassPage(browser);
	}

	public ClassPage clickOnMascotPhoto() {
		click(mascotPhotoLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnPostNoComments() {
		click(postNoCommentsLocator);
		return ClassPage.getClassPage(browser);
	}

	public GroupSettingPage clickOnGroupSettings() {
		click(groupSettingsLocator);
		return GroupSettingPage.getGroupSettingPage(browser);
	}
	
	public String readClassCode() {		
		String sClassCode = getText(classCodeTextLocator);
		//return ClassPage.getClassPage(browser);	
		return sClassCode;
	}
	
	public ClassPage uploadImage(String pathToTestImage) throws InterruptedException, IOException {
		//browser.getWebDriver().findElement(uploadNewPhotoButtonLocator).sendKeys(pathToTestImage);
		//return CreatePostInClassPage.getCreatePostInClassPage(browser);

		UploadFileAutoIT(pathToTestImage);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage getClassThemeColor(String sColor) {
		Assert.assertEquals(getColorElement(communityMenuLocator), sColor);
		return ClassPage.getClassPage(browser);
	}
	
	public static String readResponse(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	        sb.append((char) cp);
	    }
	    return sb.toString();
	}
	/*
	public static JsonArray readJsonFromURL(String url) throws IOException, JsonIOException {
	    InputStream is = new URL(url).openStream();
	    Reader rd1 = null ;
	    BufferedReader rd = new BufferedReader(rd1, 0) ;
	    String jsonText = readResponse(rd);
	    // System.out.println("response: " + jsonText);
	    JsonArray jsonData = new JsonArray();
	//    jsonData.
	    is.close();
	    return jsonData;

	}	
	public ClassPage testFunc1()throws IOException, JsonIOException {
		JsonArray responseText ;
		responseText = readJsonFromURL( "https://app-staging.bloomz.net/api/admin/updateuser?email=test_24-sep-2017-8-03-22-pm@test.com&action=getDetails");
		return ClassPage.getClassPage(browser);
	}
	*/
	
	
	
	
	public static ClassPage getClassPage(Browser<?> browser) {
		String string = browser.toString();
	//	System.out.println(string);
		if (string.contains("AndroidMobile")) {
			createButtonLocator = By.id("net.bloomz:id/btnStart");

			createPostButtonLocator = By.xpath("//android.widget.TextView[@text='Post']");
			createAnnouncementButtonLocator = By.xpath("//android.widget.TextView[@text='Announcement']");
			createAlertButtonLocator 	= By.xpath("//android.widget.TextView[@text='Alert']");
			createPTCEventButtonLocator = By.xpath("//android.widget.TextView[@text='Parent Teacher Conference']");
			signupSheetButtonLocator = By.xpath("//android.widget.TextView[@text='Signup Sheet']");
			
			updatesTabLocator 	= By.xpath("//android.widget.LinearLayout[@content-desc='In Group - Updates']");
			calendarTabLocator 	= By.xpath("//android.widget.LinearLayout[@content-desc='In Group - Calendar']");
//			volunteerTabLocator	= By.xpath("//android.widget.LinearLayout[@content-desc='In Group - Signups']");
			volunteerTabLocator = By.xpath("//android.widget.TextView[@text='Signup Sheet']");
			mediaTabLocator 	= By.xpath("//android.widget.LinearLayout[@content-desc='In Group - Media']");
			membersTabLocator 	= By.xpath("//android.widget.TextView[@text='Members']");
			
			eventButtonLocator 	= By.id("net.bloomz:id/btnStart");
			eventDropdownLocator= By.id("net.bloomz:id/llQuickPost");

			upcomingEventsLocator = By.xpath("//android.widget.LinearLayout[@content-desc='In Group - Signups']");
			eventTitlenameLocator = By.id("net.bloomz:id/txtTitle");	
			optionsUpcomingEventLocator = By.xpath("//android.widget.LinearLayout[@name='sda1']");
			deleteUpcomingEventLocator = By.xpath("asas");
			confirmDeleteUpcomingEventLocator = By.xpath("dfdf");

			
			likeButtonLocator 		= By.xpath("//[@id='android.widget.LinearLayout'][@index='0']/[@id='net.bloomz:id/ivLike']");
			commentButtonLocator 	= By.xpath("//[@id='android.widget.LinearLayout'][@index='0']/[@id='net.bloomz:id/llComments']");
			likeTextLocator 		= By.id("net.bloomz:id/txtEnterComment");
			
			return new AndroidClassPage(browser);
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			//Nov 5, 2017 changed the locator
			//volunteerTabLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Signup Sheet']");
			volunteerTabLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Volunteer Help']");
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			membersTabLocator = By.xpath("//*[@id=\"communityMenu_circles\"]/a");
			updatesTabLocator = By.xpath("//*[@id=\"communityMenu_home\"]/a");
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			createPostButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Post']");
			//createAnnouncementButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[6]");
			createAnnouncementButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Announcement']");
			//createAlertButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[8]");
			createAlertButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Alert']");
			//createPTCEventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[11]");
			createPTCEventButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Parent Teacher Conference']");
			createEventButtonLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Event']");
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
			//confirmDeleteUpcomingEventLocator = By.xpath("//*[@id='actionSheet_optionsDiv']/button[2]/span");
			confirmDeleteUpcomingEventLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains(text(),'Delete All Future Events')]");
			editCoverPhotoButton = By.xpath("//*[@id=\"communityScrollView\"]//button[@ng-click=\"editCoverPhoto()\"]");
			uploadNewPhotoButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]//*[contains(text(),\"Upload New Photo\")]");
			mascotPhotoLocator = By.xpath("//*[@id=\"communityScrollView\"]//img[@alt=\"Alpha Teacher Logo\"]");
			postNoCommentsLocator = By.xpath("//*[@id='communityContent']//*[contains(text(), 'test_New Post with no comments')]");
			groupSettingsLocator = By.xpath("//*[@id='orgHome']//*[contains (text(),'Group Settings')]");
			communityMenuLocator = By.id("communityMenu_ul");
			readPostNoCommentsTitle = By.xpath("//*[@id='postViewControl']//span[@ng-bind='getRegularPostTitle()']");
			readNoCommentsTitle = By.xpath("//*[@id='postViewControl']//*[@ng-show='post.disableComments === true']");
			accessCodeButtonLocator = By.xpath("//*[@id='communityScrollView']//*[contains (text(),'Access Codes')]");
			accessCodeParentsLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains (text(),'For Parents')]");
			doneButtonLocator = By.xpath("//*[@id='inviteByGroupCode']//*[contains (text(),'Done')]");
			classCodeTextLocator = By.xpath("//*[@id='inviteByGroupCode']//*[@ng-bind='code']");
						
			return new WebClassPage(browser);
		}
		return null;
	}

}