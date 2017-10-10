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
	static By toFieldLocator;
	static By toClassFieldLocator;
	static By doneButtonLocator;
	static By alertTitleLocator;
	static By alertIndicatorLocator;
	static By optionsButtonLocator;
	static By deletePostButonLocator;
	

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
	
	public HomePage clickOnPostButton() {
		System.out.println("Click on Post");
		click(postButtonLocator);
		System.out.println("Clicked on Post");
		refreshWebPage();
		return HomePage.getHomePage(browser);
	}
	
	
	
	public CreateAlertInClassPage clickOnToFieldLocator() {
		click(toFieldLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage clickOnToClassFieldLocator() {
		click(toClassFieldLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage clickOnDoneLocator() {
		click(doneButtonLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}

	public CreateAlertInClassPage readAlertEventTitle(String sText) {
		System.out.println(getText(alertTitleLocator));
		Assert.assertEquals(getText(alertTitleLocator), sText);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage thenVerifyAlertMessgae() {
		System.out.println(getText(alertIndicatorLocator));
		Assert.assertEquals(getText(alertIndicatorLocator), "Alert");
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public CreateAlertInClassPage clickOnOptionsLocator() {
		click(optionsButtonLocator);
		return CreateAlertInClassPage.getCreateAlertInClassPage(browser);
	}
	
	public HomePage clickOnDeletePostLocator() {
		click(deletePostButonLocator);
		return HomePage.getHomePage(browser);
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
			toFieldLocator = By.xpath("//*[@id=\"addPost\"]/div/div[1]/form/section[1]/div");
			toClassFieldLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/ul/li/div");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			//alertTitleLocator = By.xpath("//*[@id='postViewControl']/div[1]/div/div/article/p/span[2]");
			alertTitleLocator = By.xpath("//*[@id='postViewControl']//*[contains(text(),'test_alert_message')]");
			//alertIndicatorLocator = By.xpath("//*[@id='postViewControl']/div[1]/div/div/article/div[3]/span[1]");
			alertIndicatorLocator = By.xpath("//*[@id='postViewControl']//span[@class='tags tagUrgent']");
			optionsButtonLocator = By.xpath("//*[@id='postViewControl']/nav/ng-switch[3]/a");
			deletePostButonLocator = By.xpath("//*[@id='actionSheet_optionsDiv']/button[1]/span");
			return new WebCreateAlertInClassPage(browser);
		}
		return null;
	}

}
