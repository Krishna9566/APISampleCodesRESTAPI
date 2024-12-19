package JacksonAnnotation.jsonpropertyorder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonpropertyclass {

    public static void main(String[] args) throws JsonProcessingException {

        POJOClassJsonProperty pojoone = new POJOClassJsonProperty();
        pojoone.setAge("30");
        pojoone.setId("1");
        pojoone.setName("gayathri");

        ObjectMapper mapper = new ObjectMapper();

        String result=mapper.
                writerWithDefaultPrettyPrinter().
                writeValueAsString(pojoone);
        System.out.println(result);

    }
}

