package flutter.plugins.contactsservice.contactsservice;

import java.util.HashMap;

public class PostalAddress {

    public String label, street, city, postcode, region, country;
    int type;

    public PostalAddress(String label, String street, String city, String postcode, String region, String country, int type) {
        this.label = label;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.region = region;
        this.country = country;
        this.type = type;
    }

    HashMap<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("label", label);
        result.put("street", street);
        result.put("city", city);
        result.put("postcode", postcode);
        result.put("region", region);
        result.put("country", country);
        result.put("type", String.valueOf(type));
        return result;
    }

    public static PostalAddress fromMap(HashMap<String, String> map) {
        String label = map.get("label");
        String street = map.get("street");
        String city = map.get("city");
        String postcode = map.get("postcode");
        String region = map.get("region");
        String country = map.get("country");
        String type = map.get("type");
        return new PostalAddress(label, street, city, postcode, region, country, type != null ? Integer.parseInt(type) : -1);
    }

}
