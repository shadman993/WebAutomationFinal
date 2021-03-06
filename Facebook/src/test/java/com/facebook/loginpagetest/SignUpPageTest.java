package com.facebook.loginpagetest;

import com.facebook.dataprovidertest.DataProviderTest;
import com.facebook.pages.SignUpPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class SignUpPageTest extends TestBase {
    private static final Logger logger = Logger.getLogger(SignUpPageTest.class);
    SignUpPage signUpPage;

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest")
    public void createAccountPageTest(String firstName, String lastName , String mobileNumber , String newPassword){
        signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        windowsFullPageScrollDown();
        signUpPage.signUpLinks();
        signUpPage.firstName(firstName);
        ExtentTestManager.log(firstName+" Enter in text field",logger);
        signUpPage.lastName(lastName);
        ExtentTestManager.log(lastName+" Enter in text field",logger);
        signUpPage.mobileNumber(mobileNumber);
        ExtentTestManager.log(mobileNumber+" Enter in text field",logger);
        signUpPage.newPassword(newPassword);
        ExtentTestManager.log(newPassword+" Enter in text field",logger);
        signUpPage.monthDropDown();
        ExtentTestManager.log("User change month",logger);
        signUpPage.dayDropDown();
        ExtentTestManager.log("User change day",logger);
        signUpPage.yearDropDown();
        ExtentTestManager.log("User change year",logger);
        signUpPage.genderSelectForFemale();
        ExtentTestManager.log("User change as female",logger);
        signUpPage.signUpButton();
        Assert.assertTrue(signUpPage.signUpButtonDisplay());
        Assert.assertTrue(signUpPage.createAccountText());
        String expectedTitle = signUpPage.signUpPageTitle();
        String actualTitle = "Sign Up for Facebook | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User got title as expected",logger);
        sleepFor(5);
    }

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest")
    public void createAccountPageforValidteUserTest(String firstName, String lastName , String mobileNumber , String newPassword){
         signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        windowsFullPageScrollDown();
        signUpPage.signUpLinks();
        signUpPage.firstName(firstName);
        ExtentTestManager.log(firstName+" Enter in text field",logger);
        signUpPage.lastName(lastName);
        ExtentTestManager.log(lastName+" Enter in text field",logger);
        signUpPage.mobileNumber(mobileNumber);
        ExtentTestManager.log(mobileNumber+" Enter in text field",logger);
        signUpPage.newPassword(newPassword);
        ExtentTestManager.log(newPassword+" Enter in text field",logger);
        signUpPage.monthDropDown();
        ExtentTestManager.log("User change month",logger);
        signUpPage.dayDropDown();
        ExtentTestManager.log("User change day",logger);
        signUpPage.yearDropDown();
        ExtentTestManager.log("User change year",logger);
        signUpPage.genderSelectForMale();
        ExtentTestManager.log("User change as male",logger);
        signUpPage.signUpButton();
        Assert.assertTrue(signUpPage.signUpButtonDisplay());
        Assert.assertTrue(signUpPage.createAccountText());
        String expectedTitle = signUpPage.signUpPageTitle();
        String actualTitle = "Sign Up for Facebook | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User got title as expected",logger);
        sleepFor(5);
    }

}
