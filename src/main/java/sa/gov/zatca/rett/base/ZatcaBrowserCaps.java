package sa.gov.zatca.rett.base;

import com.example.base.Browser;
import com.example.utils.ConfigManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ZatcaBrowserCaps extends ZatcaRETTWebTest {

    @Override
    public DesiredCapabilities addCapabilities(String testName) {
        if (Browser.valueOf(ConfigManager.getConfigProperty("browser").toUpperCase()).toString().equalsIgnoreCase("FIREFOX")) {
            return DesiredCapabilities.firefox();
        } else if (Browser.valueOf(ConfigManager.getConfigProperty("browser").toUpperCase()).toString().equalsIgnoreCase("CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            return desiredCapabilities;
        } else return null;
    }

}

