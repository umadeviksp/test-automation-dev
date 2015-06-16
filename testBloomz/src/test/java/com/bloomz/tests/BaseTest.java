package com.bloomz.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.bloomz.utils.ExecuteShellCommand;
import com.bloomz.utils.excelconfig.DataSet;
import com.bloomz.utils.excelconfig.EnvironmentSetting;
import com.bloomz.utils.excelconfig.UserInputData;

public class BaseTest {
	AppiumDriver appiumDriver;

	static EnvironmentSetting environmentSetting;
	static UserInputData userInputData;
	static ExecuteShellCommand shellCommand = new ExecuteShellCommand();

	// Environment Variables
	protected static String appiumVersion;
	protected static String platformName;
	protected static String platformVersion;
	protected static String deviceName;
	protected static String appPath;
	protected static String appPackage;
	protected static String appActivity;
	protected static String serverAddress;

	// User Input Datas
	protected static String emailId;
	protected static String password;
	protected static String stagingUrl;
	protected static String userType1;
	protected static String userType2;
	protected static String passwordForUserOnBoard;
	protected static String zipCode;

	protected static URL environmentDataFilePath, userInputDataFilePath;
	private static final String TESTDROID_USERNAME = "nitin@bloomz.net";
	private static final String TESTDROID_PASSWORD = "bloomz999";

	@BeforeClass
	public static void loadConfig() throws IOException {
		environmentSetting = new EnvironmentSetting();
		environmentDataFilePath = BaseTest.class.getClass().getResource(
				"/EnviromentDataSet.csv");
		String fullPath = environmentDataFilePath.getPath();
		DataSet.getEnvironmentData(environmentSetting, fullPath);
		appiumVersion = environmentSetting.getAppiumVersion();
		platformName = environmentSetting.getPlatformName();
		platformVersion = environmentSetting.getPlatformVersion();
		deviceName = environmentSetting.getDeviceName();
		appPath = environmentSetting.getAppPath();
		appPackage = environmentSetting.getAppPackage();
		appActivity = environmentSetting.getAppActivity();
		serverAddress = environmentSetting.getServerAddress();

		userInputData = new UserInputData();
		userInputDataFilePath = BaseTest.class.getClass().getResource(
				"/UserInputDataSet.csv");
		String fullPath2 = userInputDataFilePath.getPath();
		DataSet.getUserInputData(userInputData, fullPath2);
		emailId = userInputData.getEmailId();
		password = userInputData.getPassword();
		stagingUrl = userInputData.getStagingUrl();
		userType1 = userInputData.getUserType1();
		userType2 = userInputData.getUserType2();
		passwordForUserOnBoard = userInputData.getPasswordForUserOnBoard();
		zipCode = userInputData.getZipCode();

	}

	@BeforeMethod
	public void setUp() throws IOException {

		// ----------------- Local ------------------------------
		// Clear App cache
		// shellCommand.executeCommand("chmod -R 777 .");
		// shellCommand
		// .executeCommand("/Users/Moolya21/Documents/Android_sdk/sdk/platform-tools/adb shell pm clear "
		// + appPackage);
		// DesiredCapabilities capabilities = new
		// DesiredCapabilities().android();
		// capabilities.setCapability("appium-version", appiumVersion); // "1.0"
		// capabilities.setCapability("platformName", platformName); //
		// "Android"
		// capabilities.setCapability("platformVersion", platformVersion); //
		// "5.1"
		// capabilities.setCapability("deviceName", deviceName); // "abcd"
		// // capabilities
		// // .setCapability("app",
		// //
		// "/Users/Moolya21/Desktop/Bloomz/testBloomz/src/test/resources/net.bloomz.apk");
		// capabilities.setCapability("appPackage", appPackage);// "net.bloomz"
		// capabilities.setCapability("appActivity", appActivity); //
		// "md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity"

		// ---------------------- Sauce labs ------------------------
		// DesiredCapabilities caps = DesiredCapabilities.android();
		// caps.setCapability("appiumVersion", "1.4.0");
		// caps.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
		// caps.setCapability("deviceOrientation", "portrait");
		// caps.setCapability("browserName", "");
		// caps.setCapability("platformVersion", "4.4");
		// caps.setCapability("platformName", "Android");
		//
		// caps.setCapability("app", "sauce-storage:bloomz.zip");
		// caps.setCapability("appPackage", appPackage);// "net.bloomz"
		// caps.setCapability("appActivity", appActivity); //
		// "md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity"
		// appiumDriver = new AndroidDriver(
		// new URL(
		// "http://nitin_bloomz:fcb9a1d2-c072-445c-9bf0-9689b36532e2@ondemand.saucelabs.com:80/wd/hub"),
		// caps); // "http://0.0.0.0:4724/wd/hub"

		// --------------------- AppThwack ---------------------
		// DesiredCapabilities caps = DesiredCapabilities.android();
		// caps.setCapability("appiumVersion", "1.0");
		// caps.setCapability("automationName", "Appium");
		// caps.setCapability("deviceName", "LG Nexus 5");
		// caps.setCapability("platformVersion", "5.0");
		// caps.setCapability("platformName", "Android");
		// caps.setCapability("project", "45953");
		// caps.setCapability("apiKey",
		// "ca86bfe16c942f9cec9536618d451e5596bcd86d");
		// caps.setCapability("app", "240969");
		// caps.setCapability("device", "Android");
		// caps.setCapability("appPackage", "net.bloomz");// "net.bloomz"
		// caps.setCapability("appActivity",
		// "md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity"); //
		// appiumDriver = new AndroidDriver(
		// new URL("https://appthwack.com/wd/hub"), caps); //
		// "http://0.0.0.0:4724/wd/hub"

		// -------------------- Testdroid ----------------

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("testdroid_target", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("testdroid_username", TESTDROID_USERNAME);
		capabilities.setCapability("testdroid_password", TESTDROID_PASSWORD);
		capabilities.setCapability("testdroid_project", "Appium Automation");
		capabilities.setCapability("testdroid_description",
				"My first Appium project at Testdroid Cloud");
		capabilities.setCapability("testdroid_testrun", "Test Run 4");
		capabilities.setCapability("testdroid_device", "Samsung Galaxy S6 Edge SM-G925F");
		// Freemium
		capabilities.setCapability("testdroid_app",
				"28ab24b8-784d-44fb-b045-8bfd03c49573/bloomz.apk"); // to use
		capabilities.setCapability("appPackage", "net.bloomz");
		capabilities.setCapability("app-activity",
				"md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity");
		appiumDriver = new AndroidDriver(new URL(
				"http://appium.testdroid.com/wd/hub"), capabilities);
		System.out.println("Capabilities:" + capabilities.toString());

		System.out
				.println("Creating Appium session, this may take couple minutes..");

	}

	@AfterMethod
	public void tearDown() {
		appiumDriver.quit();
	}

	public String getActivityName() {
		return ((AndroidDriver) appiumDriver).currentActivity();
	}

	/**
	 * Generate random string.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String generateRandomString(int length) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String characters = "";
		characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public String getCurrentTimeStamp() {
		Date date = new Date();
		SimpleDateFormat noMilliSecondsFormatter = new SimpleDateFormat(
				"yyyy_MM_dd_HH_mm_ss");
		String format = noMilliSecondsFormatter.format(date);
		return format;
	}

}
