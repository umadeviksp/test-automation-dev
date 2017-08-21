package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidEditMyProfilePage ;
import com.net.bloomz.pages.interfaces.EditMyProfilePageActions;
import com.net.bloomz.pages.web.WebEditMyProfilePage ;
import com.net.bloomz.pages.ProfilePicOptionsPage ;

public class EditMyProfilePage extends BasePage implements EditMyProfilePageActions {

	static By cancelButtonLocator = null;
	static By saveButtonLocator = null;
	static By choosePhotoButtonLocator = null;
	static By firstNameTextLocator = null;
	static By lastNameTextLocator = null;
	static By genderMaleSelectLocator = null;
	static By genderFemaleSelectLocator = null;

	public EditMyProfilePage(Browser<?> browser) {
		super(browser);

	}

	
	public MyProfilePage clickOnGoBackButton() {
		click(cancelButtonLocator);
		return MyProfilePage.getMyProfilePage(browser) ;
	}

	public MyProfilePage clickOnSaveButton() {
		click(saveButtonLocator);
		return MyProfilePage.getMyProfilePage(browser) ;
	}

	public ProfilePicOptionsPage clickOnChoosePhotoButton() {
		click(choosePhotoButtonLocator);
		return ProfilePicOptionsPage.getProfilePicOptionsPage(browser);
	}

	public EditMyProfilePage enterFirstName(String firstName) {
		sendText(firstNameTextLocator, firstName);
		return this;
	}

	public EditMyProfilePage enterLastName(String lastName) {
		sendText(lastNameTextLocator, lastName);
		return this;
	}

	public EditMyProfilePage selectMaleGenderButton() {
		click(genderMaleSelectLocator);
		return this;
	}

	public EditMyProfilePage selectFemaleGenderButton() {
		click(genderFemaleSelectLocator);
		return this;
	}

	public static EditMyProfilePage getEditMyProfilePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			choosePhotoButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			cancelButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			firstNameTextLocator 	= By.id("net.bloomz:id/txtSignOut");
			lastNameTextLocator = By.id("net.bloomz:id/txtAccountSettings");
			return new AndroidEditMyProfilePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			cancelButtonLocator	= By.xpath("//nav[@id = 'userProfileView_myProfileEditHeader']//a[@class='backButton']");
			saveButtonLocator 	= By.xpath("//nav[@id = 'userProfileView_myProfileEditHeader']//a[@class='nextButton']");
			choosePhotoButtonLocator	= By.xpath("//section[contains(@class,'userProfileInfo')]//span[@class='choosePhotoOptions']");
			
			firstNameTextLocator= By.xpath("//section[contains(@class,'myInfoEdit')]//input[@id='editProfile_firstName']");
			lastNameTextLocator = By.xpath("//section[contains(@class,'myInfoEdit')]//input[@id='editProfile_lastName']");
			genderMaleSelectLocator = By.xpath("//section[contains(@class,'myInfoEdit')]//input[@value='male']");
			genderFemaleSelectLocator = By.xpath("//section[contains(@class,'myInfoEdit')]//input[@value='female']");
			return new WebEditMyProfilePage(browser);
		}
		return null;
	}
}