package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateClassPage;
import com.net.bloomz.pages.interfaces.CreateClassPageActions;
import com.net.bloomz.pages.interfaces.ExampleTemplatePageActions;
import com.net.bloomz.pages.web.WebCreateClassPage;
import com.net.bloomz.pages.web.WebExampleTemplatePage;

public class CreateClassPage extends BasePage implements CreateClassPageActions {
	
	static By chooseSchoolButtonLocator;
	static By saveButtonLocator;
	static By classNameEditTextLocator;
	static By roomParentButtonLocator;
	//static By schoolPickLocator;
	//static By schoolTextLocator;
	static By behaviorManagementLocator;

	public CreateClassPage(Browser<?> browser) {
		super(browser);
	}

	public static CreateClassPage getCreateClassPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {

			chooseSchoolButtonLocator 	= By.id("net.bloomz:id/lnrAssociate");
			saveButtonLocator 			= By.id("net.bloomz:id/btnDone");
			classNameEditTextLocator 	= By.id("net.bloomz:id/editName");			
			roomParentButtonLocator  	= By.xpath("//android.widget.RadioButton[@text='I\'m a Room Parent']");
			
			return new AndroidCreateClassPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			//chooseSchoolButtonLocator = By.xpath("//*[@id=\"createGroup\"]/div/div/form/div[2]/section[1]/section");
			chooseSchoolButtonLocator = By.xpath("//*[@id='createGroup']//span[@class='linkControl drillDown']");
			saveButtonLocator = By.xpath("//*[@id=\"createGroup\"]/div/nav/ng-switch[3]/a");
			classNameEditTextLocator = By.id("groupName");			
			//roomParentButtonLocator  =By.xpath("//*[@id=\"createGroup\"]/div/div/form/div[2]/div[3]/section/div/div[2]");
			roomParentButtonLocator  =By.xpath("//*[@id='createGroup']//div[@class='highlightableRow ng-scope ng-binding']");
			//schoolTextLocator = By.xpath("//*[@id='pickLocationId']lickOnchooseSchoolButtonLocator");
			//schoolPickLocator = By.xpath("//*[@id='activityTypes']/div/div/form/section/div/section/section[1]/span/h2");
			//behaviorManagementLocator = By.xpath("//*[@id='createGroup']//*[@id='behaviorEnabled']");
			behaviorManagementLocator = By.xpath("//*[@id='createGroup']/div/div/form/div[3]/div/section[1]/div/label");
			return new WebCreateClassPage(browser);
		}
		return null;
	}

	public SchoolLocationPage clickOnchooseSchoolButtonLocator() {
		click(chooseSchoolButtonLocator);
		return SchoolLocationPage.getSchoolLocationPage(browser);	
	}
	
	
	public CreateClassPage enterClassName(String fName) {
		sendText(classNameEditTextLocator, fName);
		return CreateClassPage.getCreateClassPage(browser);
	}
	
	public CreateClassPage clickRoomParentButton() {
		click(roomParentButtonLocator);
		return CreateClassPage.getCreateClassPage(browser);
	}
	
	public CreateClassPage clickBehaviorManagementButton() {
		click(behaviorManagementLocator);
		return CreateClassPage.getCreateClassPage(browser);
	}
	
	public HomePage clickOnSaveButtonLocator() {
		click(saveButtonLocator);
		return HomePage.getHomePage(browser);
	}
}