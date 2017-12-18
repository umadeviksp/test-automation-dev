package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateMessagePage;
import com.net.bloomz.pages.interfaces.CreateMessagePageActions;
import com.net.bloomz.pages.web.WebCreateMessagePage;


public class CreateMessagePage extends BasePage implements CreateMessagePageActions {
	
	static By toRecipientFieldLocator;
	static By messageTextFieldLocator;
	static By sendButtonLocator;
	static By messagesTextLocator;
	static By firstMessageInTrayLocator;
	static By lastMessageInTrayLocator;
	static By backButtonLocator;
	static By lastMessageSizeInTrayLocator;
	static By optionsButtonLocator;
	static By deleteMessageButtonLocator;
	static By replyAllButtonLocator;
	static By firstClassLocator;
	static By sendToEveryoneButtonLocator;

	public CreateMessagePage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateMessageToMyContactsPage clickOnMessageToField() {
		click(toRecipientFieldLocator);
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	
	public CreateMessagePage inputOnMessageField(String sText) {		
		sendText(messageTextFieldLocator, sText);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public CreateMessagePage clickOnSendButton() {
		click(sendButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public CreateMessagePage clickOnReplyAllButton() {
		click(replyAllButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public CreateMessagePage thenVerifyMessages(String sText, By messageLocator) {
		Assert.assertEquals(getText(messageLocator),sText);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public HomePage clickOnBackButton() {
		click(backButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public By getLastMessageLocator() {
		return lastMessageInTrayLocator ;
	}
	
	public By getFirstMessageLocator() {
		return firstMessageInTrayLocator ;
	}
	
	public CreateMessagePage clickOnOptionsButton() {
		click(optionsButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public CreateMessagePage clickOnDeleteMessageButton() {
		click(deleteMessageButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public HomePage clickOnDeleteButton() {
		click(deleteMessageButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public CreateMessagePage clickOnSendToEveryoneButton() {
		click(sendToEveryoneButtonLocator);
		return CreateMessagePage.getCreateMessagePage(browser);
	}
	
	public static CreateMessagePage getCreateMessagePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			toRecipientFieldLocator = By.id("net.bloomz:id/llAdd");
			messageTextFieldLocator = By.id("net.bloomz:id/txtEnterMsg");
			sendButtonLocator 		= By.id("net.bloomz:id/sendbtn");
			backButtonLocator 		= By.id("net.bloomz:id/backarrow");
						
			optionsButtonLocator 	= By.id("net.bloomz:id/txtOptions");
			deleteMessageButtonLocator = By.id("net.bloomz:id/txtRemoveProfilePic");

			return new AndroidCreateMessagePage(browser);

		} else if (string.equals(".iOS")) {
			
		} else {
			//toRecipientFieldLocator = By.xpath("//*[@id=\"recipientHeader\"]/ul/li/div/div");
			toRecipientFieldLocator = By.xpath("//*[@id='recipientHeader']//*[contains(text(), 'Select a recipient')]");
			messageTextFieldLocator = By.className("sendMessage_messageText_content");
			sendButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div/div[2]/div/form/div[2]/button");
			messagesTextLocator = By.xpath("//*[@ng-class=\"{time: entry.type && entry.type == 'header'}\"]");
			replyAllButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div/div[3]/div/form/div[2]/button");
			
			firstMessageInTrayLocator = By.xpath("//*[@ng-class=\"{groupChat: isMessageToGroup() || isQuietHours(), quietHoursMessageBackground: isQuietHours()}\"]/div[1]/div/div/span[2]/span");
			lastMessageInTrayLocator = By.xpath("//*[@ng-class=\"{groupChat: isMessageToGroup() || isQuietHours(), quietHoursMessageBackground: isQuietHours()}\"]/div[2]/div/div/span[2]/span");
			optionsButtonLocator = By.xpath("//*[@id=\"sendMessage\"]/div/nav/a[2]");
			backButtonLocator = By.className("backButtonOnly");
			deleteMessageButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			sendToEveryoneButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
					
			
			/*firstClassLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div/section[1]/div/h2/button/span[2]");
			selectAllLocator = By.xpath("//*[@id=\"sendMessage\"]/div/div[1]/div/section/div/span");
			*/
						
			return new WebCreateMessagePage(browser);
		}
		return null;
	}
	

}
