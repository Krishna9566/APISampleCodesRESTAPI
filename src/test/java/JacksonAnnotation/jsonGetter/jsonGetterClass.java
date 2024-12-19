package JacksonAnnotation.jsonGetter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonGetterClass extends POJOClass{

    public static void main(String[] args) throws JsonProcessingException {

        POJOClass pojo = new POJOClass();

        pojo.setName("Krishna");
        pojo.setId("id");
        //pojo.setName("Gayathri");

        ObjectMapper mapper = new ObjectMapper();

        String result=mapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(pojo);
        System.out.println(result);
    }
}
