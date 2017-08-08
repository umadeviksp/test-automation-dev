package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreateClassPageActions;
import com.net.bloomz.pages.interfaces.ExampleTemplatePageActions;
import com.net.bloomz.pages.web.WebCreateClassPage;
import com.net.bloomz.pages.web.WebExampleTemplatePage;

public class CreateClassPage extends BasePage implements CreateClassPageActions {
	
	static By chooseSchoolButtonLocator;
	static By saveButtonLocator;
	static By classNameEditTextLocator;
	static By roomParentButtonLocator;

	public CreateClassPage(Browser<?> browser) {
		super(browser);
	}

	public static CreateClassPage getCreateClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			chooseSchoolButtonLocator = By.xpath("//*[@id=\"createGroup\"]/div/div/form/div[2]/section[1]/section");
			saveButtonLocator = By.xpath("//*[@id=\"createGroup\"]/div/nav/ng-switch[3]/a");
			classNameEditTextLocator = By.id("groupName");
			roomParentButtonLocator  =By.xpath("//*[@id=\"createGroup\"]/div/div/form/div[2]/div[3]/section/div/div[2]");
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
	
	public HomePage clickOnSaveButtonLocator() {
		click(saveButtonLocator);
		return HomePage.getHomePage(browser);
	}
}