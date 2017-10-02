package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidClassAccessCodePage ;
import com.net.bloomz.pages.interfaces.ClassAccessCodePageActions;
import com.net.bloomz.pages.web.WebClassAccessCodePage;

public class ClassAccessCodePage extends BasePage implements ClassAccessCodePageActions {

	static By doneButtonLocator = null;
	static By backButtonLocator = null;

	static By enableDisableAccessCodeButtonLocator = null;
	static By manualApprovalButtonLocator = null;

	static By classCodeTextLocator = null;
	static By resetClassCodeButtonLocator = null;
	static By cancelButtonLocator = null ;

	public ClassAccessCodePage(Browser<?> browser) {
		super(browser);

	}
	
	public InvitationModePage clickOnGoBackButton() {
		click(backButtonLocator);
		return  InvitationModePage.getInvitationModePage(browser);
	}

	public HomePage clickOnDoneButton() {
		click(doneButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public ClassAccessCodePage clickOnEnableDisableAccessCodeButton() {
		click(enableDisableAccessCodeButtonLocator);
		return this ;
	}

	public ClassAccessCodePage clickOnManualApprovalButton() {
		click(manualApprovalButtonLocator);
		return this ;
	}
	
	public ClassAccessCodePage clickOnResetClassCodeButton() {
		click(resetClassCodeButtonLocator);
		return this ;
	}
	
	public ClassAccessCodePage clickOnCancelButton() {
		click(cancelButtonLocator);
		return this ;
	}
	
	public static ClassAccessCodePage getClassAccessCodePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			doneButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			backButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidClassAccessCodePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			backButtonLocator = By.xpath("//div[@id='inviteByGroupCode']//a[@class='backButtonOnly']");
			doneButtonLocator = By.xpath("//div[@id='inviteByGroupCode']//a[@class='nextButton']");

			enableDisableAccessCodeButtonLocator = By.xpath("//div[@id='inviteByGroupCode']//label[@for='enableClassCode']/parent::node()//div[contains(@class,'switchControl')]") ;
			manualApprovalButtonLocator = By.xpath("//div[@id='inviteByGroupCode']//label[@for='manuallyApproveJoinRequest']/parent::node()//div[contains(@class,'switchControl')]") ;

			classCodeTextLocator = By.xpath("//div[@id='inviteByGroupCode']//section[contains(@class,'inviteToTryBloomz')]");
			resetClassCodeButtonLocator  = By.xpath("//div[@id='inviteByGroupCode']//a[@class='refreshGroupAccessCode']");
			cancelButtonLocator = By.xpath("//div[@id='_modalWindow']//button[text()='Cancel']") ;
			return new WebClassAccessCodePage(browser);
		}
		return null;
	}
}