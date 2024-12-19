package JacksonAnnotation.jsonpropertyorder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({"id","age","name"})
@JsonPropertyOrder(alphabetic = true)
public class POJOClassJsonProperty
    {
        private String name;
        private String id;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

    }

/**
 * JSOn gets in the way we declare variables in POJO - we can change using this method
 * Using JSONgetters also change sin the JSON values
 */

