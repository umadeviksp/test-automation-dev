package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreateAlertInClassPageActions;
import com.net.bloomz.pages.web.WebCreateAlertInClassPage;

public class CreateAlertInClassPage extends BasePage implements CreateAlertInClassPageActions {
	
	static By continueCreateAlertButtonLocator;
	static By titleFieldLocator;
	static By generalUpdateFieldLocator;
	static By postButtonLocator;

	public CreateAlertInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateAlertInClassPage clickOnContinueCreateAlertButton() {
		click(continueCreateAlertButtonLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage enterTitle(String title) {
		sendText(titleFieldLocator, title);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage enterGeneralUpdate(String updateText) {
		sendText(generalUpdateFieldLocator, updateText);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage clickOnPostButton() {
		click(postButtonLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}

	public static CreateAlertInClassPage getCreateAlertInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			continueCreateAlertButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]");
			titleFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/div[1]/input");
			generalUpdateFieldLocator = By.xpath("//*[@id=\"addPost_postData\"]");
			postButtonLocator = By.xpath("//*[@id=\"addPost\"]/div/nav[1]/a[2]");
			return new WebCreateAlertInClassPage(browser);
		}
		return null;
	}

}
