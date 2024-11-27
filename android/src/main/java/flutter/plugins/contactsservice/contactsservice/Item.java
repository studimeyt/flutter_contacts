package flutter.plugins.contactsservice.contactsservice;

import java.util.HashMap;

/***
 * Represents an object which has a label and a value
 * such as an email or a phone
 ***/
public class Item {

    public String label, value;
    int type;

    public Item(String label, String value, int type) {
        this.label = label;
        this.value = value;
        this.type = type;
    }

    HashMap<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("label", label);
        result.put("value", value);
        result.put("type", String.valueOf(type));
        return result;
    }

}