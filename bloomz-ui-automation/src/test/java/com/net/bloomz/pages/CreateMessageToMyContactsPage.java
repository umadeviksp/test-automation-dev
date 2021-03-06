package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateMessageToMyContactsPage;
import com.net.bloomz.pages.interfaces.CreateMessageToMyContactsPageActions;
import com.net.bloomz.pages.web.WebCreateMessageToMyContactsPage;



public class CreateMessageToMyContactsPage extends BasePage implements CreateMessageToMyContactsPageActions {
	
	static By toButtonLocator;
	static By doneButtonLocator;
	static By toFirstContactLocator;
	static By toSecondContactLocator;
	static By myContactsButtonLocator;
	static By classesButtonLocator;
	static By toFirstClassLocator;
	static By toSelectAllClassLocator;

	public CreateMessageToMyContactsPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateMessageToMyContactsPage clickOnToFirstContact() {
		click(toFirstContactLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	
	public CreateMessageToMyContactsPage clickOnMultipleContacts() {
		click(toFirstContactLocator);
		click(toSecondContactLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	
	public CreateMessageToMyContactsPage clickOnMyContacts() {
		click(myContactsButtonLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	
	public CreateMessageToMyContactsPage clickOnMyClasses() {
		click(classesButtonLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}

	public CreateMessageToMyContactsPage clickOnToFirstClass() {
		click(toFirstClassLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}

	public CreateMessageToMyContactsPage clickOnSelectAllClasses() {
		click(toSelectAllClassLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	
	public CreateMessagePage clickOnMessageDone() {
		click(doneButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	
	public static CreateMessageToMyContactsPage getCreateMessageToMyContactsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
//			myContactsButtonLocator = By.xpath("");

			doneButtonLocator = By.xpath("net.bloomz:id/DoneBtn");
			
			toFirstContactLocator 	= By.xpath("//android.widget.TextView[@text = 'sample1']");
			toSecondContactLocator 	= By.xpath("//android.widget.TextView[@text = 'test class 3']");
			toFirstClassLocator 	= By.xpath("//android.widget.TextView[@text = 'sample1']");
//			toSelectAllClassLocator = By.xpath("//android.widget.TextView[@text = '']");
			
			return new AndroidCreateMessageToMyContactsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {

			toButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/nav[1]/ul/li/div");
			myContactsButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/nav[1]/div/ul/li[1]/a");
			//toFirstContactLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div[2]/section[1]/div/h2/a/span");
			//toFirstContactLocator = By.xpath("//*[@id='sendMessage']//*[contains(text(), 'Parent of testchild1 and testchild2')]");
			toFirstContactLocator = By.xpath("//*[@id='sendMessage']//span[@data-displayname='sample@sample.com']");
			toSecondContactLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div[2]/section[2]/div/h2/a/span");
			classesButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/nav[1]/div/ul/li[2]/a");
			doneButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/nav[1]/a");
			toFirstClassLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div/section[1]/div/h2/button/span[2]");
			toSelectAllClassLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div/span");
			
			return new WebCreateMessageToMyContactsPage(browser);
		}
		return null;
	}

}
