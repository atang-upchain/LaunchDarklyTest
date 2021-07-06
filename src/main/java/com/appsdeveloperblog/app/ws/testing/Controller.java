package com.appsdeveloperblog.app.ws.testing;
//import com.upchain.logging.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.launchdarkly.sdk.*;
import com.launchdarkly.sdk.server.*;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("test")
public class Controller {

    private static Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);
    LDClient ldClient = new LDClient("sdk-9e47d71f-dc78-48ba-9e3c-4f6635bbd253");

    /*
    @GetMapping
    public String hello(){
        LDUser user = new LDUser("user@test.com");
        boolean capital = ldClient.boolVariation("feature-flag-test-andrew-qi-tang", user, false);
        if(capital){
            logger.info("Uppercase");
            return "HELLO";
        }
        logger.info("Lowercase");
        return "hello";
    }
    */

    @GetMapping
    public String getString(){
        LDUser user = new LDUser("user@test.com");
        int toggleLevel = ldClient.intVariation("logger-level-toggle-test-andrew-qi-tang", user, Level.DEBUG.toInt());
        logger.setLevel(Level.toLevel(toggleLevel));
        logger.debug("you should not see this");
        String s = ldClient.stringVariation("multivariate-string-flag-test-andrew-qi-tang", user, "");
        if(s.equals("")){
            logger.error("Error");
        }
        else {
            logger.info("It works");
        }
        return s;
    }
}

