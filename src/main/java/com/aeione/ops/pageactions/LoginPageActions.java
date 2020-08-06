package com.aeione.ops.pageactions;import com.aeione.ops.generic.DriverManager;import com.aeione.ops.generic.ExtentTestManager;import com.aeione.ops.generic.GenericFunctions;import com.aeione.ops.pageobjects.LoginPageObjects;import com.relevantcodes.extentreports.LogStatus;import org.openqa.selenium.By;import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.PageFactory;import org.testng.Assert;import java.io.IOException;public class LoginPageActions {    GenericFunctions genericfunctions;    LoginPageObjects loginpageobjects = new LoginPageObjects();    Actions action;    public static String newline="";    public LoginPageActions() throws IOException {        genericfunctions = new GenericFunctions(DriverManager.getDriver());        PageFactory.initElements(DriverManager.getDriver(), this);        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);        action=new Actions(DriverManager.getDriver());        newline = System.getProperty("line.separator");    }    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////    public void logIn(String... strings)    {        String fullname=strings[1];        String userCredentials= strings[2];        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Login as  <b>\""+fullname+"\"</b> with  "+userCredentials+" and click on submit button");            String username = strings[3].trim();            String password = strings[4].trim();            enterUserName(username);            enterPassword(password);            clickOnLoginSubmitButton();    }    public void enterUserName(String... strings)    {        String username = strings[0];        try {            genericfunctions.waitForPageToLoad(loginpageobjects.login_username_textfield);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_username_textfield);            loginpageobjects.login_username_textfield.clear();            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_username_textfield);            loginpageobjects.login_username_textfield.sendKeys(username);        }catch (Exception e)        {            Assert.fail("Could not perform action on \"UserName Textfield\""+"&"+e.getMessage()+"" );        }    }    public void enterPassword(String... strings)    {        String password = strings[0];        try {            genericfunctions.waitForPageToLoad(loginpageobjects.login_password_textfield);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_password_textfield);            loginpageobjects.login_password_textfield.clear();            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_password_textfield);            loginpageobjects.login_password_textfield.sendKeys(password);        }catch (Exception e)        {            Assert.fail("Could not perform action on \"Password Textfield\""+"&"+e.getMessage()+"" );        }    }    public void clickOnLoginSubmitButton(String... strings)    {        try {            genericfunctions.waitForPageToLoad(loginpageobjects.login_submit_button);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_submit_button);            action.moveToElement(loginpageobjects.login_submit_button).doubleClick(loginpageobjects.login_submit_button).build().perform();            try            {                genericfunctions.waitTillElementToBeVisibleByLocator(By.id("invalid-user"));                Assert.fail("Login Failed Due to <b><font color=red>\"" +loginpageobjects.invalid_user_error_message.getText() + "\"</font></b>");            }catch(Exception e)            { }        }catch (Exception e)        {            Assert.fail("Could not perform action on \"login submit button\""+"&"+e.getMessage()+"" );        }    }    public void clickOnForgotPasswordLink(String... strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on forgot password link");        try {            genericfunctions.waitForPageToLoad(loginpageobjects.forgot_password_link);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.forgot_password_link);            loginpageobjects.forgot_password_link.click();            }catch (Exception e)        {            Assert.fail("Could not perform action on \"Forgot Password link \""+"&"+e.getMessage()+"" );        }    }    public String getInvalidMobileNumber(String... strings)    {        String invalidMobileNumber=null;        try {            invalidMobileNumber=genericfunctions.generateRandomPhoneNumber(9);        }catch (Exception e)        {            Assert.fail(""+"&"+e.getMessage()+"" );        }        return invalidMobileNumber;    }    public void enterMobileNumber(String... strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter "+strings[1]+" mobile number");        String mobileNumber=strings[2];        try {            genericfunctions.waitForPageToLoad(loginpageobjects.forgot_password_phone_number_textfield);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.forgot_password_phone_number_textfield);            loginpageobjects.forgot_password_phone_number_textfield.sendKeys(mobileNumber);        }catch (Exception e)        {            Assert.fail("Could not perform action on \"Phone Number textfield \""+"&"+e.getMessage()+"" );        }    }    public void clickOnResetPasswordButton(String... strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on reset password button");        try {            genericfunctions.waitForPageToLoad(loginpageobjects.phone_reset_button);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.phone_reset_button);            genericfunctions.waitForPageToLoad(loginpageobjects.phone_reset_button);            loginpageobjects.phone_reset_button.click();        }catch (Exception e)        {            Assert.fail("Could not perform action on \"Phone reset button \""+"&"+e.getMessage()+"" );        }    }    public void clickOnTopicSkipButton(String... strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on topic skip button");        try {            genericfunctions.waitWebDriver(4000);            genericfunctions.waitForPageToLoad(loginpageobjects.topics_skip_button);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.topics_skip_button);            genericfunctions.waitForPageToLoad(loginpageobjects.topics_skip_button);            action.moveToElement( loginpageobjects.topics_skip_button).doubleClick(loginpageobjects.topics_skip_button).build().perform();            genericfunctions.waitWebDriver(5000);        }catch (Exception e)        {            Assert.fail("Could not perform action on \"Topics skip button \""+"&"+e.getMessage()+"" );        }    }    /////////////////////////// Page Verifications//////////////////////////////////////////////////////////////////////    public void verifyContentsOfLoginPage(String... strings) {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to login page or not after launching test URL with following assertions :");        verifyDisplayOfLoginUserNameTextField();        verifyDisplayOfLoginPasswordTextField();        verifyDisplayOfLoginSubmitButton();        verifyDisplayOfForgotPasswordLink();    }    public void verifyDisplayOfLoginUserNameTextField()    {        try {            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_username_textfield);            Assert.assertTrue(loginpageobjects.login_username_textfield.isDisplayed());            ExtentTestManager.getTest().log(LogStatus.PASS, "\"login username\" textfield is displaying");        } catch (Exception e)        {            Assert.fail("Expected :: \"login username\" textfield should be displayed ; Actual :: \"login username\" textfield is not displayed"+"&"+e.getMessage()+"" );        }    }    public void verifyDisplayOfLoginPasswordTextField()    {        try {            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_password_textfield);            Assert.assertTrue(loginpageobjects.login_password_textfield.isDisplayed());            ExtentTestManager.getTest().log(LogStatus.PASS, "\"login password\" textfield is displaying");        } catch (Exception e)        {            Assert.fail("Expected :: \"login password\" textfield should be displayed ; Actual :: \"login password\" textfield is not displayed"+"&"+e.getMessage()+"" );        }    }    public void verifyDisplayOfLoginSubmitButton()    {        try {            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.login_submit_button);            Assert.assertTrue(loginpageobjects.login_submit_button.isDisplayed());            ExtentTestManager.getTest().log(LogStatus.PASS, "\"login submit\" button is displaying");        } catch (Exception e)        {            Assert.fail("Expected :: \"login submit\" button should be displayed ; Actual :: \"login submit\" button is not displayed"+"&"+e.getMessage()+"" );        }    }    public void verifyDisplayOfForgotPasswordLink() {        try {            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.forgot_password_link);            Assert.assertTrue(loginpageobjects.forgot_password_link.isDisplayed());            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Forgot Password\" link is displaying");        } catch (Exception e)        {            Assert.fail("Expected :: \"Forgot Password\" link should be displayed ; Actual :: \"Forgot Password\" link is not displayed"+"&"+e.getMessage()+"" );        }    }    public void verifyDisplayOfPhoneNumberTextfield(String ...strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to forgot password page  or not with following assertions :");        try {            genericfunctions.waitForPageToLoad(loginpageobjects.forgot_password_phone_number_textfield);            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.forgot_password_phone_number_textfield);            Assert.assertTrue(loginpageobjects.forgot_password_phone_number_textfield.isDisplayed());            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Forgot Password Phone Number \" textfield is displaying");        } catch (Exception e)        {            Assert.fail("Expected :: \"Forgot Password Phone Number\" textfield should be displayed ; Actual :: \"Forgot Password Phone Number\" textfield is not displayed"+"&"+e.getMessage()+"" );        }    }    public void verifyDisplayOfInvalidPhoneNumberErrorMessage(String ...strings)    {        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Error message is displaying or not with following assertion : ");        String expectedErrorMessage=strings[1];        String actualErrorMessage=null;        try        {            genericfunctions.waitTillTheElementIsVisible(loginpageobjects.error_message);            actualErrorMessage = loginpageobjects.error_message.getText().trim();            ExtentTestManager.getTest().log(LogStatus.PASS, "Error message is displaying as <b>\""+actualErrorMessage+"\"</b>");        }  catch (Exception e)        {            String actualException=e.getClass().getName();            switch (actualException)            {                case "NoSuchElementException":                    Assert.fail("Expected :: \"Error Message \" should be displayed ; Actual :: \"Error Message \" is not displayed"+"&"+e.getMessage()+"" );                    break;                case "AssertionError":                    Assert.fail("Expected :: Error Message should be displayed as  <b>\"" + expectedErrorMessage + "\"</b> ; Actual :: Error Message  is displaying as  <b>\"" + actualErrorMessage + "\"</b>");                    break;                default:                    Assert.fail(""+"&"+e.getMessage()+"");            }        }    }}