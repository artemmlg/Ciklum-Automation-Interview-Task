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

//        RestAssured.responseSpecification = new ResponseSpecBuilder()
//                .expectContentType(ContentType.JSON)
//                .build();

        RestAssured.defaultParser = Parser.JSON;
    }

    private Map<String, String> loginToSiteAndGetSessionId() {
        HashMap<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("username", "auto");
        jsonAsMap.put("password", "test");

        baseURI = "http://streamtv.net.ua/base/php/login.php";

        return given()
                .contentType(ContentType.JSON)
                .body(jsonAsMap)
                .when().post()
                .getCookies();
        //"PHPSESSID"
    }

//    private String loginToSiteAndGetSessionId2() {
//        baseURI = "http://streamtv.net.ua/base";
//        return given().body("{\"username\":\"auto\",\"password\":\"test\"}")
//                .when().post("/php/login.php").thenReturn()
//                .getCookie("PHPSESSID");
//    }


        public WrestlerModel createNewWrestler () {
            return given(requestSpecification)
                    .body(wrestlerModel)
                    .expect()
                    .statusCode(200)
                    .with()
                    .cookies(loginToSiteAndGetSessionId())
                    .post("create.php")
                    .as(WrestlerModel.class);
        }
    }
