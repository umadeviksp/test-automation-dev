package com.bloomz.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
	private static String appiumVersion;
	private static String platformName;
	private static String platformVersion;
	private static String deviceName;
	protected static String appPath;
	private static String appPackage;
	private static String appActivity;
	private static String serverAddress;
	static ExecuteShellCommand shellCommand = new ExecuteShellCommand();

	protected static String emailId;

	protected static String password;

	protected static String stagingUrl;

	protected static String userType1;

	protected static String userType2;

	protected static String passwordForUserOnBoard;

	protected static String zipCode;

	@BeforeClass
	public static void loadConfig() throws IOException {
		environmentSetting = new EnvironmentSetting();
		DataSet.getEnvironmentData(environmentSetting);
		appiumVersion = environmentSetting.getAppiumVersion();
		platformName = environmentSetting.getPlatformName();
		platformVersion = environmentSetting.getPlatformVersion();
		deviceName = environmentSetting.getDeviceName();
		appPath = environmentSetting.getAppPath();
		appPackage = environmentSetting.getAppPackage();
		appActivity = environmentSetting.getAppActivity();
		serverAddress = environmentSetting.getServerAddress();

		userInputData = new UserInputData();
		DataSet.getUserInputData(userInputData);
		emailId = userInputData.getEmailId();
		password = userInputData.getPassword();
		stagingUrl = userInputData.getStagingUrl();
		userType1 = userInputData.getUserType1();
		userType2 = userInputData.getUserType2();
		passwordForUserOnBoard = userInputData.getPasswordForUserOnBoard();
		zipCode = userInputData.getZipCode();

	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		// Clear App cache
		shellCommand.executeCommand("chmod -R 777 .");
		shellCommand
				.executeCommand("/Users/Moolya21/Documents/Android_sdk/sdk/platform-tools/adb shell pm clear "
						+ appPackage);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", appiumVersion); // "1.0"
		capabilities.setCapability("platformName", platformName); // "Android"
		capabilities.setCapability("platformVersion", platformVersion); // "5.1"
		capabilities.setCapability("deviceName", deviceName); // "abcd"
		// capabilities
		// .setCapability("app",
		// "/Users/Moolya21/Desktop/Bloomz/testBloomz/src/test/resources/net.bloomz.apk");
		capabilities.setCapability("appPackage", appPackage);// "net.bloomz"
		capabilities.setCapability("appActivity", appActivity); // "md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity"
		appiumDriver = new AndroidDriver(new URL(serverAddress), capabilities); // "http://0.0.0.0:4724/wd/hub"

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

}
