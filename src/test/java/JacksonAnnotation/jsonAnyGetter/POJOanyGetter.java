package JacksonAnnotation.jsonAnyGetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Map;

public class POJOanyGetter {
    private Map<String,Object> values;

    @JsonAnyGetter
    public Map<String, Object> getValues() {
        return values;
    }

    //@JsonAnyGetter
    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

/**
 * using this anoation in setter no effect - we don't get any exception
 */

}
