package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidDeleteAccountPage;
import com.net.bloomz.pages.interfaces.DeleteAccountPageActions;
import com.net.bloomz.pages.web.WebDeleteAccountPage;

public class DeleteAccountPage extends MyProfilePage implements DeleteAccountPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By selectReasonButtonLocator = null;
	static By otherButtonLocator = null;
	static By backButtonLocator = null;
	static By passwordButtonLocator = null;
	static By deletePermanentButtonLocator = null;
	static By yesButtonLocator = null;
	static By confirmMessageLocator = null;
	static By confirmOKLocator = null;
	
	public DeleteAccountPage(Browser<?> browser) {
		super(browser);
	}

	public DeleteAccountPage selectReasonForDeleteButton() {
		click(selectReasonButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}

	public DeleteAccountPage selectReasonAsOthersButton() {
		click(otherButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public DeleteAccountPage clickOnBackButton() {
		click(backButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public DeleteAccountPage enterPassword() {
		sendText(passwordButtonLocator, "bloomz999");
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public DeleteAccountPage clickDeletePermanentButton() {
		click(deletePermanentButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public DeleteAccountPage clickOnYesButton() {
		click(yesButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public DeleteAccountPage thenVerifyConfirmMessage() {
		Assert.assertEquals(getText(confirmMessageLocator), "Your request is now completed. To create a new account with Bloomz, please click here.");
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}
	
	public LandingPage clickOnOkButton() {
		click(confirmOKLocator);
		return LandingPage.getLandingPage(browser);
	}

	public static DeleteAccountPage getDeleteAccountPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		MyProfilePage.getMyProfilePage(browser) ;
		if (string.contains("AndroidMobile")) {
		
			return new AndroidDeleteAccountPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
						
			selectReasonButtonLocator = By.xpath("//*[@id='accountDelete']//*[contains(text(),'Please select the reason')]");
			otherButtonLocator = By.xpath("//*[@id='accountDelete']//*[contains(text(),'Other')]");
			backButtonLocator = By.xpath("//*[@id='accountDelete']//*[@class='backButtonOnly']");
			passwordButtonLocator = By.xpath("//*[@id='deleteAccountForm_password']");
			deletePermanentButtonLocator = By.xpath("//*[@id='accountDelete']//*[contains(text(),'Delete Permanently')]");
			yesButtonLocator = By.xpath("//*[@id='contentDiv']//*[contains(text(),'Yes')]");
			confirmMessageLocator = By.xpath("//*[@id='contentDiv']//*[contains(text(),'Your request is now completed. To create a new account with Bloomz, please')]");
			confirmOKLocator = By.xpath("//*[@id='contentDiv']//*[contains(text(),'Ok')]");
			return new WebDeleteAccountPage(browser);
		}
		return null;
	}

}
