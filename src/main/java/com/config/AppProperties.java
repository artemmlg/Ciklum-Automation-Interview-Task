package com.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface AppProperties extends Config {
    @Key("host.protocol")
    @DefaultValue("http://")
    String protocol();

    @Key("host.url")
    String url();

    @Key("user.login")
    String login();

    @Key("user.password")
    String password();

}
