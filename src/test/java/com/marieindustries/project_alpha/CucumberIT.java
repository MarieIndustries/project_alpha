package com.marieindustries.project_alpha;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.marieindustries.project_alpha")
@CucumberContextConfiguration
@WebAppConfiguration
@SpringBootTest( classes = {CucumberIT.Config.class, ProjectAlphaApplication.class})
public class CucumberIT {

    static class Config {

    }
}
