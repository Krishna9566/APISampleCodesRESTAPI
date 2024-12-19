package complexJSON;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class alldataJavaClass {

    private String status;
    private datasClass data;

    public static void main(String[] args) throws IOException {

        alldataJavaClass datas=new alldataJavaClass();

        weatherDatas weatherdata=new weatherDatas();
        weatherdata.setHu(77);
        weatherdata.setIc("04n");
        weatherdata.setTs("3456-23-24435");

        populationDatas popudata=new populationDatas();
        popudata.setTs("2024-05-26");
        popudata.setAquis(30);
        popudata.setMainus("p2");

        currentdatavalues current=new currentdatavalues();
        current.setPopulation(popudata);
        current.setWeather(weatherdata);

        locationdatas locdata=new locationdatas();
        locdata.setType("Krishnakumar");
        List<String> cood=new ArrayList<>();
        cood.add("-73.40");
        cood.add("34.23");
        locdata.setCoordinates(cood);

        datasClass data=new datasClass();
        data.setCity("New York");
        data.setCountry("USA");
        data.setState("New York");
        data.setLocation(locdata);
        data.setCurrent(current);

        datas.setData(data);
        datas.setStatus("Success");

        ObjectMapper mapper=new ObjectMapper();
        String finalJSON=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(datas);
        System.out.println(finalJSON);

        File file = new File("Finalweatherreport.json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(file,datas);

    }
}
