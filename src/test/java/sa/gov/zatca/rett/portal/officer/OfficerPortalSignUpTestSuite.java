package sa.gov.zatca.rett.portal.officer;

import com.example.base.Browser;
import com.example.utils.ConfigManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import sa.gov.zatca.rett.ZatcaRETTPortal;
import sa.gov.zatca.rett.base.ZatcaBrowserCaps;
import sa.gov.zatca.rett.base.ZatcaRETTWebTest;

import java.util.Map;

public class OfficerPortalSignUpTestSuite extends ZatcaBrowserCaps {



    @Test(dataProvider = "testDataProvider",testName = "register_RET_Individual_GCC",
            description = "Register Real Estate Transaction -- GCC Individual")
    public void register_RET_Individual_GCC(Map<String, String> data) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.registerRealEstateTXNs(data);

    }


    @Test(dataProvider = "testDataProvider",testName = "Create Real Estate Transaction By GCC Citizen",
            description = "Create Real Estate Transaction By GCC Citizen")
    public void createRealEstateTxn_ByGCCCitizen(Map<String, String> data, ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.createRETTTxn(data,context);
    }

    @Test(dataProvider = "testDataProvider",testName = "Create Audit Case By Risk Supervisor -- GCC Citizen",
            description = "Create Audit Case By Risk Supervisor -- GCC Citizen")
    public void createAuditCaseByRiskSupervisor_ForRETT_GCCCitizen(Map<String, String> data, ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchZatcaEmployeeSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.auditPage.createAuditCaseByRISKSupervisor(data,context)
                                                            .loginToAuditofficer(data,context)
                                                            .auditCaseStudyWithFinalEvaluation(data,context)
                                                            .logoutAuditOfficer(data,context)
                                                            .loginToAuditSupervisor(data,context)
                                                            .approveAuditCase(data,context);
    }


    @Test(dataProvider = "testDataProvider",testName = "register_As Company_RETT",
            description = "Register Real Estate Transaction -- Company")
    public void register_RET_Company(Map<String, String> data) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();

        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.register_Companies(data);
    }


    @Test(dataProvider = "testDataProvider",testName = "Payment",
            description = "Payment")
    public void registerRETT_ByEnforcementAgencyAndPayTheInvoice(Map<String, String> data, ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();

        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchZatcaEmployeeSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.loginToEnfAgency(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.paymentPage.makePayment(data,context);
    }



    //Test



}