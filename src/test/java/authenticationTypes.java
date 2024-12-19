import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class authenticationTypes {

    public static void basicauth()
    {
        RequestSpecification request= given().auth().basic("postman", "password");
        Response response=request.get("https://postman-echo.com/basic-auth");
        ResponseBody responseBody=response.body();
        String check = responseBody.asString();
        System.out.println(check);

   /*     RestAssured.baseURI="https://postman-echo.com/basic-auth";

        RequestSpecification requestSpecification = RestAssured.given().auth().basic("postman", "password");
        Response response=requestSpecification.request(Method.GET,"");

        System.out.println(response.asPrettyString());
        System.out.println(response.asString());
        System.out.println(response.getStatusLine());*/
    }

    public static void apikey()
    {
        RequestSpecification request= given();
        Response response=request
                .queryParam("key","DCJZXR5BBTRCAFFZVGYZ2NJDR")
                .get("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/London,UK");

        //ResponseBody responseBody=response.body();
        //System.out.println(responseBody.asPrettyString());

        System.out.println(response.asPrettyString());
    }

    public static void bearerToken()
    {
        String TOKEN = "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";
        String response=given()
                .header("Authorization","Bearer "+TOKEN)
                .when()
                .get("https://api.github.com/user/repos")
                .prettyPrint();

        System.out.println(response);
    }
    public static void oauth2()
    {
        String TOKEN = "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";
        String response=given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get("https://api.github.com/user/repos")
                .prettyPrint();

        System.out.println(response);

    }

    public static void main(String[] args) {
       // basicauth();
        //apikey();
        //bearerToken();
        oauth2();
    }
}
