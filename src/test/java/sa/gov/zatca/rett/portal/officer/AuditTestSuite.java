package sa.gov.zatca.rett.portal.officer;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import sa.gov.zatca.rett.ZatcaRETTPortal;
import sa.gov.zatca.rett.base.ZatcaBrowserCaps;

import java.util.Map;

public class AuditTestSuite extends ZatcaBrowserCaps {



    @Test(dataProvider = "testDataProvider",testName = "Create Audit Case_with approval from RISK and Audit Dept_CloseAuditCase_Companies",
            description = "Create Audit Case_with approval from RISK and Audit Dept_CloseAuditCase_Companies")
    public void closeAuditCase_Companies(Map<String, String> data,ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.register_RETTTXNs_Companies(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.paymentPage.makePayment(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.verifyInvoice(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchZatcaEmployeeSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.auditPage.createAuditCaseByRISKSupervisor(data,context)
                .loginToAuditofficer(data,context)
                .close_AuditCase(data,context)
                .logoutAuditOfficer(data,context)
                .loginToAuditSupervisor(data,context)
                .approveCloseAudit_ByRiskSuprevisor(data,context);


    }

    @Test(dataProvider = "testDataProvider",testName = "Create Audit Case_FinalEvaluation_RejectBySupervisor",
            description = "Create Audit Case_FinalEvaluation_RejectBySupervisor")
    public void FinalEvaluationAuditCase_RejectByRISKSupervisor_Companies(Map<String, String> data,ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.register_RETTTXNs_Companies(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.paymentPage.makePayment(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.verifyInvoice(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchZatcaEmployeeSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.auditPage.createAuditCaseByRISKSupervisor(data,context)
                .loginToAuditofficer(data,context)
                .auditCaseStudyWithFinalEvaluation(data,context)
                .logoutAuditOfficer(data,context)
                .loginToAuditSupervisor(data,context)
                .rejectFinalEvaluation_ByRiskSuprevisor(data,context);


    }

    @Test(dataProvider = "testDataProvider",testName = "Create Audit Case_FinalEvaluation_RejectBySupervisor",
            description = "Create Audit Case_FinalEvaluation_RejectBySupervisor")
    public void FinalEvaluationAuditCase_ApproveByRISKSupervisor_Companies(Map<String, String> data,ITestContext context) {
        ZatcaRETTPortal zatcaRETTPortal = new ZatcaRETTPortal();
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchRETTSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.register_RETTTXNs_Companies(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.paymentPage.makePayment(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettRegistrationPage.verifyInvoice(data,context);
        zatcaRETTPortal.rettTaxPayerPortal.pages.rettLoginPage.launchZatcaEmployeeSite(data);
        zatcaRETTPortal.rettTaxPayerPortal.pages.auditPage.createAuditCaseByRISKSupervisor(data,context)
                .loginToAuditofficer(data,context)
                .auditCaseStudyWithFinalEvaluation(data,context)
                .logoutAuditOfficer(data,context)
                .loginToAuditSupervisor(data,context)
                .approveFinalEvaluation_ByRiskSuprevisor(data,context);


    }





}