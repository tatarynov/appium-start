package support.adb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdbController {

    public String adbLocation = System.getenv("ANDROID_HOME") + "/platform-tools/adb ";
    private Process process;
    private static Logger LOG = LoggerFactory.getLogger(AdbController.class);

    public boolean installPackage(String packageName) {
        String command = String.format(" install -r " + packageName);
        String result = executeAdbCommand(command);
        LOG.info("Install package: " + packageName + " result is" + result);
        return result.contains("Success");
    }

    public boolean uninstallPackage(String packageName) {
        String command = " uninstall " + packageName;
        String result = executeAdbCommand(command);
        LOG.info("Uninstall package: " + packageName + " result is" + result);
        return result.contains("Success");
    }

    /**
     * Execute any ADB commands
     */
    public String executeAdbCommand(String command) {
        LOG.debug("Executing ADB Command adb " + command);
        StringBuilder output = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(adbLocation + command);
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public String getCurrentForegroundActivityName() {
        return executeAdbCommand("shell dumpsys window windows | grep mCurrentFocus").trim();
    }
}
