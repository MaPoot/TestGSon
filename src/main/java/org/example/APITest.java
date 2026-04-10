package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import pojo.UserInfo;
import pojo.ZipInfo;

import java.io.StringReader;

import static org.hamcrest.Matchers.equalTo;

public class APITest {
    public static void main(String[] args) throws JsonProcessingException, JAXBException {
        Response response = RestAssured.given()
                .log().all()
                .get("https://api.zippopotam.us/us/33164")
                .then()
                .assertThat()
                .body("country", equalTo("United States"))
                .body("'country abbreviation'", equalTo("US"))
                .statusCode(200)
                .extract().response();

        response.prettyPrint();

        ObjectMapper mapper = new ObjectMapper();

        ZipInfo zipInfo = mapper.readValue(response.asString(), ZipInfo.class);
        System.out.println(zipInfo);

        Response response2 = RestAssured.get("https://mocktarget.apigee.net/xml")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();

        JAXBContext jaxbContext = JAXBContext.newInstance(UserInfo.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        UserInfo userInfo = (UserInfo) unmarshaller.unmarshal(new StringReader(response2.asString()));
        System.out.println(userInfo);
    }
}