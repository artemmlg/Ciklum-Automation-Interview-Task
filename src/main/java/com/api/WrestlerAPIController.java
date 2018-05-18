package com.api;

import com.config.AppProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class WrestlerAPIController {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    private RequestSpecification requestSpecification;
    private WrestlerModel wrestlerModel;

    public WrestlerAPIController(WrestlerModel wrestlerModel) {
        this.wrestlerModel = wrestlerModel;

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(appProperties.protocol() + appProperties.url())
                .setBasePath(appProperties.path())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

        RestAssured.defaultParser = Parser.JSON;
    }

    private Map<String, String> loginAndGetSessionID() {
        baseURI = appProperties.protocol() + appProperties.url() + appProperties.endpointLogin();
        HashMap<String, Object> credentialsMap = new HashMap<>();
        credentialsMap.put("username", appProperties.login());
        credentialsMap.put("password", appProperties.password());

        return given()
                .contentType(ContentType.JSON)
                .body(credentialsMap)
                .when().post()
                .getCookies();
    }

    public WrestlerModel createNewWrestler() {
        return given(requestSpecification)
                .body(wrestlerModel)
                .expect()
                .statusCode(200)
                .with()
                .cookies(loginAndGetSessionID())
                .post(appProperties.endpointCreate())
                .as(WrestlerModel.class);
    }

    public WrestlerModel readWrestler(String wrestlerID) {
        return given(requestSpecification)
                .queryParam("id", "" + wrestlerID + "")
                .with()
                .cookies(loginAndGetSessionID())
                .get(appProperties.endpointRead())
                .as(WrestlerModel.class);
    }

    public WrestlerModel updateWrestler() {
        return given(requestSpecification)
                .body(wrestlerModel)
                .expect()
                .statusCode(200)
                .with()
                .cookies(loginAndGetSessionID())
                .put(appProperties.endpointUpdate())
                .as(WrestlerModel.class);
    }

    public WrestlerModel deleteWrestler(String wrestlerID) {
        return given(requestSpecification)
                .queryParam("id", "" + wrestlerID + "")
                .with()
                .cookies(loginAndGetSessionID())
                .delete(appProperties.endpointDelete())
                .as(WrestlerModel.class);
    }
}
