package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePostToMyCommunitiesPageActions;
import com.net.bloomz.pages.web.WebCreatePostToMyCommunitiesPage;


public class CreatePostToMyCommunitiesPage extends BasePage implements CreatePostToMyCommunitiesPageActions {
	
	/*static By toButtonLocator;
	static By toFirstClassLocator;
	static By doneButtonLocator;
	static By titleFieldLocator;
	static By generalUpdateFieldLocator;
	static By postButtonLocator;
	static By backButtonLocator;
	static By uploadPhotoInputLocator;
	static By successIndicatorLocator;
	static By selectAllLocator; */
	static By toFirstCommunityLocator;

	public CreatePostToMyCommunitiesPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePostInClassPage clickOnToFirstCommunity() {
		click(toFirstCommunityLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	
	public static CreatePostToMyCommunitiesPage getCreatePostToMyCommunitiesPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			/*toButtonLocator = By.xpath("//*[@ng-click=\"addRecipients($event)\"]");
			toFirstClassLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.id("addPost_postData");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			uploadPhotoInputLocator = By.id("postImgUploaderAddPost");
			backButtonLocator = By.xpath("//*[@id=\"postViewControl\"]/nav/ng-switch[1]/a");
			successIndicatorLocator = By.xpath("//*[@id=\"postViewControl\"]/div[1]/div[1]/section/p[1]");
			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span"); */
			toFirstCommunityLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section/div"); 
			//*[@id="recipientPicker"]/div/div/div/section/div/section/div/h2/button/span[2]
			//*[@id="recipientPicker"]/div/div/div/section/div/section/div
			return new WebCreatePostToMyCommunitiesPage(browser);
		}
		return null;
	}

}
