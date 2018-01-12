package support.utils;

import static support.utils.PlatformManager.Platform.ANDROID;
import static support.utils.PlatformManager.Platform.IOS;
import static support.utils.PlatformManager.Platform.WEB;

public class PlatformManager {

    private Platform platform;
    private Browser browser;

    public enum Platform {
        IOS,
        ANDROID,
        WEB
    }

    public enum Browser {
        CHROME,
        SAFARI,
    }

    public PlatformManager.Platform getPlatform() {
        String property = System.getProperty("platform", "android");
        PlatformManager.Platform platform = null;
        switch (property) {
            case "android":
                platform = ANDROID;
                break;
            case "ios":
                platform = IOS;
                break;
            case "web":
                platform = WEB;
                break;
        }
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public PlatformManager.Browser getBrowser() {
        String property = System.getProperty("browser", "chrome");
        PlatformManager.Browser browser = null;
        switch (property) {
            case "chrome":
                browser = PlatformManager.Browser.CHROME;
                break;
            case "safari":
                browser = PlatformManager.Browser.SAFARI;
                break;
        }
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }


}
