package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
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
	
	public CreatePostInClassPage uploadImage(String pathToTestImage) {
		browser.getWebDriver().findElement(uploadPhotoInputLocator).sendKeys(pathToTestImage);
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
	
	//Uma added
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
	
	public static CreatePostInClassPage getCreatePostInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
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
			return new WebCreatePostInClassPage(browser);
		}
		return null;
	}

}
