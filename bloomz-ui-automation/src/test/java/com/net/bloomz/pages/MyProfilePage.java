package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMyProfilePage;
import com.net.bloomz.pages.interfaces.MyProfilePageActions;
import com.net.bloomz.pages.web.WebMyProfilePage ;
import com.net.bloomz.pages.ProfileAddSpousePage;
import com.net.bloomz.pages.ProfileRemoveSpousePage;
import com.net.bloomz.pages.ProfileAddChildPage;
import com.net.bloomz.pages.EditMyProfilePage ;

public class MyProfilePage extends BasePage implements MyProfilePageActions {

	static By addSpouseButtonLocator = null;
	static By removeSpouseButtonLocator = null;
	static By addChildButtonLocator = null;
	static By editButtonLocator = null;
	static By goBackButtonLocator = null;
	static By childListLocator = null;
	static By successEventMessageLocator = null;
	static By spouseInvitedImgLocator = null;
	static By yesButtonLocator = null;

	public MyProfilePage(Browser<?> browser) {
		super(browser);

	}
	
	public ProfileAddSpousePage clickOnAddSpouseButton() {
		click(addSpouseButtonLocator);
		return ProfileAddSpousePage.getProfileAddSpousePage(browser);
	}
	public ProfileRemoveSpousePage clickOnRemoveSpouseButton() {
		click(removeSpouseButtonLocator);
		return ProfileRemoveSpousePage.getProfileRemoveSpousePage(browser);
	}
	public ProfileAddChildPage clickOnAddChildButton() {
		click(addChildButtonLocator);
		return ProfileAddChildPage.getProfileAddChildPage(browser);
	}

	public HomePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return HomePage.getHomePage(browser) ;
	}
	public EditMyProfilePage clickOnEditButton() {
		click(editButtonLocator);
		return EditMyProfilePage.getEditMyProfilePage(browser);
	}
	
	public MyProfilePage thenVerifyThatUploadWasSuccessful(String sText) {
		//successEventMessageLocator = By.id("toast");
		System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return this;
	}
	
	public MyProfilePage clickOnSpouseInvited() {
		click(spouseInvitedImgLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}
	
	public MyProfilePage clickOnYesButton() {
		click(yesButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}
	

	public static MyProfilePage getMyProfilePage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			addSpouseButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			removeSpouseButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			addChildButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			editButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidMyProfilePage(browser);
		} else if (string.contains(".iOS")) {

		} else {

			addSpouseButtonLocator 	= By.xpath("//section[@id='userProfileView_myFamilyListing']//span[contains(@class,'profileM')]");
			removeSpouseButtonLocator 	= By.xpath("//section[@id='userProfileView_myFamilyListing']//span[contains(@class,'spouseInvited')]");
			childListLocator 	= By.xpath("//section[@id='userProfileView_myFamilyListing']//span[@name='userProfileView_myChild']");
			addChildButtonLocator = By.xpath("//*[@id=\"userProfileView_myFamilyListing\"]/a[2]/span");
			editButtonLocator 	= By.xpath("//div[contains(@class,'profilePage')]//a[contains(@class,'nextButton')]");
			goBackButtonLocator 	= By.xpath("//div[contains(@class,'profilePage')]//a[contains(@class,'backButtonOnly')]");
			successEventMessageLocator = By.id("toast");
			spouseInvitedImgLocator = By.xpath("//*[@id='userProfileView_myFamilyListing']//*[@data-displayname='Spouse Invited']//*[@alt='No Profile Photo']");
			yesButtonLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains(text(), 'Yes')]");

			return new WebMyProfilePage(browser);
		}
		return null;
	}

	public EditMyProfilePage verifyProfileUploaded() {
		// TODO Auto-generated method stub
		return null;
	}
}