package sa.gov.zatca.rett.portal.taxpayer.web.objects;

import com.example.base.Actions;
import org.openqa.selenium.By;

public class RETTLoginPageObjects {

    //Demosite Login Objects
    public static final By BTN_LANGUAGESELECTION = By.xpath("//*[@id='globalNav']/ul/li/button");
    public static final By BTN_REG_REALESTATETRANSACTIONS = By.xpath("//span[contains(.,' Register Real Estate transactions ')]");
    public static final By BTN_REG_NEWREALESTATETXN = By.xpath("//span[contains(.,' Register a new real estate transaction')]");
    public static final By BTN_INDIVIDUALS = By.xpath("//span[contains(.,'Individuals ')]");
    public static final By BTN_ENFORCEMENTAGENCY = By.xpath("//span[contains(.,'Enforcement Agency')]");

    public static final By BTN_COMPANIES = By.xpath("//span[contains(.,'Companies')]");
    public static final By BTN_GCCCITIZEN = By.xpath("//span[contains(.,'GCC Citizen')]");
    public static final By LNK_CREATEACCOUNT = By.xpath("//span[contains(.,' Create Account ')]");
    public static final By TXT_ARABICNAME = By.xpath("//input[@id='NameAR']");
    public static final By TXT_ENGNAME = By.xpath("//input[@id='NameEng']");
    public static final By TXT_BIRTHDATE = By.xpath("//input[@name='BirthDate']");
    public static final By BTN_GENDER_MALE = By.xpath("//span[contains(.,' Male ')]");
    public static final By DDL_NATIONALITY = By.xpath("//span[contains(.,'Please Select Nationality')]");
    public static final By DDL_KUWAIT = By.xpath("//span[contains(.,'Kuwait')]");
    public static final By TXT_IDNUMBER = By.xpath("//*[@id='IdNumber']");
    public static final By BTN_CONTINUE = By.xpath("//button[contains(.,'Continue')]");


    /*
      GAZT Site  WebElements
     */
    public static final By INPUT_LOGIN = By.xpath("//input[@id='logonuidfield']");
    public static final By INPUT_PASSWORD = By.xpath("//input[@id='logonpassfield']");
    public static final By BTN_LOGIN_GAZT = By.xpath("//button[@id='uidLogonBtn']");
    public static final By INPUT_OTP_GAZT = By.xpath("//*[@id='otpfield1']");





    public static final By TXT_PHONENUMBER = By.xpath("//*[@id='phone']");
    public static final By TXT_ADDITIONALPHONENUMBER = By.xpath("(//*[@id='phone'])[2]");
    public static final By TXT_EMAIL = By.xpath("//*[@name='EmailAddress']");
    public static final By TXT_CONFIRMEMAIL = By.xpath("//*[@id='ConfirmEmailAddress']");

    public static final By TXT_OTP = By.xpath("//*[@id='Code4']");
    public static final By TXT_IBAN = By.xpath("//input[@id=\"IBAN\"]");
    public static final By TXT_BANK_OWNERID = By.xpath("//input[@id=\"bankAccountOwnerIdNumber\"]");
    public static final By TXT_BANK_OWNERNAME = By.xpath("//input[@id=\"bankAccountOwnerName\"]");


    public static final By TXT_USERNAME = By.xpath("//input[@id=\"UserName\"]");
    public static final By TXT_PASSWORD = By.xpath("//input[@id=\"Password\"]");
    public static final By TXT_REWRITEPASSWORD = By.xpath("//input[@id=\"PasswordRewrite\"]");

    public static final By TXT_TERMS = By.xpath("//*[@id='sectionTitle']/h2");
    public static final By CHKBOX_AGREE = By.xpath("//input[@name='group1']/../..");
    public static final By TXT_REGISTRATION_SUCESSMSG = By.xpath("//*[@id='GaztLogo']/following-sibling::app-successed-register/p[2]");


    public static final By LNK_REGISTERREALESTATE_TXN = By.xpath("//a[contains(.,'Register a real estate transaction')]");


    public static final By TXT_LOGIN_USERNAME = By.xpath("//*[@id='userName']");

    public static final By TXT_LOGIN_PASSWORD = By.xpath("//*[@id=\"password\"]");
    public static final By BTN_LOGIN = By.xpath("//button[contains(.,'Login')]");

    public static final By DDL_PROVIDERNATURE = By.xpath("//span[contains(.,'Please Select Applicant Nature')]");
    public static final By DDL_INDIVIDUAL = By.xpath("//span[contains(.,'Individual')]");

    public static final By BTN_REALESTATEDISPOSAL = By.xpath("//span[contains(.,'Documentation of real estate disposal for other cases')]");
    public static final By DDL_NOTORIZATIONTYPE = By.xpath("//span[contains(.,'Choose Notarization Type')]");
    public static final By DDL_NOTORIZATIONTYPE_OTHER = By.xpath("//span[contains(.,'Others')]");

    public static final By DDL_TXNTYPE = By.xpath("//span[contains(.,'Choose Transaction Type')]");
    public static final By DDL_TXNTYPE_SELLPROPERTYONMAP = By.xpath("//span[contains(.,'Selling a property on the map')]");

    public static final By DDL_CONTRACTTYPE = By.xpath("//span[contains(.,'Type Contract/Document')]");
    public static final By DDL_CONTRACTTYPE_CONTRACT = By.xpath("(//span[contains(.,'Contract')])[2]");

    public static final By TXT_CONTRACTNUMBER = By.xpath("//*[@id=\"DocumentorContractNumber\"]");

    public static final By TXT_DEEDDATE = By.xpath("//*[@formcontrolname='deedIssuanceDate']");
    public static final By SLCT_DEEDDATE = By.xpath("(//span[contains(@class,'p-ripple ng-star-inserted')])[10]");

    public static final By DDL_CONTRACTISSUERAGENCY = By.xpath("//span[contains(.,'Choose Contract Issuer Agency')]");

    public static final By DDL_CONTRACTISSUERAGENCY_MINISTRY = By.xpath("//span[contains(.,'Ministry of Communications and Information Technology')]");


    public static final By DDL_PROPERTYTYPE = By.xpath("//span[contains(.,'Choose Property Type')]");
    public static final By DDL_PROPERTYTYPE_COMMERCIAL = By.xpath("//span[contains(.,'Commercial')]");

    public static final By BTN_NOEXCEPTION = By.xpath("//span[contains(.,' No')]");

    public static final By TXT_TXNDATE = By.xpath("//*[@formcontrolname='transactionDate']");
    public static final By SLCT_TXNDATE = By.xpath("(//span[contains(@class,'p-ripple ng-star-inserted')])[10]");

    public static final By TXT_REALESTATETXNVALUE = By.xpath("//*[@id='locale-user']");


    public static final By BTN_UPLOADFILE = By.xpath("//span[contains(.,' Upload file')]");
    public static final By INPUT_FILE = By.xpath("(//input[contains(@class,'c-inputtext')])[1]");

    public static final By DDL_TYPE = By.xpath("//span[contains(.,'Please Choose')]");
    public static final By DDL_COPYOFCONTRACT = By.xpath("//span[contains(.,'Copy of the contract')]");

    public static final By TXT_DESCRIPTION = By.xpath("(//input[contains(@class,'c-inputtext')])[2]");

    public static final By BTN_ADD = By.xpath("//span[contains(.,'Add')]");
    public static final By BTN_CLOSE = By.xpath("//span[contains(@class, 'p-button-label') and text() = 'Close']");

    public static final By CHK_AGREE = By.xpath("//input[@type='checkbox']");

    public static final By BTN_NEXT = By.xpath("(//button[contains(.,'&nbsp;')])[2]");

    public static final By TXT_INVOICENUMBER = By.xpath("//label[@for='CardNumber']/following-sibling::label");
    public static final By TXT_REFNUMBER = By.xpath("//*[@class='green_txt']");
    public static final By TXT_INVAMOUNT = By.xpath("//td[contains(.,'Total invoice amount')]/..//following-sibling::td");






    public static final By TXT_SUCESSMESSAGE = By.xpath("(//label[contains(@class,'green_txt')])[2]");
    //Your request has been submitted successfully, and you can finish the request proceedings after tax payment


    public static final By CLOSE_SURVEY = By.xpath("//*[@alt='close-survey']");


  /*
     Zatca Employee Page Objects
   */

    public static final By TXT_GLOBALSEARCH = By.xpath("//*[@id='globalSearchText']");
    public static final By BTN_GLOBALSEARCH = By.xpath("(//button[@class='clearBtn-style'])[1]");
    public static final By TXT_INVOICESTATUS = By.xpath("//p-table[@id='billsTable']/div/div/table/tbody/tr/td[9]");
    public static final By BTN_ASSIGN = By.xpath("(//button[@class='clearBtn-style'])[4]");
    public static final By BTN_ASSIGN_AUDITOFFICER = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[18]");
    public static final By BTN_AUDITCASESTUDY = By.xpath("//span[contains(.,'The Audit Case Study')]");
    public static final By BTN_NOCONFLICTSEXISTS = By.xpath("//span[contains(.,'No Conflict Exists')]");
    public static final By BTN_CLOSEAUDITCASE = By.xpath("//span[contains(.,'Close Audit Case')]");
    public static final By DDL_CLOSEREASON  = By.xpath("//*[@name='reasons']");
    public static final By DDL_CLOSEREASON_OTHERS = By.xpath("//span[contains(.,'Others')]");
    public static final By BTN_CLOSEAUDIT_SEND = By.xpath("(//button[contains(.,'Send')])[2]");
    public static final By BTN_CLOSEAUDIT_OK = By.xpath("//span[contains(.,'Ok')]");
    public static final By MSG_CLOSEAUDIT = By.xpath("//div[@role='dialog']/div/span");
    public static final By BTN_CLOSEAUDIT_X = By.xpath("//span[contains(@class,'p-dialog-header-close-ic')]");
    //span[contains(@class,'p-dialog-header-close-ic')]








    public static final By BTN_FINALEVALUATIONPROCEDURE = By.xpath("//span[contains(.,'Final evaluation procedure')]");
    public static final By DDL_FINALDECISION = By.xpath("//span[contains(.,'please select final decision')]");
    public static final By DDL_FINALDECISION_DISPOSITIONTOGETHER = By.xpath("//span[contains(.,'Closing the case with adjusting the value and date of disposition together')]");
    public static final By TXT_8BFINE = By.xpath("//input[@name='Regulation8BFine']");
    public static final By TXT_TXNNEWAMOUNT = By.xpath("//input[@name='TransactionNewDueAmountFieldValidation']");
    public static final By DDL_REEVALUATIONREASON = By.xpath("//span[contains(.,'Please Select The Reason For The Audit')]");
    public static final By DDL_REEVALUATIONREASON_OTHERS = By.xpath("//span[contains(.,'Others')]");
    public static final By TXT_FINALEVALUATIONREASON = By.xpath("//input[@id='finalEvalOthersReasonText']");
    public static final By TXT_REQUIREMENTSDECISION = By.xpath("//*[@id='finalEvalRequirementsDescription']");
    public static final By INPUT_TXNNEWDATE = By.xpath("//input[@name='TranscationNewDateFieldValidation']");
    public static final By BTN_FINALEVALUATION_SEND = By.xpath("(//span[contains(.,'Send')])[2]");
    public static final By BTN_OK = By.xpath("//span[contains(.,'Ok')]");
    public static final By TXT_AUDIT_STATUS = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[6]");

    public static final By DDL_SELLERIDTYPE = By.xpath("//*[@id='SellerIdentiyType']");
    public static final By DDL_SELLERIDTYPE_NATID = By.xpath("//span[contains(.,'National Identity')]");



    public static final By BTN_OFF_EXAMINATION_REQUEST = By.xpath("//span[contains(.,'Office Examination Request')]");
    public static final By DDL_AUDITREASON = By.xpath("//span[contains(.,'Please Select The Reason For The Audit')]");
    public static final By DDL_AUDITREASON_OTHERS = By.xpath("//span[contains(.,'Others')]");
    public static final By DDL_SRCAUDITCASE = By.xpath("//span[contains(.,'Please Select The source Of The Audit Case')]");
    public static final By DDL_SRCAUDITCASE_ANALYSIS = By.xpath("//span[contains(.,'Analysis and risk management')]");

    public static final By TXT_DESC_AUDITCASE = By.xpath("//*[@id='auditCaseDescriptionId']");


    public static final By TXT_AUDIT_REQNUM = By.xpath("//*[@class='text-center mt-4']/div[2]/p");

    public static final By BTN_SEND = By.xpath("//button[contains(.,'Send')]");

    public static final By LNK_LOGOUT = By.xpath("(//*[@class='img_ltr'])[1]");


    public static final By LNK_AUDITCASES = By.xpath("//span[contains(.,'Audit Cases')]");
    public static final By LNK_PROCEDURES = By.xpath("//span[contains(.,'Procedures')]");
    public static final By LNK_FINALEVALUATIONPROCEDURE = By.xpath("//span[contains(.,'Approving of an final evaluation procedure')]");

    public static final By LNK_CLOSEAUDIT_PROCEDURE = By.xpath("//span[contains(.,'Approval of closing the office audit case')]");

    public static final By TXT_FINALEVALUATIONNOTES = By.xpath("//*[@id='finalEvaluserActionViewModel.notes']");
    public static final By TXT_AUDIT_CLOSENOTES = By.xpath("//input[@id='notes']");
    public static final By BTN_APPROVE_FINALEVALUATION = By.xpath("//span[contains(.,'Approve')]");
    public static final By BTN_APPROVE_CLOSEAUDIT = By.xpath("//button[contains(.,'Approve')]");
    public static final By BTN_RJCT_FINALEVALUATION = By.xpath("//button[contains(.,'Reject')]");

    //button[contains(.,'Reject')]

    public static final By BTN_SEARCH = By.xpath("//span[contains(.,'Search')]");
    public static final By TXT_CASENUMBER = By.xpath("//input[@id='RequestNumber']");
    public static final By TXT_AUDITORNAME = By.xpath("//thead[@class='p-datatable-thead']/following-sibling::tbody/tr[1]/td[10]");
    public static final By TXT_CASEDESCRIPTION = By.xpath("//p-table[@datakey='id']/div/div/table/tbody/tr/td[9]");
    public static final By TXT_CASEGLOBALSEARCH = By.xpath("//*[@class='form-control ng-untouched ng-pristine ng-valid p-inputtext p-component']");

    public static final By TXT_CASEGLOBALSEARCH_AuditOfficer = By.xpath("//*[@class='d-flex globalSearchDDL']/input");



    public static final By BTN_CASESEARCH = By.xpath("//button[@class='clearBtn-style p-button p-component p-ripple']");

}
