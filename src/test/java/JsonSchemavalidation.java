import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;

import java.io.File;
import java.io.IOException;

public class JsonSchemavalidation {

    File inputfile = new File("data.json");
    File schema = new File("src/main/resources/schemafile.json");

    String finalschema=FileUtils.readFileToString(schema,"UTF-8");
    String inputfile_String=FileUtils.readFileToString(inputfile,"UTF-8");

    public JsonSchemavalidation() throws IOException {
    }

    public void validateSchema_RestAssured() throws IOException {

        RestAssured.baseURI="https://petstore.swagger.io/v2/pet";

        RestAssured.given().
                header("Content-Type","application/json").
                body(inputfile).
                when().
                post().
                then().
                //body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemafile.json"));
                body(JsonSchemaValidator.matchesJsonSchema(finalschema));
    }

    public void validateSchema_hamcrest()
    {

        MatcherAssert.assertThat(inputfile_String,
                JsonSchemaValidator.matchesJsonSchema(schema));

    }

    public static void main(String[] args) throws IOException {
        JsonSchemavalidation jsonSchemavalidation= new JsonSchemavalidation();
        //jsonSchemavalidation.validateSchema_RestAssured();
        jsonSchemavalidation.validateSchema_hamcrest();
    }
}
