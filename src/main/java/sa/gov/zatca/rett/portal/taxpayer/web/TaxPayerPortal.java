package sa.gov.zatca.rett.portal.taxpayer.web;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.base.Actions;
import com.example.base.DriverManager;
import com.example.report.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sa.gov.zatca.rett.portal.taxpayer.web.pages.TaxPayerLoginPage;

import java.util.Map;
import java.util.Objects;

public class TaxPayerPortal {

    public TaxPayerLoginPage loginPage;

    public TaxPayerPortal() {
        loginPage = new TaxPayerLoginPage();
    }

    public void openApplication(Map<String, String> data) {
        Actions.openUrl(data.get("URL"));
        Actions.takeScreenshot();

    }


}
