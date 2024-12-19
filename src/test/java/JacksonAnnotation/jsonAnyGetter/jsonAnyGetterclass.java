package JacksonAnnotation.jsonAnyGetter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class jsonAnyGetterclass {
    public static void main(String[] args) throws JsonProcessingException {

        POJOanyGetter pojo = new POJOanyGetter();

        Map<String,Object> data= new HashMap<>();
        data.put("name","Krishna");
        data.put("id",1);
        data.put("age",30);

        pojo.setValues(data);

        ObjectMapper mapper = new ObjectMapper();

        String result=mapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(pojo);
        System.out.println(result);

    }
}
/** the values without using jsonanygetter
 * to remove map value in the json use this class
 * {
 *   "values" : {
 *     "name" : "Krishna",
 *     "id" : 1,
 *     "age" : 30
 *   }
 * }
 */

/**
 * afetr using this annotation in pojo
 * {
 *   "name" : "Krishna",
 *   "id" : 1,
 *   "age" : 30
 * }
 */
