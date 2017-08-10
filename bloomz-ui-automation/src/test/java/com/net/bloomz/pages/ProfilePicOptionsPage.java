package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfilePicOptionsPage;
import com.net.bloomz.pages.interfaces.ProfilePicOptionsPageActions;
import com.net.bloomz.pages.web.WebProfilePicOptionsPage ;

public class ProfilePicOptionsPage extends BasePage implements ProfilePicOptionsPageActions {

	static By uploadPhotoButtonLocator = null;
	static By removePhotoButtonLocator = null;
	static By cancelButtonLocator = null;
	static  WebElement element ;

	public ProfilePicOptionsPage(Browser<?> browser) {
		super(browser);

	}

	
	public EditMyProfilePage clickOnRemovePhotoButton() {
		click(removePhotoButtonLocator);
		return EditMyProfilePage.getEditMyProfilePage(browser);
	}

	public EditMyProfilePage clickOnUploadPhotoButton() {
		
//		click(uploadPhotoButtonLocator);
		element = browser.getWebDriver().findElement(uploadPhotoButtonLocator) ;
		element.sendKeys("C:\\myfile.txt") ;
		
		return EditMyProfilePage.getEditMyProfilePage(browser);
	}
	
	public EditMyProfilePage clickOnCancelButton() {
		click(cancelButtonLocator);
		return EditMyProfilePage.getEditMyProfilePage(browser) ;
	}

	public static ProfilePicOptionsPage getProfilePicOptionsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			uploadPhotoButtonLocator	= By.id("net.bloomz:id/txtUploadNewPhoto");
			removePhotoButtonLocator 	= By.id("net.bloomz:id/txtRemovePhoto");
			cancelButtonLocator 		= By.id("net.bloomz:id/txtCancel");
			return new AndroidProfilePicOptionsPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			uploadPhotoButtonLocator	= By.xpath("//span[contains(text(), \"Upload New Photo\")]");
			removePhotoButtonLocator	= By.xpath("//span[contains(text(), \"Remove Photo\")]");
			cancelButtonLocator 		= By.xpath("//span[contains(text(), \"Cancel\")]");
			return new WebProfilePicOptionsPage(browser);
		}
		return null;
	}
}