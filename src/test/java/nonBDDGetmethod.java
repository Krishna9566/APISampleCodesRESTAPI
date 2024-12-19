import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class nonBDDGetmethod {

    public static void getmethodone()
    {
        RestAssured.baseURI="https://petstore.swagger.io";

        RequestSpecification requestSpecification = RestAssured.given();
        Response response=requestSpecification.request(Method.GET,"/v2/pet/1114");

        System.out.println(response.asPrettyString());
        System.out.println(response.asString());
        System.out.println(response.getStatusLine());


    }
    public static void postmethodone()
    {
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
        //File file = new File("data.json");
        File file = new File("/Users/mankind/Krishnacodes/maven_API/data.json");

        RequestSpecification requestSpecification=RestAssured.given().
                header("Content-Type","application/json").
                body(file);

        Response response=requestSpecification.request(Method.POST);

        System.out.println(response.asPrettyString());
        System.out.println(response.getContentType());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }

    public static void putupdatemethod()
    {
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";

        RequestSpecification requestSpecification=RestAssured.
                given().
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"id\": 1113,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"bb_act\"\n" +
                        "  },\n" +
                        "  \"name\": \"krishna\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"tension\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}");

        Response response=requestSpecification.request(Method.PUT);
        System.out.println(response.asPrettyString());
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusLine());
    }

    public static void main(String[] args) {
        getmethodone();
        //postmethodone();
        //putupdatemethod();
    }
}
