package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePostToMyCommunitiesPageActions;
import com.net.bloomz.pages.web.WebCreatePostToMyCommunitiesPage;


public class CreatePostToMyCommunitiesPage extends BasePage implements CreatePostToMyCommunitiesPageActions {
	
	static By toButtonLocator;
	static By toFirstClassLocator;
	static By doneButtonLocator;
	static By titleFieldLocator;
	static By generalUpdateFieldLocator;
	static By postButtonLocator;
	static By backButtonLocator;
	static By uploadPhotoInputLocator;
	static By successIndicatorLocator;
	static By selectAllLocator;
	static By toFirstContactLocator;

	public CreatePostToMyCommunitiesPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePostInClassPage clickOnToFirstContact() {
		click(toFirstContactLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	/*public CreatePostToMyContactsPage clickOnToFirstContact() {
		click(toFirstClassLocator);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage clickOnToDoneButton() {
		click(doneButtonLocator);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage clickOnSelectAll() {
		click(selectAllLocator);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage enterTitle(String title) {
		sendText(titleFieldLocator, title);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage enterGeneralUpdate(String updateText) {
		sendText(generalUpdateFieldLocator, updateText);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}

	public CreatePostToMyContactsPage clickOnPostButton() {
		click(postButtonLocator);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostToMyContactsPage uploadImage(String pathToTestImage) {
		browser.getWebDriver().findElement(uploadPhotoInputLocator).sendKeys(pathToTestImage);
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	
	public ClassPage clickOnBackButton() {
		click(backButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreatePostToMyContactsPage thenVerifyThatPostWasSuccessful() {
		Assert.assertTrue(getElementSize(successIndicatorLocator) > 0, "Post was not successful");
		return CreatePostToMyContactsPage.getCreatePostInClassPage(browser);
	}
	*/

	public static CreatePostToMyCommunitiesPage getCreatePostToMyCommunitiesPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			toButtonLocator = By.xpath("//*[@ng-click=\"addRecipients($event)\"]");
			//*[@id="recipientPicker"]/div/div/div/section/div[2]/section[1]/div/h2/a/span
			//*[@id="recipientPicker"]/div/div/div/section/div[2]/section[2]/div/h2/a/span
			//*[@id="recipientPicker"]/div/div/div/section/div/section[2]/div/button[1]
			toFirstClassLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.id("addPost_postData");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			uploadPhotoInputLocator = By.id("postImgUploaderAddPost");
			backButtonLocator = By.xpath("//*[@id=\"postViewControl\"]/nav/ng-switch[1]/a");
			successIndicatorLocator = By.xpath("//*[@id=\"postViewControl\"]/div[1]/div[1]/section/p[1]");
			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span");
			toFirstContactLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			return new WebCreatePostToMyCommunitiesPage(browser);
		}
		return null;
	}

}
