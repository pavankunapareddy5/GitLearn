package sa.gov.zatca.rett.portal.taxpayer.web.pages;

public class RETTAppPages {

    public final RETTLoginPage rettLoginPage;
    public final RETTRegistrationPage rettRegistrationPage;
    public final PaymentPage paymentPage;
    public final AuditPage auditPage;

    public RETTAppPages() {
        rettLoginPage = new RETTLoginPage();
        rettRegistrationPage = new RETTRegistrationPage();
        paymentPage = new PaymentPage();
        auditPage = new AuditPage();

    }
}
