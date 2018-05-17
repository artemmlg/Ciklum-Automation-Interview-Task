package com.api;

import com.config.AppProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class WrestlerController {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    private RequestSpecification requestSpecification;
    private WrestlerModel wrestlerModel;

    public WrestlerController(WrestlerModel wrestlerModel) {
        this.wrestlerModel = wrestlerModel;

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(appProperties.protocol() + appProperties.url())
                .setBasePath(appProperties.path())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

        RestAssured.defaultParser = Parser.JSON;
    }

    private Map<String, String> loginToSiteAndGetSessionId() {
        baseURI = appProperties.protocol() + appProperties.url() + appProperties.endpointLogin();
        HashMap<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("username", appProperties.login());
        jsonAsMap.put("password", appProperties.password());

        return given()
                .contentType(ContentType.JSON)
                .body(jsonAsMap)
                .when().post()
                .getCookies();
    }

    public WrestlerModel createNewWrestler() {
        return given(requestSpecification)
                .body(wrestlerModel)
                .expect()
                .statusCode(200)
                .with()
                .cookies(loginToSiteAndGetSessionId())
                .post(appProperties.endpointCreate())
                .as(WrestlerModel.class);
    }
}
