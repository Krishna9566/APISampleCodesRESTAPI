package complexJSON;

public class datasClass {

    private String city;
    private String state;
    private String country;
    private locationdatas location;
    private currentdatavalues current;

    public currentdatavalues getCurrent() {
        return current;
    }

    public void setCurrent(currentdatavalues current) {
        this.current = current;
    }

    public locationdatas getLocation() {
        return location;
    }

    public void setLocation(locationdatas location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
