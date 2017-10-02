package com.net.bloomz.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidInvitationRecommendPage ;
import com.net.bloomz.pages.interfaces.InvitationRecommendPageActions;
import com.net.bloomz.pages.web.WebInvitationRecommendPage;

public class InvitationRecommendPage extends BasePage implements InvitationRecommendPageActions {

	static By doneButtonLocator = null;
	static By backButtonLocator = null;
	static By emailButtonLocator = null;
	static By blogLinkButtonLocator = null;
	static By blogLinkLocator = null;
	static By blogLinkCopyButtonLocator = null;

	public InvitationRecommendPage(Browser<?> browser) {
		super(browser);

	}
	
	public HomePage clickOnDoneButton() {
		click(doneButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public InvitationGroupPage clickOnGoBackButton() {
		click(backButtonLocator);
		return  InvitationGroupPage.getInvitationGroupPage(browser);
	}
	
	public InvitationRecommendPage clickOnEmailButton() {
		click(emailButtonLocator);
		return this ;
	}
	
	public InvitationRecommendPage clickOnBlogLinkButton() {
		click(blogLinkButtonLocator);
		return this ;
	}
	public String getBlogLink() {
		String str= browser.getActions().getElement(blogLinkLocator).getAttribute("value") ;
		System.out.println(str) ;
		return str ;
	}
	
	public InvitationRecommendPage clickOnBlogLinkCopyButton() {
		String data = null;
		click(blogLinkCopyButtonLocator);
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
			getBlogLink() ;
		} catch (Exception e) {
            e.printStackTrace();
		}
		System.out.println(data) ;
		click(blogLinkCopyButtonLocator);
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
			getBlogLink() ;
		} catch (Exception e) {
            e.printStackTrace();
		}
		System.out.println(data) ;
		click(blogLinkCopyButtonLocator);
		try {
			data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
			getBlogLink() ;
		} catch (Exception e) {
            e.printStackTrace();
		}
		System.out.println(data) ;
		
		return this ;
	}
	
	public InvitationRecommendPage testFunc1()	{
		
		String sURL = "https://app-staging.bloomz.net/api/admin/updateuser?email=pop@pop.pop&action=getDetails"; //just a string
		String myStr ;
		
		try {
			// Connect to the URL using java's native library
			URL url = new URL(sURL);
			HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); //from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
			myStr = rootobj.get("primaryemail").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("createdtime").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("invitationcode").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("userregistrationstatus").getAsString(); //just grab the text
			System.out.println(myStr);
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return this ;		
	}
	
	
	
	public static InvitationRecommendPage getInvitationRecommendPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			backButtonLocator 	= By.xpath("//div[@id='recommendPicker']//a[@class='backButtonOnly']");
			doneButtonLocator 	= By.xpath("//div[@id='recommendPicker']//a[@class='nextButton']");
			
			emailButtonLocator 			= By.xpath("//div[@id='recommendPicker']//section[contains(@class,'recommendEmail')]");
			blogLinkButtonLocator 		= By.xpath("//div[@id='recommendPicker']//button[contains(@class,'recommendBlogs')]");
			blogLinkCopyButtonLocator 	= By.xpath("//div[@id='recommendPicker']//button[contains(@class,'getLinkButton')]");

			return new AndroidInvitationRecommendPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			backButtonLocator 	= By.xpath("//div[@id='recommendPicker']//a[@class='backButtonOnly']");
			doneButtonLocator 	= By.xpath("//div[@id='recommendPicker']//a[@class='nextButton']");

			emailButtonLocator 			= By.xpath("//div[@id='recommendPicker']//section[contains(@class,'recommendEmail')]");
			blogLinkButtonLocator 		= By.xpath("//div[@id='recommendPicker']//section[contains(@class,'recommendBlogs')]");
			blogLinkLocator 		= By.xpath("//div[@id='recommendPicker']//div[@class='recommendUrlCopy']//input");
			blogLinkCopyButtonLocator 	= By.xpath("//div[@id='recommendPicker']//button[contains(@class,'getLinkButton')]");

			return new WebInvitationRecommendPage(browser);
		}
		return null;
	}
}