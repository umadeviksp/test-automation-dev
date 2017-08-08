# Test Automation

# Installation

Install:

- [Java JDK](https://java.com/inc/BrowserRedirect1.jsp?locale=en) and set the `JAVA_HOME` path
- [Android SDK](https://developer.android.com/studio/index.html) and set the `ANDROID_SDK` path
	- It's possible to only download the command line tools and not the entire Android Studio
- [Python 2.7](https://www.python.org/downloads/release/python-2712/) (**not** the latest version of Python) (Not needed for Macs)
- [Node.js](https://nodejs.org/en/download/) (Not needed for Macs)
- Appium
	- Use node.js: `npm install -g appium` (Not needed for Macs)
	- Download the [GUI app](https://github.com/appium/appium-desktop/releases/latest)
- [Eclipse](https://www.eclipse.org/downloads/)
	- Install [Maven](http://maven.apache.org/download.cgi)
	- Add the [TestNG plugin](https://marketplace.eclipse.org/content/testng-eclipse) to Eclipse
- [Git](https://git-scm.com/downloads) (if you don’t have it already)
- [Chrome driver](https://chromedriver.storage.googleapis.com/index.html?path=2.30/)

# Get git repository

Clone the [bloomzSrc/test-automation](https://github.com/bloomzSrc/test-automation) repository from GitHub:

`git clone https://github.com/bloomzSrc/test-automation.git TestAutomation`

# Import project into Eclipse

File > Import > Existing Projects into Workspace

![Screenshot of importing the project into Eclipse (1)](https://user-images.githubusercontent.com/14433542/27613701-e461ab28-5b51-11e7-9167-fc1bf74ceaac.png)

Select root directory > Browse... > `bloomz-ui-automation` > Finish

![Screenshot of importing the project into Eclipse (2)](https://user-images.githubusercontent.com/14433542/27613957-5c058e46-5b53-11e7-8cdb-43db90e2577d.png)

# Change the config file

1. Create a file `config.properties` in `bloomz-ui-automation`.
2. Copy and paste the following code:
```
# android platform 
platform.android=false

# iOS platform
platform.ios=false

# web platform
platform.web=true
chrome_driver_location=???
bloomz_base_test_url=http://app-staging.bloomz.net/#/app
# should be full path to a test image
test_image_location=???

# cloud
run.automation.cloud=yes
```
2. Change the `chrome_driver_location` property to where you downloaded your Chrome driver. For me, that was `/Users/VishalAdmin/Desktop/chromedriver_win32/chromedriver.exe`.
3. Change the `test_image_location` property to the full path of `placeholder_image.png`, which is in the `bloomz-ui-automation` folder.
4. Here is my `config.properties` for reference:
```# android platform 
platform.android=false

# iOS platform
platform.ios=false

# web platform
platform.web=true
chrome_driver_location=/Users/VishalAdmin/Desktop/chromedriver_win32/chromedriver.exe
bloomz_base_test_url=http://app-staging.bloomz.net/#/app
# should be full path to a test image
test_image_location=C:/Users/VishalAdmin/Desktop/Bloomz/TestAutomation/bloomz-ui-automation/placeholder_image.png

# cloud
run.automation.cloud=yes
```

# Run Appium (this is not needed if you are only doing web testing)

1. Run the Appium GUI.
2. Change the port number to `4725`
3. Start the server

![Screenshot of Appium (1)](https://user-images.githubusercontent.com/14433542/27614208-0c574a68-5b55-11e7-8863-eb52bdadd6f4.png)

What it should look like:

![Screenshot of Appium (2)](https://user-images.githubusercontent.com/14433542/27614275-60d22bda-5b55-11e7-9bac-4ccd5f4bb7d8.png)

# Run the project using TestNG

On `src/test/resources/BVT_Testng.xml`, click Run As > TestNG Suite

![Screenshot of running the test cases using TestNG](https://user-images.githubusercontent.com/14433542/27614094-4c0f5c50-5b54-11e7-9d96-df3c2583832e.png)

The opened Chrome webpage could look something like this:

![Screenshot of opened automated Chrome window](https://user-images.githubusercontent.com/14433542/27656869-82b37b0a-5bff-11e7-8d65-328200b6ee9a.png)

# View results of TestNG

Click the TestNG icon to open the results window.

![Screenshot of TestNG suite results](https://user-images.githubusercontent.com/14433542/27656966-f103472a-5bff-11e7-9584-066ae038caff.png)
