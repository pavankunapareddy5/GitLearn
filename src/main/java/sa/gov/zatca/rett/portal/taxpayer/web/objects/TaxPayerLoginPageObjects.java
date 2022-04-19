package sa.gov.zatca.rett.portal.taxpayer.web.objects;

import org.openqa.selenium.By;

public class TaxPayerLoginPageObjects {
    // Button
    public static final By BUTTON_Login = By.xpath("//button[@id='uidLogonBtn']");
    // Text
    public static final By TEXT_TIN_Or_Email = By.xpath("//input[@id='logonuidfield']");
    public static final By TEXT_Password = By.xpath("//input[@id='logonpassfield']");
    // Link
    public static final By Link_SignUp = By.xpath("//a[contains(text(),'Sign up')]");
}
