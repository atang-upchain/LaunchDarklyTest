package com.appsdeveloperblog.app.ws.testing;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.launchdarkly.sdk.LDUser;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dummy")
public class Dummy {
  private Logger logger = (Logger) LoggerFactory.getLogger(Dummy.class);

  @GetMapping
  public String hello(){
      logger.debug("ths should only show when level is debug");
      logger.info("this is dummy");
      return "dummy";
  }

}
