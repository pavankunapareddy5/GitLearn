package sa.gov.zatca.rett.portal.taxpayer.web.pages;

import com.example.base.Actions;
import com.example.base.DriverManager;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Map;

import static sa.gov.zatca.rett.portal.taxpayer.web.objects.PaymentPageObjects.*;

public class PaymentPage {

    public PaymentPage makePayment(Map<String, String> data, ITestContext context) {

        Actions.openNewTab();
        ArrayList<String> tabs = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
        Actions.sleep(2);
        Actions.openUrl("https://stgrettfe01.mygazt.gov.sa:1008/sadad-payment-mock");
        Actions.enterText(TXT_SADADNUMBER,context.getAttribute("InvoiceNumber").toString(),"Enter Sadad Number");
        Actions.enterText(TXT_AMOUNT,context.getAttribute("InvoiceAmount").toString());
        Actions.click(BTN_PAYMENTSUBMIT,"Clicked on Payment Sumbit Button");
        Actions.sleep(3);
        DriverManager.getDriver().switchTo().window(tabs.get(0));



        return this;

    }

}
