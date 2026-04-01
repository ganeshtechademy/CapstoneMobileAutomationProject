
Run using testng
>> Please run the file under root directory > Testng.xml file which will run the test SauceDemoTest


Steps followed to setup:

Android SDK download and install

Add Android plug in in IDE

Install Appium and UI Automator using below commands

npm install -g appium@2.0.1
appium driver install uiautomator2


Install Appium Inspector
brew install --cask appium-inspector

To check for all the tools/drivers installed for Appium
appium driver list

Installed - Android studio with tools
/Users/soujanyavakkalanka/Library/Android/sdk/build-tools
/Users/soujanyavakkalanka/Library/Android/sdk/emulator
/Users/soujanyavakkalanka/Library/Android/sdk/platform-tools

/Users/soujanyavakkalanka/Library/Android/sdk


Device name : GaneshDeviceAndriod
packageName : com.example.ganeshdeviceandriod


/Users/soujanyavakkalanka/AndroidStudioProjects/GaneshDeviceAndriod


To check the Andriod path setup right
echo $ANDROID_HOME

To check for Andriod Debug Bridge version use below command
adb --version            —> can see this /Users/soujanyavakkalanka/Library/Android/sdk/platform-tools/adb

Appium doctor to check if devices are installed and mapped
appium-doctor --android