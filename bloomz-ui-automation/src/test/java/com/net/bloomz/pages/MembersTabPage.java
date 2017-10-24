package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMembersTabPage;
import com.net.bloomz.pages.interfaces.CreateMembersTabPageActions;
import com.net.bloomz.pages.web.WebCreateMembersTabPage;

public class MembersTabPage extends BasePage {

	static By searchMembersLocator;
	static By membersManageButtonLocator;
	static By membersGeneralTabLocator;
	static By deleteClassLocator;
	static By deleteClassConfirmLocator;
	static By addMembersIconLocator;
	static By membersButtonLocator;
	static By memberEmailTextLocator;
	static By removeMemberButtonLocator;
	static By confirmRemoveButtonLocator;
	static By successEventMessageLocator;
	static By doneButtonLocator;
	static By searchMembersEmailLocator;
	static By editRoleButtonLocator;
	static By roomParentTextLocator;
	static By inviteMembersTextLocator;
	static By selectAllLocator;
	
	public MembersTabPage(Browser<?> browser) {
		super(browser);
	}

	public static MembersTabPage getMembersTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			searchMembersLocator = By.id("net.bloomz:id/llMainView");
			return new AndroidMembersTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			searchMembersLocator = By.xpath("//*[@id='communityContent']/span/div/div/div[1]/nav/ul/li/div/input");
			membersManageButtonLocator = By.xpath("//*[@id=\"communityContent\"]/span/div/div/div[2]/section/div[2]/div/div");
			membersGeneralTabLocator = By.xpath("//*[@id='orgSettings']/div/div[1]/section/div/ul/li[1]/a");
			deleteClassLocator = By.xpath("//*[@id='communitySettings_deleteGroup']");
			deleteClassConfirmLocator = By.xpath("//*[@id='actionSheet_optionsDiv']/button[1]/span");
			addMembersIconLocator = By.xpath("//*[@id=\"communityContent\"]//button[@class=\"addMember ng-scope\"]");
			membersButtonLocator = By.xpath("//*[@id='orgSettings']//*[contains(text(), 'Members')]");
			memberEmailTextLocator = By.xpath("//*[@id='orgSettings']//*[@ng-click='memberToggleStatus(member)']");
			removeMemberButtonLocator = By.xpath("//*[@id='orgSettings']//*[@data-abbrtext='Remove']");
			confirmRemoveButtonLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains(text(), 'Confirm')]");
			successEventMessageLocator = By.id("toast");
			doneButtonLocator = By.xpath("//*[@id='orgSettings']//*[contains(text(), 'Done')]");
			searchMembersEmailLocator = By.xpath("//*[@id='orgSettings']//*[@ng-model='searchString']");
			editRoleButtonLocator = By.xpath("//*[@id='orgSettings']//*[@data-abbrtext='Edit Role']");
			roomParentTextLocator = By.xpath("//*[@id='orgSettings']//span[contains(text(), 'Room Parents (1)')]");
			inviteMembersTextLocator = By.xpath("//*[@id='communityContent']//*[contains(text(), 'Invited (20)')]");
			selectAllLocator = By.xpath("//*[@id='orgSettings']//*[contains(text(), 'Select All')]");
			return new WebCreateMembersTabPage(browser);
		}
		return null;
	}

	public MembersTabPage thenVerifyElementExists() {
		Assert.assertTrue(getElementSize(searchMembersLocator) > 0, "Members Tab is not displayed");
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage thenVerifyRoomParentExists() {
		Assert.assertTrue(getElementSize(roomParentTextLocator) == 1, "Room Parent exists");
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnMembersManageButton() {
		click(membersManageButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnMembersButton() {
		click(membersButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}

	public MembersTabPage enterEmailSearchMembers(String sEmail) {
		sendText(searchMembersEmailLocator,sEmail);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage selectMembersEmailId() {
		click(memberEmailTextLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnRemoveMembersEmailId() {
		click(removeMemberButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnConfirmRemoveEmailId() {
		click(confirmRemoveButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnEditRole() {
		click(editRoleButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnDoneButton() {
		click(doneButtonLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnMembersGeneralTab() {
		click(membersGeneralTabLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnDeleteClass() {
		click(deleteClassLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnDeleteClassConfirm() {
		click(deleteClassConfirmLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public InvitationGroupPage clickOnAddMembers() {
		click(addMembersIconLocator);
		return InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public MembersTabPage thenVerifyTheToastMessage(String sText) {
		//System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	
	public MembersTabPage thenVerifyTheInviteMembers(String sText) {
		System.out.println(getText(inviteMembersTextLocator));
		Assert.assertEquals(getText(inviteMembersTextLocator), sText);
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnSelectAll() {
		click(selectAllLocator);
		return MembersTabPage.getMembersTabPage(browser);
	}
}
