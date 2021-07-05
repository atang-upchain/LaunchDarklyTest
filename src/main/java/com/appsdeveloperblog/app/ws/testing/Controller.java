package com.appsdeveloperblog.app.ws.testing;
import com.upchain.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.launchdarkly.sdk.*;
import com.launchdarkly.sdk.server.*;

@RestController
@RequestMapping("test")
public class Controller {

    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    LDClient ldClient = new LDClient("sdk-9e47d71f-dc78-48ba-9e3c-4f6635bbd253");

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

}

