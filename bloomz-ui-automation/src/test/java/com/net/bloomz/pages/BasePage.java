package com.net.bloomz.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.net.bloomz.appium.pagefactory.framework.actions.SeleniumActions;
import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutType;
import com.net.bloomz.appium.pagefactory.framework.pages.BaseTopLevelPage;










import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
//Uma added
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.net.ssl.HttpsURLConnection;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
@SuppressWarnings("unchecked")
public abstract class BasePage extends BaseTopLevelPage<SeleniumActions> {

	WebDriverWait driverWait;

	public Browser<?> browser;

	public BasePage(Browser<?> browser) {
		this.browser = browser;
	}

	/**
	 * Send text.
	 *
	 * @param locator
	 *            the locator
	 * @param text
	 *            the text
	 * @return the base page
	 */
	public BasePage sendText(By locator, String text) {

		waitForElement(locator);

		if (getPlatformName().equals("Android")) {
			click(locator);
		}
		browser.getActions().getElement(locator).clear();
		browser.getActions().inputText(locator, text);
		if (getPlatformName().equals("Android")) {
			System.out.println("Base Page : " + getPlatformName().equals("Android"));
			((AndroidDriver<?>) browser.getWebDriver()).hideKeyboard();
		}
		return this;

	}

	/**
	 * Click.
	 *
	 * @param locator
	 *            the locator
	 * @return the base page
	 */
	public BasePage click(By locator) {
		waitForElement(locator);
		if (getPlatformName().equals("")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		browser.getActions().getElement(locator).click();
		return this;
	}

	/**
	 * Click back.
	 *
	 * @return the base page
	 */
	public BasePage clickBack() {
		browser.getWebDriver().navigate().back();
		return this;

	}

	/**
	 * Gets the text.
	 *
	 * @param locator
	 *            the locator
	 * @return the text
	 */
	public String getText(By locator) {
		waitForElement(locator);
		return browser.getActions().getElement(locator).getText();
	}

	/**
	 
	 /**
	 * Get an attribute.
	 *
	 * @param locator
	 *            the locator
	 * @return the text
	 */
	public String getAttribute(By locator, String sAttribute) {
		waitForElement(locator);
		return browser.getActions().getElement(locator).getAttribute(sAttribute);
	}
	
	/**
	 * Wait for element.
	 *
	 * @param locator
	 *            the locator
	 * @return the web element
	 */
	public WebElement waitForElement(By locator) {
		return browser.getActions().waitOnExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator),
				locator + "is not present", TimeoutType.FORTY_SECONDS);
	}

	/**
	 * Swipe right.
	 *
	 * @param id
	 *            the id
	 * @param offset
	 *            the offset
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeRight(String id, int offset, int duration) {
		MobileElement element1 = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
		int offset1 = 1;
		Point p1 = element1.getCenter();
		Point location1 = element1.getLocation();
		Dimension size1 = element1.getSize();
		((AndroidDriver<?>) browser.getWebDriver()).swipe(location1.getX() + offset1 + offset, p1.getY(),
				location1.getX() + size1.getWidth() - offset1, p1.getY(), duration);
		return this;
	}

	/**
	 * Swipe left.
	 *
	 * @param id
	 *            the id
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeLeft(String id, int duration) {
		MobileElement element = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
		int offset = 1;
		Point p = element.getCenter();
		Point location = element.getLocation();
		Dimension size = element.getSize();
		((AndroidDriver<?>) browser.getWebDriver()).swipe(location.getX() + size.getWidth() - offset, p.getY(),
				location.getX() + offset, p.getY(), 1000);
		return this;
	}

	/**
	 * Swipe up.
	 *
	 * @param id
	 *            the id
	 * @param offsetFromStartBorder
	 *            the offset from start border
	 * @param offsetFromEndBorder
	 *            the offset from end border
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeUp(String id, int offsetFromStartBorder, int offsetFromEndBorder, int duration) {
		MobileElement element = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
		element.swipe(SwipeElementDirection.UP, offsetFromStartBorder, offsetFromEndBorder, duration);
		return this;
	}

	/**
	 * Swipe down.
	 *
	 * @param id
	 *            the id
	 * @param offsetFromStartBorder
	 *            the offset from start border
	 * @param offsetFromEndBorder
	 *            the offset from end border
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeDown(String id, int offsetFromStartBorder, int offsetFromEndBorder, int duration) {
		waitForElement(By.id(id));
		MobileElement element = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
		element.swipe(SwipeElementDirection.DOWN, offsetFromStartBorder, offsetFromEndBorder, duration);
		return this;
	}

	/**
	 * Gets the list contents.
	 *
	 * @param locator
	 *            the locator
	 * @return the list contents
	 */
	public ArrayList<String> getListContents(By locator) {
		java.util.List<WebElement> findElements = ((AndroidDriver<WebElement>) browser.getWebDriver())
				.findElements(locator);
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.clear();
		Iterator<WebElement> iterator = findElements.iterator();
		while (iterator.hasNext()) {
			WebElement next = iterator.next();
			arrayList.add(next.getText().toString());

		}
		return arrayList;

	}

	/**
	 * Scroll to.
	 *
	 * @param locator
	 *            the locator
	 * @param text
	 *            the text
	 * @param direction
	 *            the direction
	 * @return the base page
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public BasePage scrollTo(By locator, String text, String direction) throws InterruptedException {

		MobileElement element = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) ((AndroidDriver<?>) browser.getWebDriver());
		java.util.HashMap<String, String> scrollObject = new java.util.HashMap<String, String>();
		scrollObject.put("direction", direction);
		scrollObject.put("text", text);
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scrollTo", scrollObject);
		return this;
	}

	public BasePage scrollIntoView(By locator) throws InterruptedException {

		//MobileElement element = (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);
		WebElement element = browser.getWebDriver().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) (browser.getWebDriver());
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		return this;
	}
	
	
	public WebElement getWebElement(By locator) {
		
		return ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);

	}

	public void refreshWebPage() {
		browser.getWebDriver().navigate().refresh();		
		//return ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);

	}
	
	public boolean isWebElementDisplayed(By locator) {
		return ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator).isDisplayed();

	}

	public void setTimeToTimePicker(String firstField, String secondField, String thirdField) {

		List<WebElement> date = ((AndroidDriver<WebElement>) browser.getWebDriver()).findElements(By
				.className("android.widget.NumberPicker"));
		date.get(0).click();
		if (!date.get(0).isDisplayed()) {
			((AndroidDriver<?>) browser.getWebDriver()).findElement(By.id("net.bloomz:id/txtfromtime")).click();
		}
		date.get(0).sendKeys(firstField);
		date.get(1).sendKeys(secondField);
		date.get(2).sendKeys(thirdField);
	}

	public void setDateToDatePicker(String firstField, String secondField, String thirdField) {

		List<WebElement> date = ((AndroidDriver<WebElement>) browser.getWebDriver()).findElements(By
				.className("android.widget.NumberPicker"));
		date.get(0).click();
		if (!date.get(0).isDisplayed()) {
			((AndroidDriver<?>) browser.getWebDriver()).findElement(By.id("net.bloomz:id/txtfromdate")).click();
		}
		date.get(0).sendKeys(firstField);
		date.get(1).sendKeys(secondField);
		date.get(2).sendKeys(thirdField);
	}

	public int getElementSize(By locator) {
		waitForElement(locator);
		if (getPlatformName().equals("")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int elementSize = browser.getActions().getElements(locator).size();
		if (elementSize != 0) {
			return elementSize;
		}
		return 0;
	}

	//Uma commented
	/*public BasePage clearTextBox(By locator) {
		((AndroidDriver<?>) browser.getWebDriver()).findElement(locator).clear();
		return this;
	}*/
	public BasePage clearTextBox(By locator) {
		waitForElement(locator);
	
		if (getPlatformName().equals("Android")) {
			click(locator);
		}
		browser.getActions().getElement(locator).clear();
		return this;
	}

	public String getPlatformName() {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("Android")) {
			System.out.println("Driver Instance : "
					+ browser.getDesiredCapabilities().getCapability("platformName").toString());
			return browser.getDesiredCapabilities().getCapability("platformName").toString();

		}
		return "";
	}
	
	
	public BasePage sendkeyboardEvent(By locator) {
		waitForElement(locator);
	
		if (getPlatformName().equals("Android")) {
			click(locator);
		}
		browser.getActions().getElement(locator).sendKeys(Keys.ENTER);
		return this;
	}
	
	public String addYearsMonthsDays(Integer iYears, Integer iMonths, Integer iDays) {
		
	    String DATE_FORMAT = "MM-dd-yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	    DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
		 
		// Get current date
        Date currentDate = new Date();
        System.out.println("date : " + dateFormat.format(currentDate));

        // convert date to localdatetime
       LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
       System.out.println("localDate : " + dateFormat8.format(localDateTime));

        // plus one
       localDateTime = localDateTime.plusYears(iYears).plusMonths(iMonths).plusDays(iDays);

        // convert LocalDateTime to date
        Date addedDays = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("\nOutput : " + dateFormat.format(addedDays));
        
        return dateFormat.format(addedDays);
	}
	
	public void selectDateFromDatePicker(By locator1, By locator2) {
		
		//Get Today's number
        String today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");
 
        //Click and open the datepickers
        browser.getWebDriver().findElement(locator1).click();
 
        //This is from date picker table
        WebElement dateWidgetFrom = browser.getWebDriver().findElement(locator2);
 
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
 
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
	}
	
	public String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
		
	}
	
	public BasePage ReadJson()	{
		
		//String sURL = "https://app-staging.bloomz.net/api/admin/updateuser?email=pop@pop.pop&action=getDetails"; //just a string
		String sURL = "https://app-staging.bloomz.net/api/admin/updateuser?email=test_24-sep-2017-8-03-22-pm@test.com&action=getDetails";
		String myStr ;

		sURL = "https://app-staging.bloomz.net/api/admin/updateuser";
		
		try {
			// Connect to the URL using java's native library
			String login ="achaks@gmail.com";
			String password="bloomz999";
			String loginPassword = login+ ":" + password;
			
			String encoded = Base64.getEncoder().encodeToString(loginPassword.getBytes()) ;
			System.out.println(encoded);
			URL url = new URL(sURL);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.setRequestProperty ("Authorization", "Basic " + encoded);
			request.connect();			
			
		       InputStream xmlInputStream =request.getInputStream();
		        byte[] testByteArr = new byte[xmlInputStream.available()];
		        xmlInputStream.read(testByteArr);
		        System.out.println(new String(testByteArr)); 

			

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); //from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
			myStr = rootobj.get("primaryemail").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("createdtime").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("invitatio2ncode").getAsString(); //just grab the text
			System.out.println(myStr);
			myStr = rootobj.get("userregistrationstatus").getAsString(); //just grab the text
			System.out.println(myStr);
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		return this ;		
	}
	
	public void UploadFileAutoIT(String sFileName) throws InterruptedException, IOException {
	        
		try {
			
			StringSelection stringSelection = new StringSelection(sFileName);

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			//native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            Thread.sleep(3000);
            
         // Press Enter
            robot.keyPress(KeyEvent.VK_ENTER);
            
           // Release Enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            
             // Press CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            
           // Release CTRL+V
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(1000);
                   
            // Press Enter 
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
            Thread.sleep(1000);
            
        } catch (Exception exp) {
			exp.printStackTrace();
		}
		

	
//	public BasePage CopyPaste() {
//		 
//		  String string = "Hello Selenium"; 
//		  StringSelection stringSelection = new StringSelection(string);
//		  Toolkit.getDefaultToolkit().getSystemClipboard()
//		        .setContents(stringSelection, null);
//		 
//		  try {
//		     Runtime runtime = Runtime.getRuntime();
//		     runtime.exec("C:\\Windows\\System32\\Notepad.exe");
//		      
//		     Robot robot = new Robot();
//		     robot.keyPress(KeyEvent.VK_CONTROL);
//		     robot.keyPress(KeyEvent.VK_V); 
//		     robot.keyRelease(KeyEvent.VK_V); 
//		     robot.keyRelease(KeyEvent.VK_CONTROL); 
//		 
//		     } catch (AWTException e) {
//		        e.printStackTrace();
//		     } catch (IOException e1) {
//		        e1.printStackTrace();
//		   } 
//		 
//		}
	}

	protected String getColorElement(By locator1) {
		// TODO Auto-generated method stub
		String buttonColor = browser.getWebDriver().findElement(locator1).getCssValue("background-color");
        //String buttonTextColor = browser.getWebDriver().findElement(locator1).getCssValue("color");
		System.out.println("Button color: " + buttonColor);
        return buttonColor;
        
        //System.out.println("Text color " + buttonTextColor);
	}
	
}
