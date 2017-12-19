package com.net.bloomz.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidInvitationGroupPage ;
import com.net.bloomz.pages.interfaces.InvitationGroupPageActions;
import com.net.bloomz.pages.web.WebInvitationGroupPage;

public class InvitationGroupPage extends BasePage implements InvitationGroupPageActions {

	static By yesButtonLocator = null;
	static By backButtonLocator = null;

	static By inviteCommunitySectionLocator = null;
	static By inviteClassSectionLocator = null;

	static By inviteTryBloomzButtonLocator = null;
	static By inviteSpouseButtonLocator = null;
	static By invitePersonalConnectionButtonLocator = null;
	static By classNameTextLocator;
	static By parentRoleTextLocator;
	static By typeEmailsManuallyTextLocator;
	static By emailIdTextBoxLocator;
	static By emailSendButtonLocator;
	static By smartInviteButtonLocator;
	static By gmailButtonLocator;
	static By continueButtonLocator;
	static By inviteMembersSectionLocator;
	static By teacherRoleTextLocator;
	static By inviteSpouseEmailTextLocator;
	static By doneButtonLocator;
	static By cancelButtonLocator;
	static By successEventMessageLocator;
	static By classAdminRoleTextLocator;
	static By roomParentRoleTextLocator;
	static By emailTextLocator;
	
	public InvitationGroupPage(Browser<?> browser) {
		super(browser);

	}

	
	public HomePage clickOnGoBackButton() {
		click(backButtonLocator);
		return  HomePage.getHomePage(browser);
	}

	public InvitationRolePage clickOnInviteCommunityButton() {
		click(inviteCommunitySectionLocator);
		return  InvitationRolePage.getInvitationRolePage(browser);
	}

	public InvitationRolePage clickOnInviteClassButton() {
		click(inviteClassSectionLocator);
		return  InvitationRolePage.getInvitationRolePage(browser);
	}
	
	public InvitationRecommendPage clickOnTryBloomzButton() {
		click(inviteTryBloomzButtonLocator);
		return  InvitationRecommendPage.getInvitationRecommendPage(browser);
	}
	
//	public HomePage clickOnInviteSpouseButton() {
//		click(inviteSpouseButtonLocator);
//		return  HomePage.getHomePage(browser);
//	}
	
	public InvitationGroupPage clickOnInviteSpouseButton() {
		click(inviteSpouseButtonLocator);
	return  InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationPersonalConnectionPage clickOnInvitePersonalConnectionButton() {
		click(invitePersonalConnectionButtonLocator);
		return  InvitationPersonalConnectionPage.getInvitationPersonalConnectionPage(browser);
	}
	
	public InvitationGroupPage selectAnyOneClass() {
		click(classNameTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage selectParentRole() {
		click(parentRoleTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage selectTeacherRole() {
		click(teacherRoleTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage selectClassAdminRole() {
		click(classAdminRoleTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage selectRoomParentRole() {
		click(roomParentRoleTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage selectEmailsManually() {
		click(typeEmailsManuallyTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage clickEmailId() {
		click(emailTextLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage enterEmailId(String emailId) {
		sendText(emailIdTextBoxLocator, emailId);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage copyPaste(String sEmail) throws InterruptedException, IOException {
		UploadFileAutoIT(sEmail);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public HomePage clickOnEmailSendButton() {
		click(emailSendButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public InvitationGroupPage selectSmartInviteUseGmail() {
		click(smartInviteButtonLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage clickOnGmailOption() {
		click(gmailButtonLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}

	public InvitationGroupPage clickOnContinue() {
		click(continueButtonLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
		
	}
		
	public InvitationGroupPage clickOnInviteMembers() {
		click(inviteMembersSectionLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
		
	}	

	public InvitationGroupPage enterInviteSpouseEmail(String sEmail) {
		sendText(inviteSpouseEmailTextLocator,sEmail);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationGroupPage clickOnDoneButton() {
		click(doneButtonLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public HomePage clickOnCancelButton() {
		click(cancelButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public InvitationGroupPage thenVerifyTheToastMessage(String sText) {
		//System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	
	public static InvitationGroupPage getInvitationGroupPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {

			yesButtonLocator 				= By.id("net.bloomz:id/txtMyProfile");
			backButtonLocator 				= By.id("net.bloomz:id/txtCancel");
//			inviteMembersSectionLocator 	= By.id("net.bloomz:id/llInvite");
			inviteMembersSectionLocator 	= By.id("net.bloomz:id/txtAddMember");

			teacherRoleTextLocator 			= By.xpath("//android.widget.TextView[@text='Parent']") ;
			typeEmailsManuallyTextLocator 	= By.id("net.bloomz:id/llManually") ;
			emailIdTextBoxLocator 			= By.id("net.bloomz:id/searchView");
			emailSendButtonLocator 			= By.id("net.bloomz:id/inviteBtn");

			return new AndroidInvitationGroupPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			backButtonLocator = By.xpath("//div[@id='inviteToPicker']//a[contains(@class,'backButton')]");
			inviteCommunitySectionLocator 	= By.xpath("//div[@id='inviteToPicker']//label[@ng-bind='groups.title'][text()='Communities']/parent::node()//section");
			inviteClassSectionLocator	= By.xpath("//div[@id='inviteToPicker']//label[@ng-bind='groups.title'][text()='Classes']/parent::node()//section");

			inviteTryBloomzButtonLocator 	= By.xpath("//div[@id='inviteToPicker']//section[contains(@class,'inviteToTryBloomz')]");
			//inviteSpouseButtonLocator 	= By.xpath("//section[@id='userProfileView_myFamilyListing']//span[contains(@class,'profileM')]");
			inviteSpouseButtonLocator 	= By.xpath("//*[@id='inviteToPicker']//span[contains(text(), 'Invite Your Spouse')]");
			invitePersonalConnectionButtonLocator	= By.xpath("//div[@id='inviteToPicker']//section[contains(@ng-click,'invitePersonalConnections')]");
			//classNameTextLocator = By.xpath("//*[@ng-bind=\"groupEntry.displayName\"]");
			classNameTextLocator = By.xpath("//span[contains (text(),\"Alpha Class\") and @ng-bind=\"groupEntry.displayName\"]");
			parentRoleTextLocator = By
					.xpath("//*[@id=\"rolePicker\"]/div/div/section/section[1]/h2");
			typeEmailsManuallyTextLocator = By
					.xpath("//*[contains(text(),\"Type emails or phone numbers manually\")]");
			emailIdTextBoxLocator = By
					.id("addRecipientsEditableSpan_inviteTeachers");
			emailSendButtonLocator = By.xpath("//a[contains(text(),\"Send\")]");
			smartInviteButtonLocator = By.xpath("//*[contains(text(),\"Use your phone's email app or Gmail\")]");
			gmailButtonLocator = By.xpath("//*[@id=\"mailClients\"]//a[@class=\"clientGmail\"]");
			continueButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]//*[contains(text(),\"Continue\")]");
			inviteMembersSectionLocator = By.xpath("//*[@id=\"groupCreateOptions\"]//*[contains(text(),\"Invite people to join Alpha Class on Bloomz.\")]");
			teacherRoleTextLocator = By
					.xpath("//*[@id=\"rolePicker\"]//*[contains(text(),\"Teacher\")]"); 
			inviteSpouseEmailTextLocator = By.xpath("//*[@id='inviteSpouse_searchEmail']");
			doneButtonLocator = By.xpath("//*[@id='inviteSpouseSearch']//*[contains(text(),'Done')]");
			cancelButtonLocator = By.xpath("//*[@id='inviteToPicker']//*[contains(text(),'Cancel')]");
			successEventMessageLocator = By.id("toast");
			classAdminRoleTextLocator = By
					.xpath("//*[@id='rolePicker']//*[contains(text(),'Class Admin')]"); 
			roomParentRoleTextLocator = By
					.xpath("//*[@id='rolePicker']//*[contains(text(),'Room Parent')]"); 
			emailTextLocator = By.xpath("//*[@id='inviteTeachers']//*[contains(text(), 'To: Enter emails or US phone numbers...')]");
			
			return new WebInvitationGroupPage(browser);
		}
		return null;
	}
}