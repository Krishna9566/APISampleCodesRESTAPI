import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.util.List;

public class configurationcheck {

    public static void configcheck()
    {
    String json="{\n" +
            "  \"store\": {\n" +
            "    \"book\": [\n" +
            "      {\n" +
            "        \"category\": \"reference\",\n" +
            "        \"author\": \"Nigel Rees\",\n" +
            "        \"title\": \"Sayings of the Century\",\n" +
            "        \"price\": 8.95\n" +
            "      },\n" +
            "      {\n" +
            "        \"category\": \"fiction\",\n" +
            "        \"author\": \"Herman Melville\",\n" +
            "        \"title\": \"Moby Dick\",\n" +
            "        \"isbn\": \"0-553-21311-3\",\n" +
            "        \"price\": 8.99\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    //normal read file
/*        List<String> values=JsonPath.read(json,"$..category");
        System.out.println(values);*/

       Configuration configuration =Configuration.defaultConfiguration();

       configuration=configuration.
               addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL).
               addOptions(Option.ALWAYS_RETURN_LIST);
          //configuration=configuration.addOptions(Option.REQUIRE_PROPERTIES);  //$.store.book[*].isbn

/*       Configuration configuration1=Configuration.
               builder().
               options(Option.DEFAULT_PATH_LEAF_TO_NULL).
               build();*/

        List<String> values=JsonPath.parse(json,configuration).read("$.store.book[*].isbn");
        System.out.println(values);
    }

    public static void main(String[] args) {
configcheck();
    }
}
