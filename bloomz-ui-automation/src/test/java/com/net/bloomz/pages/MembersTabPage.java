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
			return new WebCreateMembersTabPage(browser);
		}
		return null;
	}

	public MembersTabPage thenVerifyElementExists() {
		Assert.assertTrue(getElementSize(searchMembersLocator) > 0, "Members Tab is not displayed");
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public MembersTabPage clickOnMembersManageButton() {
		click(membersManageButtonLocator);
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
	
}
