package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ExampleTemplatePageActions;
import com.net.bloomz.pages.interfaces.GroupPageActions;
import com.net.bloomz.pages.web.WebCreateAccountPage;
import com.net.bloomz.pages.web.WebExampleTemplatePage;
import com.net.bloomz.pages.web.WebGroupPage;

public class GroupPage extends BasePage implements GroupPageActions {
	
	static By createNewClassLocator;
	
	public GroupPage(Browser<?> browser) {
		super(browser);
	}

	public static GroupPage getGroupPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			return null; // TO DO FIX THIS
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createNewClassLocator = By.xpath("//*[@id=\"groupTypes\"]/div/div/div/section/div/div[1]/section[1]/div/h2/button/span[2]");
			return new WebGroupPage(browser);
		}
		return null;
	}
	
	
	public SignUpPage clickOnClassGroup() {
		click(createNewClassLocator);
		return SignUpPage.getSignUpPage(browser); 
	}

}