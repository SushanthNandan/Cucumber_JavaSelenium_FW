# Cucumber_JavaSelenium_FW

Created a Maven project and it's a hybrid driven framework (Data driven + Modular + Cucumber) which is based on page object model.

The framework consists of 4 major packages.

Features:
  It contains set of feature files for your application. We can create multiple feature files for each page.
  
Stepdefs:
    It contains step definitions class for corresponding feature file. Also, it has Hooks class, which are blocks of code that run before or after each scenario.
    
Resources:
    It contains objectrepository class (Locators/Web Elements for each page) and properties file (Constant values like URL, username, etc.) which can be used across multiple functions.
    
Utilities:
    It contains GenericUitls class which has all generic methods like (Click, Wait, Get Text, Actions, etc.). These methods can be reused across the project.
    
Runner:
    It contains TestRunner class. We have used TestNg runner which you can run feature file
    
 
Execution:
To run the test, go to Testrunner class and right click > select "Run as TestNg".
To see the step definitions for each step, go to feature file and keep the cursor on any step and select F3 which redirects to corresponding step definitions.




