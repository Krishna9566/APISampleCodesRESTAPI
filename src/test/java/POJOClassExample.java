//serialization and deserialization


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import java.util.ArrayList;
import java.util.List;

public class POJOClassExample {

    private String name;
    private String mail;
    private String area;
    private List<String> nickname;

    public String getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public POJOClassExample setName(String name) {
        this.name = name;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public POJOClassExample setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public List getNickname() {
        return nickname;
    }

    public POJOClassExample setNickname(List nickname) {
        this.nickname = nickname;
        return this;
    }

    public POJOClassExample setArea(String area) {
        this.area = area;
        return this;
    }

    public static void main(String[] args) throws JsonProcessingException {
        POJOClassExample pojo =new POJOClassExample();

        List<String> nickname = new ArrayList<>();
        nickname.add("logu");
        nickname.add("paithiyam");

        pojo.
                setName("gayathri").
                setArea("Pallavaram").
                setMail("beauty@gmail.com").
                setNickname(nickname);

        System.out.println(pojo.getArea() +pojo.getName() +pojo.getMail() +pojo.getNickname());

        ObjectMapper mapper =new ObjectMapper();
        System.out.println("====SERIALIZATION====");
        String datas=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
        System.out.println(datas);

        System.out.println("====DESIRIALIZATION using OBJECT MAPPER JACKSON DATABIND====");
        POJOClassExample depojo=mapper.readValue(datas,POJOClassExample.class);
        System.out.println(depojo.getArea());

        System.out.println("====DESIRIALIZATION USING JAYWAY====");

        JacksonMappingProvider mapping=new JacksonMappingProvider();

        Configuration configuration =Configuration.
                builder().
                mappingProvider(mapping).
                build();

        POJOClassExample depojoone=mapper.readValue(datas,POJOClassExample.class);
        JsonPath.
                parse(datas,configuration).
                read("$",POJOClassExample.class);
        System.out.println(depojoone.getArea());

        System.out.println("====DESIRIALIZATION USING restassured JSON PATH====");

        io.restassured.path.json.JsonPath jsonPath= io.restassured.path.json.JsonPath.from(datas);
        //POJOClassExample depojotwo=jsonPath.getObject("$",POJOClassExample.class);
        POJOClassExample depojotwo=jsonPath.getObject("",POJOClassExample.class);   //same output
        System.out.println(depojotwo.getArea());
    }
}
