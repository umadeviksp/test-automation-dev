# test-automation

### Prerequisites to be installed

    1. Java JDK and set JAVA_HOME path
    2. Android SDK and set ANDROID_SDK path
    3. Node.js
    4. Appium
    5. Eclipse
       1. Maven plugin
       2. TestNg plugin
    
### How to run Project

    1. Connect one android device (Android version > 4.2)
    2. git clone git@github.com:bloomzSrc/test-automation.git
    3. Change the adb path in BaseTest.java to your absolute adb to execute to clear app cache
        
        shellCommand
				  .executeCommand(" your adb absolute path /adb shell pm clear "
						+ appPackage);
						
    4. mvn clean
    5. mvn install
    
