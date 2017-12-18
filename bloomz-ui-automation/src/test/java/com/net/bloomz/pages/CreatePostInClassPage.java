package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreatePostInClassPage;
import com.net.bloomz.pages.interfaces.CreatePostInClassPageActions;
import com.net.bloomz.pages.web.WebCreatePostInClassPage;

public class CreatePostInClassPage extends BasePage implements CreatePostInClassPageActions {
	
	static By toButtonLocator;
	static By toFirstClassLocator;
	static By doneButtonLocator;
	static By titleFieldLocator;
	static By generalUpdateFieldLocator;
	static By postButtonLocator;
	static By backButtonLocator;
	static By uploadPhotoInputLocator;
	static By successIndicatorLocator;
	static By myContactsLocator;
	static By myCommunitiesLocator;
	static By postCommentFieldLocator;
	static By sendCommentButtonLocator;
	static By selectAllLocator;
	static By commentsButtonLocator;
	static By postOptionsLocator;
	static By deletePostButtonLocator;
	static By confirmDeletePostLocator;
	static By scheduleButtonLocator;
	static By scheduleDateButtonLocator;
	static By calendarLocator;
	static By scheduleTimeLocator;
	static By schedulePostLocator;
	static By noOfScheduledPostLocator;
	static By deleteScheduledPostLocator;
	static By fileButtonLocator;
	static By scheduleNoPostLocator;
	static By seeMembersOfAClassLocator;
	static By searchStringInputLocator;
	static By selectEmailIDLocator;
	static By done2ButtonLocator;


	public CreatePostInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePostInClassPage clickOnPostToField() {
		click(toButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnToFirstClass() {
		click(toFirstClassLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnToDoneButton() {
		click(doneButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage enterTitle(String title) {
		sendText(titleFieldLocator, title);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage enterGeneralUpdate(String updateText) {
		sendText(generalUpdateFieldLocator, updateText);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}

	public CreatePostInClassPage clickOnPostButton() {
		click(postButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage uploadImage(String pathToTestImage) throws InterruptedException {
		if (browser.toString().contains("AndroidMobile")) {
			//do nothing
		}
		else
		{
			browser.getWebDriver().findElement(uploadPhotoInputLocator).sendKeys(pathToTestImage);
			Thread.sleep(30);
		}
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage uploadFile(String pathToTestImage) {
		if (browser.toString().contains("AndroidMobile")) {
			//do nothing
		}
		else
		{
			browser.getWebDriver().findElement(fileButtonLocator).sendKeys(pathToTestImage);
		}
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public ClassPage clickOnBackButton() {
		click(backButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreatePostInClassPage thenVerifyThatPostWasSuccessful() {
		Assert.assertTrue(getElementSize(successIndicatorLocator) > 0, "Post was not successful");
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage thenVerifyThatSchedulePostWasSuccessful() {
		Assert.assertTrue(getElementSize(noOfScheduledPostLocator) == 1, "Schedule post was not successful");
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnScheduledPost() {
		click(scheduleNoPostLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnDeleteScheduledPost() {
		click(deleteScheduledPostLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage clickOnMyContacts() {
		click(myContactsLocator);
		return CreatePostToMyContactsPage.getCreatePostToMyContactsPage(browser);
	}
	
	public CreatePostToMyCommunitiesPage clickOnMyCommunities() {
		click(myCommunitiesLocator);
		return CreatePostToMyCommunitiesPage.getCreatePostToMyCommunitiesPage(browser);
	}
	
	public CreatePostInClassPage enterPostComment() {
		sendText(postCommentFieldLocator, "comment successfully posted");
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnSendPostComment() {
		click(sendCommentButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}

	public CreatePostInClassPage clickOnSelectAll() {
		click(selectAllLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}

	public CreatePostInClassPage clickOnCommentsButton() {
		click(commentsButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
		
	public CreatePostInClassPage clickOnScheduleButton() {
		click(scheduleButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickScheduleDate() {
		click(scheduleDateButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clearScheduleDate() {
		clearTextBox(scheduleDateButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage enterScheduleDate(Integer iYrs, Integer iMons, Integer iDay) {
		sendText(scheduleDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickCloseCalendar() {
		click(calendarLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickStartTime() {
		click(scheduleTimeLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clearStartTime() {
		clearTextBox(scheduleTimeLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage enterStartTime(String sTime) {
		sendText(scheduleTimeLocator,sTime);
		sendkeyboardEvent(scheduleTimeLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	
	public CreatePostInClassPage clickOnSchedulePost() {
		click(schedulePostLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnPostOptions() {
		click(postOptionsLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnDeletePost() {
		click(deletePostButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnConfirmDeletePost() {
		click(confirmDeletePostLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnFileAttachPost() {
		click(fileButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	

	public CreatePostInClassPage clickOnSeeMembersOfAClass() {
		click(seeMembersOfAClassLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	
	public CreatePostInClassPage clickOnSearchString() {
		click(searchStringInputLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage enterEmailID(String sText) {
		sendText(searchStringInputLocator,sText);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	
	public CreatePostInClassPage selectEmailID() {
		click(selectEmailIDLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
		
	public CreatePostInClassPage ClickOnDoneLocator() {
		click(done2ButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public static CreatePostInClassPage getCreatePostInClassPage(Browser<?> browser) {
		String string = browser.toString();
	//	System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			toButtonLocator = By.id("net.bloomz:id/llSetPostTo");
			titleFieldLocator = By.id("net.bloomz:id/edittitle");
			generalUpdateFieldLocator = By.id("net.bloomz:id/editdiscreption");
			postButtonLocator = By.id("net.bloomz:id/btnDone");
			backButtonLocator = By.id("net.bloomz:id/backarrow");

			doneButtonLocator 	= By.id("net.bloomz:id/DoneBtn");
			toFirstClassLocator = By.xpath("//android.widget.LinearLayout[@index='1']") ;

			uploadPhotoInputLocator = By.id("net.bloomz:id/llinsertphoto");
			myContactsLocator 		= By.id("net.bloomz:id/btnDone");
			myCommunitiesLocator 	= By.id("net.bloomz:id/btnDone");
			postCommentFieldLocator = By.id("net.bloomz:id/txtEnterComment");
			sendCommentButtonLocator = By.id("net.bloomz:id/sendbtn");

			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span");
			successIndicatorLocator = By.xpath("//*[@id=\"postViewControl\"]/div[1]/div[1]/section/p[1]");

			return new AndroidCreatePostInClassPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			toButtonLocator = By.xpath("//*[@ng-click=\"addRecipients($event)\"]");
			toFirstClassLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.id("addPost_postData");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			uploadPhotoInputLocator = By.id("postImgUploaderAddPost");
			backButtonLocator = By.xpath("//*[@id=\"postViewControl\"]/nav/ng-switch[1]/a");
			successIndicatorLocator = By.xpath("//*[@id=\"postViewControl\"]/div[1]/div[1]/section/p[1]");
			myContactsLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/div/ul/li[1]/a");
			myCommunitiesLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/div/ul/li[3]/a");
			postCommentFieldLocator = By.id("post_commentText");
			sendCommentButtonLocator = By.xpath("//*[@id=\"postViewControl\"]/div[2]/div/form/div[2]/button");
			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span");
			commentsButtonLocator = By.xpath("//*[@id='addPostFooterForm']//*[@data-fulltext='Comments']");
			scheduleButtonLocator = By.xpath("//*[@id='addPostFooterForm']//*[@data-fulltext='Schedule']");
			postOptionsLocator = By.xpath("//*[@id='postViewControl']//ng-switch[@on='rightButtonIsImage']//*[contains(text(),'Options')]");
			deletePostButtonLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains(text(), 'Delete Post')]");
			confirmDeletePostLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains(text(), 'Yes')]");
			scheduleDateButtonLocator = By.xpath("//*[@id='_addPost']//label[text()='Schedule For']//input[@class='datePicker']");
			scheduleTimeLocator = By.xpath("//*[@id='_addPost']//label[text()='Schedule For']//div[@date='startDateTimeInput']//div[@class='timePicker']//input");
			calendarLocator = By.xpath("//*[@id=\"CalendarControl\"]/a");
			schedulePostLocator = By.xpath("//*[@id='addPost']//a[contains (text(),'Schedule')]");
			noOfScheduledPostLocator = By.xpath("//*[@id='communityContent']//a[contains(text(), '1 scheduled')]");
			scheduleNoPostLocator = By.xpath("//*[@id='communityContent']//a[@ng-if='scheduledPostsCount > 0']");
			deleteScheduledPostLocator = By.xpath("//*[@id='postViewControl']//li[contains(text(), 'Delete')]");
			fileButtonLocator = By.xpath("//*[@id='addPostFooterForm']//*[@data-fulltext='Attach Files']");
			seeMembersOfAClassLocator = By.xpath("//*[@id='recipientPicker']//section[1]//*[contains (text(),'See Members')]");
			searchStringInputLocator = By.xpath("//*[@id='_recipientControl_1']//*[@id='addRecipientsSearchInput_recipientControl_1']");
			selectEmailIDLocator = By.xpath("//*[@id='recipientPicker']//*[contains (text(),'Add')]");
			done2ButtonLocator = By.xpath("//*[@id='_recipientControl_1']//*[@id='recipientPicker']/div/div/nav[2]/a[2]");

			return new WebCreatePostInClassPage(browser);
		}
		return null;
	}

}
