package JacksonAnnotation.jsonGetter;

import com.fasterxml.jackson.annotation.JsonGetter;

public class POJOClass
    {
        private String name;
        private String id;

        public void setName(String name) {
            this.name = name;
        }
        public void setId(String id) {
            this.id = id;
        }

        @JsonGetter(value="gettername")
        public String getname()
        {
            return name;
        }
        public String getid(){
            return id;
        }
    }

