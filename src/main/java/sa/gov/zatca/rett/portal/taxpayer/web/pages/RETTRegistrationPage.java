package sa.gov.zatca.rett.portal.taxpayer.web.pages;

import com.example.base.Actions;
import com.example.base.DriverManager;
import com.example.base.ExcelManager;
import com.example.utils.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Map;


import static sa.gov.zatca.rett.portal.taxpayer.web.objects.PaymentPageObjects.*;
import static sa.gov.zatca.rett.portal.taxpayer.web.objects.RETTLoginPageObjects.*;
import static sa.gov.zatca.rett.portal.taxpayer.web.objects.GaztPageObjects.*;

public class RETTRegistrationPage {


    public RETTRegistrationPage registerRealEstateTXNs(Map<String, String> data) {

        Actions.click(BTN_REG_REALESTATETRANSACTIONS,"Clicked on Register Real Estate Transactions");
        selectAccountType(data);
        selectGCCCitizen(data);
        createAccount(data);
        enterBasicInformation(data);
        enterContactInformation(data);
        enterOTP(data);
        bankAccountDetails(data);
        enterloginInformation(data);
        return this;

    }

    public RETTRegistrationPage register_Companies(Map<String, String> data) {

        Actions.click(BTN_REG_REALESTATETRANSACTIONS,"Clicked on Register Real Estate Transactions");
        selectAccountType_Companies(data);
        register_Company(data);
        enterContactInformation(data);
        enterOTP(data);
        bankAccountDetails(data);
        enterCommissionerInfo_Continue(data);
        return this;


    }

    public RETTRegistrationPage register_RETTTXNs_Companies(Map<String, String> data,ITestContext context) {

        Actions.click(BTN_REG_REALESTATETRANSACTIONS,"Clicked on Register Real Estate Transactions");
        selectAccountType_Companies(data);
        loginToGaztSite_Company(data);
        createNewRealEstateRegistration_Companies(data);
        enterRealEstateTransactionDetails(data,context);

        return this;


    }

    public RETTRegistrationPage verifyInvoice(Map<String, String> data,ITestContext context) {


        Actions.sleep(2);

        Actions.click(LNK_INVOICES,"Clicked on Invoices");
        Actions.enterText(TXT_GLOBALSEARCH,context.getAttribute("InvoiceNumber").toString(),"Entered Invoice Number");
        Actions.click(BTN_GLOBALSEARCH,"Clicked on Search");
        Actions.sleep(3);
        String InvoiceStatus = Actions.getText(TXT_INVOICESTATUS);
        System.out.println(InvoiceStatus);
        System.out.println(data.get("InvoiceStatus"));
        Assert.assertTrue(InvoiceStatus.equalsIgnoreCase(data.get("InvoiceStatus")));
        Helper.log("Invoice is successfully Paid");
        Actions.takeScreenshot();


        return this;


    }





    public RETTRegistrationPage selectAccountType(Map<String, String> data) {

        Actions.click(BTN_INDIVIDUALS,"Selected Individuals");
        return this;


    }

    public RETTRegistrationPage selectAccountType_EnforcementAgency(Map<String, String> data) {

        Actions.click(BTN_ENFORCEMENTAGENCY,"Selected Enforcement Agency");
        return this;

    }



    public RETTRegistrationPage selectAccountType_Companies(Map<String, String> data) {

        Actions.click(BTN_COMPANIES,"Selected Companies");

        return this;

    }

    public RETTRegistrationPage register_Company(Map<String, String> data) {

        Actions.enterText(INPUT_LOGIN,data.get("UserName"),"Entered User ID");
        Actions.enterText(INPUT_PASSWORD,data.get("Password"),"Entered PWD");
        Actions.click(BTN_LOGIN_GAZT,"Clicked on Login");
        Actions.sleep(2);
        Actions.enterText(INPUT_OTP_GAZT,"0106","Entered OTP");
        Actions.sleep(3);
        WebDriver driver = DriverManager.getDriver();
        String s = driver.getCurrentUrl();

        System.out.println(s);
        System.out.println(data.get("GaztURL"));
        Assert.assertTrue(s.trim().contains(data.get("GaztURL")));

        Actions.click(BTN_CONTINUE,"Clicked on Continue");


        return this;

    }

    public RETTRegistrationPage loginToGaztSite_Company(Map<String, String> data) {

        Actions.enterText(INPUT_LOGIN,data.get("UserName"),"Entered User ID");
        Actions.enterText(INPUT_PASSWORD,data.get("Password"),"Entered PWD");
        Actions.click(BTN_LOGIN_GAZT,"Clicked on Login");
        Actions.sleep(2);
        Actions.enterText(INPUT_OTP_GAZT,"0106","Entered OTP");
        Actions.sleep(3);
        WebDriver driver = DriverManager.getDriver();
        String s = driver.getCurrentUrl();

        System.out.println(s);
        System.out.println(data.get("GaztURL"));
        Assert.assertTrue(s.trim().contains(data.get("GaztURL")));




        return this;

    }




    public RETTRegistrationPage selectGCCCitizen(Map<String, String> data) {

        Actions.click(BTN_GCCCITIZEN,"Selected GCC Citizen");


        return this;
    }

    public RETTRegistrationPage createAccount(Map<String, String> data) {

        Actions.click(LNK_CREATEACCOUNT,"Clicked on Create Account");

        return this;

    }

    public RETTRegistrationPage enterBasicInformation(Map<String, String> data) {


        Actions.enterText(TXT_ARABICNAME,data.get("Ar_Name"));
        Actions.enterText(TXT_ENGNAME,Actions.generateRandomUserName());
        Actions.enterText(TXT_BIRTHDATE,data.get("BirthDate"));
        Actions.click(BTN_GENDER_MALE,"Selected Male");
        Actions.click(DDL_NATIONALITY,"Selected Nationality Drop Down");
        Actions.click(DDL_KUWAIT,"Selected KUWAIT");
        Actions.enterText(TXT_IDNUMBER,Actions.generate10DigitRandomIDStartsWith1());
        Actions.click(BTN_CONTINUE,"Clicked on Continue");
        return this;


    }

    public RETTRegistrationPage enterContactInformation(Map<String, String> data) {

        Actions.clearText(TXT_PHONENUMBER);
        Actions.enterText(TXT_PHONENUMBER,data.get("MobileNumber"));
        Actions.clearText(TXT_EMAIL);
        Actions.clearText(TXT_CONFIRMEMAIL);

        Actions.enterText(TXT_EMAIL,data.get("Email"));
        Actions.enterText(TXT_CONFIRMEMAIL,data.get("Email"));

        Actions.enterText(TXT_ADDITIONALPHONENUMBER,data.get("MobileNumber"));
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        return this;


    }

    public RETTRegistrationPage enterOTP(Map<String, String> data) {


        Actions.sleep(5);
        //Actions.enterText(TXT_OTP,"1111");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        return this;

    }


    public RETTRegistrationPage bankAccountDetails(Map<String, String> data) {

        Actions.enterText(TXT_IBAN,data.get("IBAN"));
        Actions.enterText(TXT_BANK_OWNERID,data.get("OwnerID"));
        Actions.enterText(TXT_BANK_OWNERNAME,data.get("OwnerName"));


        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        return this;

    }

    public RETTRegistrationPage enterloginInformation(Map<String, String> data) {

        String uname = Actions.generateRandomUserName();
        Actions.enterText(TXT_USERNAME,uname);

        Actions.enterText(TXT_PASSWORD,data.get("Password"));
        Actions.enterText(TXT_REWRITEPASSWORD,data.get("Password"));


        ExcelManager.writeToExcelColumn(data,"RETT","UserName",uname);


        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        Assert.assertTrue(Actions.getText(TXT_TERMS).equalsIgnoreCase("Summary And The Terms and Conditions"));

        Actions.click(CHKBOX_AGREE,"Checked Terms and Conditions Check Box");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        String successMsg = Actions.getText(TXT_REGISTRATION_SUCESSMSG);
        Assert.assertTrue(successMsg.equalsIgnoreCase("Registered Successfully"));

        Helper.log("Successfully Registered");
        Actions.takeScreenshot();

        Actions.sleep(3);
        //    Actions.click(LNK_REGISTERREALESTATE_TXN,"Clicked on Register Link");

        return this;



    }

    public RETTRegistrationPage enterCommissionerInfo_Continue(Map<String, String> data) {

        Actions.click(BTN_CONTINUE,"Clicked on Continue");
        Actions.click(CHKBOX_AGREE,"Checked Terms and Conditions Check Box");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        Helper.log("Successfully Registered");
        Actions.takeScreenshot();

        Actions.sleep(3);


        return this;

    }


    public RETTRegistrationPage createRETTTxn(Map<String, String> data, ITestContext context) {

        loginToRegisteredUser(data);
        createNewRealEstateRegistration(data);
        enterRealEstateTransactionDetails(data,context);




        return this;


    }



    public RETTRegistrationPage createRETT_ByEnforcmentAgency(Map<String, String> data, ITestContext context) {
        loginToEnfAgency(data,context);
        enterOTP(data);
        Actions.click(BTN_REG_NEWREALESTATETXN,"Clicked on Register New Real Estate Txn");




        return this;


    }

    public RETTRegistrationPage loginToEnfAgency(Map<String, String> data, ITestContext context) {

        Actions.click(BTN_REG_REALESTATETRANSACTIONS,"Clicked on Register Real Estate Transactions");
        selectAccountType_EnforcementAgency(data);
        Actions.enterText(TXT_LOGIN_USERNAME,data.get("EnforcementAgencyUserName"));
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("EnforcementAgencyPassword"));
        Actions.click(BTN_LOGIN,"Clicked on Login");



        return this;

    }




    public RETTRegistrationPage loginToRegisteredUser(Map<String, String> data) {

        Actions.click(BTN_REG_REALESTATETRANSACTIONS,"Clicked on Register Real Estate Transactions");
        selectAccountType(data);
        selectGCCCitizen(data);

        System.out.println(data.get("UserName"));
        System.out.println(data.get("Password"));
        Actions.enterText(TXT_LOGIN_USERNAME,data.get("UserName"));
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("Password"));
        Actions.click(BTN_LOGIN,"Clicked on Login");

        //Enter OTP

        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        Actions.sleep(10);




        return this;
    }




    public RETTRegistrationPage loginToRiskofficer(Map<String, String> data) {


        Actions.enterText(TXT_LOGIN_USERNAME,data.get("RiskOfficerUserName"));
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("RiskOfficerPassword"));
        Actions.click(BTN_LOGIN,"Clicked on Login");


        return this;
    }



















    public RETTRegistrationPage createNewRealEstateRegistration(Map<String, String> data) {

        Actions.click(BTN_REG_NEWREALESTATETXN,"Clicked on Register New Real Estate Txn");

        Actions.click(DDL_PROVIDERNATURE,"Clicked on Provider Nature");
//
        Actions.click(DDL_INDIVIDUAL,"Clicked on Individual");

        Actions.click(BTN_REALESTATEDISPOSAL,"Selected Documentation of Real Estate Disposal for other cases");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        //Real Estate Transaction Details

        return this;


    }

    public RETTRegistrationPage createNewRealEstateRegistration_Companies(Map<String, String> data) {

        Actions.click(BTN_REG_NEWREALESTATETXN,"Clicked on Register New Real Estate Txn");

        //Actions.click(DDL_PROVIDERNATURE,"Clicked on Provider Nature");
//
       // Actions.click(DDL_INDIVIDUAL,"Clicked on Individual");

        Actions.click(BTN_REALESTATEDISPOSAL,"Selected Documentation of Real Estate Disposal for other cases");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        //Real Estate Transaction Details

        return this;


    }

    public RETTRegistrationPage enterRealEstateTransactionDetails(Map<String, String> data, ITestContext context) {


        Actions.click(DDL_NOTORIZATIONTYPE,"Select Notorization Type");
        Actions.click(DDL_NOTORIZATIONTYPE_OTHER,"Selected Others");



        Actions.click(DDL_TXNTYPE,"Select Txn Type");
        Actions.click(DDL_TXNTYPE_SELLPROPERTYONMAP,"Selected Selling Property on Map");

        Actions.click(DDL_CONTRACTTYPE,"Select Contract Type");
        Actions.click(DDL_CONTRACTTYPE_CONTRACT,"Selected Contract");

        Actions.enterText(TXT_CONTRACTNUMBER, Actions.generate10DigitRandomIDStartsWith1());

        Actions.click(TXT_DEEDDATE,"Clicked on Deed Issuance Date field");
        Actions.click(SLCT_DEEDDATE,"Selected on Deed Issuance Date");

        if(data.get("UserType").equalsIgnoreCase("Companies")) {
            Actions.click(DDL_COMMERCIALREGISTRATION,"Selecting Commercial Registration");
            Actions.sleep(1);
            Actions.click(DDL_COMMERCIALREGISTRATION_OPTION,"Selected Commercial Registration");
        }


        Actions.click(DDL_CONTRACTISSUERAGENCY,"Clicked Contract Issuer Agency");
        Actions.sleep(1);
        Actions.click(DDL_CONTRACTISSUERAGENCY_MINISTRY,"Selected Ministry of Communications ....");

        Actions.click(DDL_PROPERTYTYPE,"Clicked Property Type");
        Actions.sleep(2);
        Actions.click(DDL_PROPERTYTYPE_COMMERCIAL,"Selected Commercial");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");




        //Is there any Exception for the property
        Actions.click(BTN_NOEXCEPTION,"Selected No Exception");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");

        //Tax Details

        Actions.click(TXT_TXNDATE,"Clicked on Real Estate Txn Date field");
        Actions.click(SLCT_TXNDATE,"Selected on Real Estate Txn Date");
        Actions.enterText(TXT_REALESTATETXNVALUE,"1000000","Entered Txn Value");
        Actions.click(BTN_CONTINUE,"Clicked on Continue");


        Actions.click(BTN_UPLOADFILE);
        WebDriver driver = DriverManager.getDriver();
        driver.findElement(INPUT_FILE).sendKeys(data.get("FilePath"));


        Actions.click(DDL_TYPE,"Clicked on Type");
        Actions.click(DDL_COPYOFCONTRACT,"Selected Copy of Contract");

        Actions.enterText(TXT_DESCRIPTION,"Test", "Entered Description");

        Actions.click(BTN_ADD,"Clicked on Add");

        Actions.sleep(20);
        Actions.click(BTN_CLOSE,"Clicked on Close");

        Actions.click(CHK_AGREE,"Agree to the declaration");

        Actions.click(BTN_NEXT,"Clicked on Continue");
        Actions.sleep(15);

        Actions.click(CLOSE_SURVEY,"Closed Survey");
        Actions.sleep(8);


        try {
            Actions.sleep(2);
            String InvNumber = Actions.getText(TXT_INVOICENUMBER);

        } catch (Exception e) {


            String InvNumber = Actions.getText(TXT_INVOICENUMBER);

        }


       // Actions.waitUntilClickable(TXT_INVOICENUMBER);

        String InvNumber = Actions.getText(TXT_INVOICENUMBER);

        String RefNum = Actions.getText(TXT_REFNUMBER);
        RefNum = RefNum.split("is")[1].trim();

        String InvAmount = Actions.getText(TXT_INVAMOUNT);
        System.out.println(InvAmount);


        InvAmount = InvAmount.split("SAR")[0];
        InvAmount = InvAmount.replace(".","");
        InvAmount = InvAmount.replace(",","");
        InvAmount = InvAmount.substring(0,5).trim();
        System.out.println(InvAmount);
        context.setAttribute("InvoiceAmount",InvAmount);





        context.setAttribute("InvoiceNumber",InvNumber);
        context.setAttribute("ReferenceNumber",RefNum);


        Assert.assertTrue(Actions.getText(TXT_SUCESSMESSAGE).trim().equalsIgnoreCase("Your request has been submitted successfully, and you can finish the request proceedings after tax payment"));



        Actions.sleep(5);
        Actions.takeScreenshot();

        return this;


    }



}
