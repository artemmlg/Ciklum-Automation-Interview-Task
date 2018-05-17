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

    @Key("host.basePath")
    String path();

    @Key("user.login")
    String login();

    @Key("user.password")
    String password();

    @Key("endpoint.login")
    String endpointLogin();

    @Key("endpoint.create")
    String endpointCreate();

    @Key("endpoint.read")
    String endpointRead();

}
