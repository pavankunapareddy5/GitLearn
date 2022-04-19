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

import static sa.gov.zatca.rett.portal.taxpayer.web.objects.GaztPageObjects.*;
import static sa.gov.zatca.rett.portal.taxpayer.web.objects.PaymentPageObjects.*;
import static sa.gov.zatca.rett.portal.taxpayer.web.objects.RETTLoginPageObjects.*;

public class AuditPage {


    public AuditPage createAuditCaseByRISKSupervisor(Map<String, String> data, ITestContext context) {

        loginToRiskSupervisor(data);
        createAuditTask(data,context);
        logoutRiskSupervisor(data,context);

        return this;


    }

    public AuditPage logoutRiskSupervisor(Map<String, String> data, ITestContext context) {


        Actions.sleep(3);
        Actions.click(LNK_LOGOUT,"Logged off from RiskSupervisor");

        return this;

    }

    public AuditPage createAuditTask(Map<String, String> data, ITestContext context) {


        Actions.enterText(TXT_GLOBALSEARCH,context.getAttribute("ReferenceNumber").toString(),"Entered Request Number");

        Actions.click(BTN_GLOBALSEARCH,"Clicked on Search");
        Actions.sleep(2);
        Actions.click(BTN_ASSIGN,"Clicked on Assign Button");
        Actions.click(BTN_OFF_EXAMINATION_REQUEST,"Clicked on Office Examination Request");
        Actions.sleep(4);

        Actions.click(DDL_AUDITREASON,"Clicked Audit Reason Drop Down");
        Actions.click(DDL_AUDITREASON_OTHERS,"Selected Audit Reason Others");

        Actions.click(DDL_SRCAUDITCASE,"Clicked Source of Audit Case Drop Down");
        Actions.click(DDL_SRCAUDITCASE_ANALYSIS,"Selected Analysis and Risk Management");

        Actions.enterText(TXT_DESC_AUDITCASE,"Automation_AuditCase","Entered Audit Case Description");

        Actions.click(BTN_SEND,"Clicked on Send");

        String s = Actions.getText(TXT_AUDIT_REQNUM);
        Helper.log("Audit Case Request Number" +s);

        s = s.split("with")[1].trim();
        context.setAttribute("AuditCaseID",s);

        Helper.log("Audit Case Number = " + s);

        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH,s,"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");
        Actions.sleep(2);

        String x = Actions.getText(TXT_AUDITORNAME).trim();
        Helper.log("Auditor Name = " + x);

        context.setAttribute("AuditorName",x);
        System.out.println(context.getAttribute("AuditorName").toString());


        return this;

    }

    public AuditPage loginToRiskSupervisor(Map<String, String> data) {


        Actions.enterText(TXT_LOGIN_USERNAME,data.get("RiskSuperVisorUserName"));
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("RiskSuperVisorPassword"));
        Actions.click(BTN_LOGIN,"Clicked on Login");


        return this;
    }

    public AuditPage loginToAuditofficer(Map<String, String> data, ITestContext context) {

        System.out.println(context.getAttribute("AuditorName").toString());
        Actions.sleep(2);
        Actions.enterText(TXT_LOGIN_USERNAME,context.getAttribute("AuditorName").toString());
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("AuditofficerPassword"));
        Actions.click(BTN_LOGIN,"Clicked on Login");


        return this;
    }


    public AuditPage logoutAuditOfficer(Map<String, String> data, ITestContext context) {



        WebDriver driver = DriverManager.getDriver();
        driver.navigate().refresh();
        Actions.sleep(6);
        Actions.click(LNK_LOGOUT,"Logged off from AuditOfficer");


        return this;
    }

    public AuditPage approveAuditCase(Map<String, String> data, ITestContext context) {


        Actions.click(LNK_PROCEDURES,"Clicked on Procedures");
        Actions.enterText(TXT_CASENUMBER,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_SEARCH,"Clicked on Search");
        Actions.sleep(2);

        Actions.click(LNK_FINALEVALUATIONPROCEDURE,"Clicked on Final Evaluation Link");
        Actions.enterText(TXT_FINALEVALUATIONNOTES,"Test","Entered Final Evaluation Notes");
        Actions.click(BTN_APPROVE_FINALEVALUATION,"Approved Final Evaluation");
        Actions.sleep(5);
        Actions.takeScreenshot();
        Actions.click(BTN_OK,"Clicked on OK");

        Actions.click(LNK_PROCEDURES,"Clicked on Procedures");
        Actions.enterText(TXT_CASENUMBER,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.sleep(2);
        Actions.click(BTN_SEARCH,"Clicked on Search");
        Actions.sleep(3);
        String s = Actions.getText(TXT_AUDIT_STATUS).trim();
        Assert.assertTrue(s.equalsIgnoreCase("completed"));
        Actions.takeScreenshot();
        Actions.sleep(5);

        return this;




    }

    public AuditPage approveCloseAudit_ByRiskSuprevisor(Map<String, String> data, ITestContext context) {

        Actions.click(LNK_PROCEDURES,"Clicked on Procedures");
        Actions.enterText(TXT_CASENUMBER,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_SEARCH,"Clicked on Search");
        Actions.sleep(2);

        Actions.click(LNK_CLOSEAUDIT_PROCEDURE,"Selecting Close Audit Procedure");
        Actions.enterText(TXT_AUDIT_CLOSENOTES,"Test_Automation","Entered Close Notes");
        Actions.click(BTN_APPROVE_CLOSEAUDIT,"Clicked on Approve");
        Actions.click(BTN_CLOSEAUDIT_OK,"Clicked on OK");



        Actions.sleep(3);
        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH_AuditOfficer,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");
        Actions.sleep(2);
        String caseDesc = Actions.getText(TXT_CASEDESCRIPTION);
        Assert.assertTrue(caseDesc.equalsIgnoreCase(data.get("AuditCaseDescription")));


        return this;




    }

    public AuditPage rejectFinalEvaluation_ByRiskSuprevisor(Map<String, String> data, ITestContext context) {

        Actions.click(LNK_PROCEDURES,"Clicked on Procedures");
        Actions.enterText(TXT_CASENUMBER,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_SEARCH,"Clicked on Search");
        Actions.sleep(2);

        Actions.click(LNK_FINALEVALUATIONPROCEDURE,"Selecting Close Audit Procedure");
        Actions.enterText(TXT_FINALEVALUATIONNOTES,"Test_Automation","Entered Close Notes");
        Actions.click(BTN_RJCT_FINALEVALUATION,"Clicked on Reject");
        Actions.click(BTN_CLOSEAUDIT_OK,"Clicked on OK");



        Actions.sleep(3);
        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH_AuditOfficer,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");
        Actions.sleep(2);
        String caseDesc = Actions.getText(TXT_CASEDESCRIPTION);
        Assert.assertTrue(caseDesc.equalsIgnoreCase(data.get("AuditCaseDescription")));


        return this;




    }


    public AuditPage approveFinalEvaluation_ByRiskSuprevisor(Map<String, String> data, ITestContext context) {

        Actions.sleep(2);

        Actions.click(LNK_PROCEDURES,"Clicked on Procedures");
        Actions.enterText(TXT_CASENUMBER,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_SEARCH,"Clicked on Search");
        Actions.sleep(2);

        Actions.click(LNK_FINALEVALUATIONPROCEDURE,"Selecting Close Audit Procedure");
        Actions.enterText(TXT_FINALEVALUATIONNOTES,"Test_Automation","Entered Close Notes");
        Actions.click(BTN_APPROVE_FINALEVALUATION,"Clicked on Approve");
        Actions.click(BTN_CLOSEAUDIT_OK,"Clicked on OK");



        Actions.sleep(3);
        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH_AuditOfficer,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");
        Actions.sleep(2);
        String caseDesc = Actions.getText(TXT_CASEDESCRIPTION);
        Assert.assertTrue(caseDesc.equalsIgnoreCase(data.get("AuditCaseDescription")));
        Actions.sleep(3);


        return this;




    }

    public AuditPage loginToAuditSupervisor(Map<String, String> data, ITestContext context) {

        Actions.sleep(2);
        Actions.enterText(TXT_LOGIN_USERNAME,data.get("AuditSupervisorUserName"),"Entered AuditSuperVisor UserName");
        Actions.sleep(2);
        Actions.enterText(TXT_LOGIN_PASSWORD,data.get("AuditofficerPassword"),"Entered AuditSuperVisor PWD");
        Actions.click(BTN_LOGIN,"Clicked on Login");
        Helper.log("Successfully Logged in to Audit Supervisor");

        return this;
    }

    public AuditPage auditCaseStudyWithFinalEvaluation(Map<String, String> data, ITestContext context) {


        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH_AuditOfficer,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");

        Actions.sleep(2);
        Actions.click(BTN_ASSIGN_AUDITOFFICER,"Clicked on Assign Button");
        Actions.sleep(2);
        Actions.click(BTN_AUDITCASESTUDY,"Selected Audit Case Study");
        Actions.click(BTN_NOCONFLICTSEXISTS,"Selected No Conflicts Exists");
        Actions.sleep(3);


        Actions.click(BTN_FINALEVALUATIONPROCEDURE, "Selected Final Evaluation Procedure");
        Actions.click(DDL_FINALDECISION,"Clicked on Final Decision drop down");
        Actions.click(DDL_FINALDECISION_DISPOSITIONTOGETHER,"Selected  Final Decision");
        Actions.click(INPUT_TXNNEWDATE,"Selecting New Txn Date");
        Actions.click(SLCT_DEEDDATE,"Selected New TXN date");
        Actions.click(DDL_REEVALUATIONREASON,"Clicked on Reevaluation Reason drop down");
        Actions.click(DDL_REEVALUATIONREASON_OTHERS,"Selected Reevaluation Reason");
        Actions.enterText(TXT_8BFINE,"10000","Entered 10K SAR Fine");
        Actions.enterText(TXT_TXNNEWAMOUNT,"2000000","Entered Real Estate real value");
        Actions.sleep(6);


        Actions.enterText(TXT_FINALEVALUATIONREASON,"Test","Entered Final Evaluation Reason");
        Actions.enterText(TXT_REQUIREMENTSDECISION,"Test","Entered Requirements Decision");

        Actions.click(BTN_FINALEVALUATION_SEND,"Clicked on Send");
        Actions.takeScreenshot();
        Actions.click(BTN_OK,"Clicked on Ok");
        Helper.log("Successfully  submitted Audit Case Final Evaluation");

        return this;



    }

    public AuditPage close_AuditCase(Map<String, String> data, ITestContext context) {

        Actions.click(LNK_AUDITCASES,"Clicked on Audit Cases");
        Actions.enterText(TXT_CASEGLOBALSEARCH_AuditOfficer,context.getAttribute("AuditCaseID").toString(),"Entered Case Number");
        Actions.click(BTN_CASESEARCH,"Clicked on Search");

        Actions.sleep(2);
        Actions.click(BTN_ASSIGN_AUDITOFFICER,"Clicked on Assign Button");
        Actions.sleep(2);
        Actions.click(BTN_AUDITCASESTUDY,"Selected Audit Case Study");
        Actions.click(BTN_NOCONFLICTSEXISTS,"Selected No Conflicts Exists");
        Actions.sleep(3);

        Actions.click(BTN_CLOSEAUDITCASE, "Clicked on  Closed Audit Case button");
        Actions.click(DDL_CLOSEREASON,"Clicked on Close Reason Drop down");
        Actions.sleep(1);
        Actions.click(DDL_CLOSEREASON_OTHERS,"Selected Others as Close Reason");
        Actions.click(BTN_CLOSEAUDIT_SEND,"Clicked on Send");

        String message = Actions.getText(MSG_CLOSEAUDIT);
        Assert.assertTrue(message.contains("for approval"));
        Actions.click(BTN_CLOSEAUDIT_OK,"Clicked on OK");

        return this;



    }



}
