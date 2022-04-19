package sa.gov.zatca.rett.portal.taxpayer.web.pages;

import com.example.base.Actions;

import java.util.Map;

import static sa.gov.zatca.rett.portal.taxpayer.web.objects.RETTLoginPageObjects.*;


public class RETTLoginPage {

    
    


    public RETTLoginPage launchRETTSite(Map<String, String> data) {
        Actions.openUrl(data.get("Url"), "Launched url : " + data.get("Url"));
        Actions.click(BTN_LANGUAGESELECTION,"Selected English Language");
        Actions.takeScreenshot();
        return this;
        
    }

    public RETTLoginPage launchZatcaEmployeeSite(Map<String, String> data) {
        Actions.sleep(1);
        Actions.openUrl(data.get("OfficerPortalURL"), "Launched url : " + data.get("Url"));
        Actions.click(BTN_LANGUAGESELECTION,"Selected English Language");

        return this;
    }



    
}
