import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.io.*;
import java.util.List;

public class parsingmethodsjson {

    public static void parseEverytime() throws IOException {
        File file =new File("src/main/resources/sample.json");

        List<Object> values=JsonPath.read(file,"$..book");

        for(Object prints:values)
            System.out.println(prints);
    }
    public static void parseOnetime() throws IOException {
        InputStream file =new FileInputStream("src/main/resources/sample.json");

        Object values=Configuration.
                defaultConfiguration().
                jsonProvider().
                parse(file.readAllBytes());

        List<Object> getvalues=JsonPath.read(values,"$..price");

        for(Object prints:getvalues)
            System.out.println(prints);
    }
    public static void pathvalidation() throws IOException {
        File file =new File("src/main/resources/sample.json");

        //indefinite path
        List<Object> values=JsonPath.read(file,"$..author");

        for(Object prints:values)
            System.out.println(prints);

        //definite path
        String author=JsonPath.read(file,"$.store.book[1].author");
        System.out.println("printing definite path value --->"+author);

        //classcast exception
            String authors = JsonPath.read(file, "$..author");
            System.out.println("printing classcastexception --->" + authors);

    }

    public static void main(String[] args) throws IOException {
        //parseEverytime();
        //parseOnetime();
        pathvalidation();
    }
}
