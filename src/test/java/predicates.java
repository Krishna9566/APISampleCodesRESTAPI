import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class predicates {

    public static void inlinepredicate() throws IOException {
        File file =new File("src/main/resources/sample.json");

        List<Object> pricelist=JsonPath.read(file,"$.store.book[?(@.price<10)]");
        List<Object> pricelist1=JsonPath.read(file,"$.store.book[?(@.price<10 && @.category=='fiction')]");
        List<Object> pricelist2=JsonPath.read(file,"$.store.book[?(@.price<10 || @.category=='fiction')]");
        String price=JsonPath.read(file,"$.store.book[?(@.price>20)].author");  //class cast exception since we have predictaes ?@

        System.out.println(price);

        for(Object prints:pricelist2)
            System.out.println(prints);
    }

    public static void filterAPI() throws IOException {
        File file =new File("src/main/resources/sample.json");

        /*Filter filter=Filter.filter(
                Criteria.where("price").lt(10)
        );*/

        Filter filter=Filter.filter(
                Criteria.
                        where("price").
                        lt(10).
                        and("category").
                        is("fiction")
        );



        List<Object>price=JsonPath.read(file,"$.store.book[?]",filter);

        for(Object prints:price)
            System.out.println(prints);
    }

    public static void main(String[] args) throws IOException {
        //inlinepredicate();
        filterAPI();
    }
}
