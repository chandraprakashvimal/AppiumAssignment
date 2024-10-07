package org.appium.utility;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumServer {
    static AppiumDriverLocalService service;
    public static void startServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        /*//Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");
        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();*/

        /*AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/opt/homebrew/Cellar/appium/2.11.3/libexec/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Appiumlog.txt"))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
        server.start();*/

    }

    public static void stopServer() {
//        service.stop();
    }

}
