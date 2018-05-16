package com.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources("classpath:config.properties")
public interface WebDriverProperties extends Config {
    @Key("browser.type")
    String browserType();

    @Key("wait.implicit")
    byte waitImplicit();

    @Key("wait.explicit")
    byte waitExplicit();

    @Key("wait.page")
    byte waitPage();

    @Key("wait.script")
    byte waitScript();
}
