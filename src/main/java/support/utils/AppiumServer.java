package support.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * We can start the Appium server dynamically. With this class we can avoid the
 * manually starting of Appuim server. We need to install Nodejs app on the mac
 * and we need to set the below environment variables. we should the add below 2
 * variables in launchd.conf
 * NODE /usr/local/bin/node
 * APPIUM_PATH /Applications/Appium.app/Contents/Resources/node_modules/appium
 *
 */
public class AppiumServer {

    public static final String HOST_NAME = "127.0.0.1";
    public static final String NODE_PATH = "/usr/local/bin/node";
    public static final String APPIUM_PATH = "/usr/local/bin/appium";

    private int[] ports = new int[]{4721, 4722, 4723, 4724, 4725, 4726, 4727, 4728, 4729, 4730};
    private String appiumServerUrl;
    private Process process;

    private static final Logger LOG = LoggerFactory.getLogger(AppiumServer.class);


    public String startAppiumServer() throws Exception {
        final String homeDir = System.getProperty("user.dir") + File.separator + "target";
        final String appiumFilePath = homeDir + File.separator + "logs" + File.separator + "appiumLogs.log";
        String command;
        String appiumArgs = "--log-level debug --local-timezone --session-override ";
        int availablePort = 0;

        if (APPIUM_PATH == null || NODE_PATH == null) {
            throw new Exception(" Environment varaiable not found for APPIUM_PATH or NODE ");
        }

        for (int i = 0; i < ports.length; i++) {
            if (!isPortInUse(HOST_NAME, ports[i])) {
                availablePort = ports[i];
                LOG.info("Available port found: " + availablePort);
                break;
            }
        }
        if (availablePort == 0) {
            throw new Exception("Ports are not available");
        } else {
            command = NODE_PATH + "  " + APPIUM_PATH + " ";
            command = command + " -a " + HOST_NAME + " -p " + availablePort + " ";
            command = command + " -cp " + (availablePort + 1000) + " -bp " + (availablePort + 2000);
            command = command + " --chromedriver-port " + (availablePort + 3000);
            command = command + " " + appiumArgs;
            LOG.info("Command to start Appium Server: " + command);
        }

        process = Runtime.getRuntime().exec(command);
        process.waitFor(30, TimeUnit.SECONDS);

        LOG.info("Waiting for Appium server starts...");
        while (!isPortInUse(HOST_NAME, availablePort)) {
            Thread.sleep(1000);
        }
        appiumServerUrl = "http://" + HOST_NAME + ":" + availablePort + "/wd/hub";
        return appiumServerUrl;
    }

    public boolean isPortInUse(String hostName, int portNumber) {
        boolean result;
        try {
            Socket s = new Socket(hostName, portNumber);
            s.close();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public void killAppiumProcess() {
        String[] commangToKillAppiumProcess = {"/usr/bin/killall", "-9", "node"};
        try {
            Runtime.getRuntime().exec(commangToKillAppiumProcess);
        } catch (Exception e) {
            LOG.info("EXCEPTION OCCURED WHEN KILLING NODE");
            e.printStackTrace();
        }
    }

    public String getAppiumServerUrl() {
        return appiumServerUrl;
    }

}