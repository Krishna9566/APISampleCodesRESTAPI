package JacksonAnnotation.jsonRootname;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class jsonRootnameClass {

    public static void main(String[] args) throws JsonProcessingException {

        rootnamePOJO pojo = new rootnamePOJO();

        pojo.setName("Krishna");
        pojo.setId("id");
        pojo.setAge("30");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);  //to tell mapper to consider jsonrootname in pojo

        String result=mapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(pojo);
        System.out.println(result);
    }
}
/**
 * before rootname
 * {
 *   "name" : "Krishna",
 *   "id" : "id",
 *   "age" : "30"
 * }
 */

/**
 * after adding rootname
 * to add dictionary value in the existing pojo
 *{
 *   "jsonrootname" : {
 *     "name" : "Krishna",
 *     "id" : "id",
 *     "age" : "30"
 *   }
 * }
 */
