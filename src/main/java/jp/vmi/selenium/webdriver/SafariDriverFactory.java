package jp.vmi.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Factory of {@link SafariDriver}.
 */
public class SafariDriverFactory extends WebDriverFactory {

    @Override
    public boolean isProxySupported() {
        return false;
    }

    @Override
    public WebDriver newInstance(DriverOptions driverOptions) {
        DesiredCapabilities caps = setupProxy(DesiredCapabilities.safari(), driverOptions);
        caps.merge(driverOptions.getCapabilities());
        SafariDriver driver = new SafariDriver(caps);
        setInitialWindowSize(driver, driverOptions);
        return driver;
    }
}
