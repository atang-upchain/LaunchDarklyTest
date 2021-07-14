package com.appsdeveloperblog.app.ws.testing;
import com.upchain.logging.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.launchdarkly.sdk.*;
import com.launchdarkly.sdk.server.*;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("test")
public class Controller {

    private static Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);
    LDClient ldClient = new LDClient("sdk-9e47d71f-dc78-48ba-9e3c-4f6635bbd253");
    @GetMapping
    public String getString(){
        LDUser user = new LDUser("user@test.com");
        ldClient.getFlagTracker().addFlagValueChangeListener("logger-level-toggle-test-andrew-qi-tang", user, event -> {
            System.out.println("*********************Flag " + event.getKey() + " for user " + user.getKey() + " has changed from " + event.getOldValue() + " to " + event.getNewValue());
        });
       /* logger.error("this is a error log");
        String s = ldClient.stringVariation("multivariate-string-flag-test-andrew-qi-tang", user, "");
        if(s.equals("")){
            logger.error("Error");
        }
        else {
            logger.info("It works");
        }*/
        return "testing";
    }
}

