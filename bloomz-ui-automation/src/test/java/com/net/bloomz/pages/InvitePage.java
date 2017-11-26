package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidLandingPage;
import com.net.bloomz.pages.interfaces.InvitePageActions;
import com.net.bloomz.pages.interfaces.LandingPageActions;
import com.net.bloomz.pages.web.WebInvitePage;
import com.net.bloomz.pages.web.WebLandingPage;

public class InvitePage extends BasePage implements InvitePageActions {
	
	static By inviteCodeTextLocator;
	static By inviteNextButtonLocator;
	static By nextButtonLocator;
	static By firstNameTextLocator;
	static By lastNameTextLocator;
	static By emailTextLocator;
	static By passwordTextLocator;
	static By addYourChildLocator;
	static By testChildNameLocator;
	static By joinClassLocator;
	static By emailVerifyTextLocator;
	static By verifyTextLocator;
	static By childFirstNameLocator;
	static By addClassButtonLocator;
	static By addChildFNameLocator;
	static By addChildLNameLocator;
	static By classNameTextLocator;
	static By gmailButtonLocator;
	static By continueButtonLocator;

	public InvitePage(Browser<?> browser) {
		super(browser);
	}
	
	public InvitePage enterInvitationCode(String sCode) {
		sendText(inviteCodeTextLocator, sCode);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage clickInviteNext() {
		click(inviteNextButtonLocator);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage enterFirstName(String sFName) {
		sendText(firstNameTextLocator, sFName);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage enterLastName(String sLName) {
		sendText(lastNameTextLocator, sLName);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage enterEmailID(String sEmail) {
		sendText(emailTextLocator, sEmail);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage enterPassword(String sPWord) {
		sendText(passwordTextLocator, sPWord);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage clickOnNext() {
		click(nextButtonLocator);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage clickOnJoinAClassGroup() {
		click(nextButtonLocator);
		return InvitePage.getInvitePage(browser); 
	}
	

	public InvitePage selectAddYourChild() {
		click(addYourChildLocator);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage selectTestChildName() {
		click(testChildNameLocator);
		return InvitePage.getInvitePage(browser); 
	}

	
	public InvitePage clickOnJoinClass() {
		click(joinClassLocator);
		return InvitePage.getInvitePage(browser); 
	}
	
	public InvitePage thenVerifyJoinClass(String sEmail, String sText) {
		Assert.assertEquals(getText(emailVerifyTextLocator), sEmail);
		Assert.assertEquals(getText(verifyTextLocator), sText);
		return InvitePage.getInvitePage(browser);
	}
	
	public InvitePage thenVerifyLastName(String sLName) {
		Assert.assertEquals(getText(addChildLNameLocator), sLName);
		return InvitePage.getInvitePage(browser);
	}
	
	public InvitePage enterChildFirstName(String sName) {
		sendText(childFirstNameLocator, sName);
		return InvitePage.getInvitePage(browser); 
	}
	
	
	public InvitePage addChildFirstName(String sName) {
		sendText(addChildFNameLocator, sName);
		return InvitePage.getInvitePage(browser); 
	}
	
	
	public InvitePage clickOnAddClass() {
		click(addClassButtonLocator);
		return InvitePage.getInvitePage(browser); 
	}
	
	
	public InvitePage selectAnyOneClass() {
		click(classNameTextLocator);
		return InvitePage.getInvitePage(browser);
	}
	
	
	

	public static InvitePage getInvitePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return null; // TO DO FIX THIS
		} else if (string.equals(".iOS")) {
			
		} else {
			inviteCodeTextLocator = By.xpath("//*[@id='accessCodeEnter']/div/div/section/div/p/input");
			inviteNextButtonLocator = By.xpath("//*[@id='accessCodeEnter']/div/div/section/div/p/button");
			nextButtonLocator = By.xpath("//*[@ng-click='next(signup)']");
			firstNameTextLocator = By.xpath("//*[@id=\"signup_firstName\"]");
			lastNameTextLocator = By.xpath("//*[@id=\"signup_lastName\"]");
			emailTextLocator = By.xpath("//*[@id=\"signup_email\"]");
			passwordTextLocator = By.xpath("//*[@id=\"signupGroupCode_password\"]");
			addYourChildLocator = By.xpath("//*[@id='signUpScreenChildren']//label[@for='anotherChildFromMyList']");
			//testChildNameLocator = By.xpath("//*[@id='signUpScreenChildren']//label[@for='testChild1_0']");
			testChildNameLocator = By.xpath("//*[@id='signUpScreenChildren']//label[@for='test student_0']");
			joinClassLocator = By.xpath("//*[@id='signUpScreenChildren']/div/div/form/footer/button");
			emailVerifyTextLocator = By.xpath("//*[@id='_verifyUserIdentity']/div/div/div/section/section/div[1]/div/span[1]");
			verifyTextLocator = By.xpath("//*[@id='_verifyUserIdentity']/div/div/div/section/section/div[1]/div/span[2]");
			childFirstNameLocator = By.xpath("//*[@id='contentDiv']//input[@ng-model='params.child.firstName']");
			addClassButtonLocator = By.xpath("//*[@id='contentDiv']//button[@class='ng-binding']");
			addChildFNameLocator = By.xpath("//*[@name = 'Child_Information']//input[@ng-model = 'child.firstName']");
			addChildLNameLocator = By.xpath("//*[@name = 'Child_Information']//input[@ng-model = 'child.lastName']");
			classNameTextLocator = By.xpath("//*[@ng-bind=\"groupEntry.displayName\"]");

		
			return new WebInvitePage(browser);
		}
		return null;
	}


}
