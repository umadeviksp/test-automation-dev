package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ExampleTemplatePageActions;
import com.net.bloomz.pages.web.WebExampleTemplatePage;

public class ExampleTemplatePage extends BasePage implements ExampleTemplatePageActions {
	
	// declare By variables here

	public ExampleTemplatePage(Browser<?> browser) {
		super(browser);
	}

	public static ExampleTemplatePage getExampleTemplatePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			return new WebExampleTemplatePage(browser);
		}
		return null;
	}

}
