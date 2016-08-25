import org.openqa.selenium.Proxy
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import utils.objects.Driver

driver = {
    FirefoxProfile ff = new FirefoxProfile();
    ff.setPreference("network.proxy.type", Proxy.ProxyType.AUTODETECT.ordinal());
    def driverInstance = new FirefoxDriver(ff);

    driverInstance.manage().window().maximize()
    driverInstance
    Driver.instance.driver = driverInstance
}
baseNavigatorWaiting = true
atCheckWaiting = true
reportsDir = new File("target/geb-reports")

timeout = 30.0
retryInterval = 0.5
includeCauseInMessage = true

baseUrl = "https://www.ryanair.com/"