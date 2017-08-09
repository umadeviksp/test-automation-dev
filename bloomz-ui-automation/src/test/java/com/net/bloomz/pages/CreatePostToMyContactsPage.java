package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePostToMyContactsPageActions;
import com.net.bloomz.pages.web.WebCreatePostToMyContactsPage;


public class CreatePostToMyContactsPage extends BasePage implements CreatePostToMyContactsPageActions {
	
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
	static By toSecondContactLocator;
	static By toThirdContactLocator;

	public CreatePostToMyContactsPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePostInClassPage clickOnToFirstContact() {
		click(toFirstContactLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePostInClassPage clickOnMultipleContacts() {
		click(toFirstContactLocator);
		click(toSecondContactLocator);
		click(toThirdContactLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	
	public static CreatePostToMyContactsPage getCreatePostToMyContactsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			toButtonLocator = By.xpath("//*[@ng-click=\"addRecipients($event)\"]");
			toFirstClassLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			toSecondContactLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[2]/section[2]/div");
			toThirdContactLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[2]/section[3]/div");
			/*doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.id("addPost_postData");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			uploadPhotoInputLocator = By.id("postImgUploaderAddPost");
			backButtonLocator = By.xpath("//*[@id=\"postViewControl\"]/nav/ng-switch[1]/a");
			successIndicatorLocator = By.xpath("//*[@id=\"postViewControl\"]/div[1]/div[1]/section/p[1]");
			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span");
			toFirstContactLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div");
			*/
			return new WebCreatePostToMyContactsPage(browser);
		}
		return null;
	}

}
