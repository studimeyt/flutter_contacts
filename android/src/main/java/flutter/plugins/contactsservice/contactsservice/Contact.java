package flutter.plugins.contactsservice.contactsservice;

import java.util.ArrayList;
import java.util.HashMap;

public class Contact implements Comparable<Contact> {

    Contact(String id) {
        this.identifier = id;
    }

    String identifier;
    String displayName, givenName, middleName, familyName, prefix, suffix, company, jobTitle, note, birthday, androidAccountType, androidAccountName;
    ArrayList<Item> emails = new ArrayList<>();
    ArrayList<Item> phones = new ArrayList<>();
    ArrayList<PostalAddress> postalAddresses = new ArrayList<>();
    byte[] avatar = new byte[0];

    HashMap<String, Object> toMap() {
        HashMap<String, Object> contactMap = new HashMap<>();
        contactMap.put("identifier", identifier);
        contactMap.put("displayName", displayName);
        contactMap.put("givenName", givenName);
        contactMap.put("middleName", middleName);
        contactMap.put("familyName", familyName);
        contactMap.put("prefix", prefix);
        contactMap.put("suffix", suffix);
        contactMap.put("company", company);
        contactMap.put("jobTitle", jobTitle);
        contactMap.put("avatar", avatar);
        contactMap.put("note", note);
        contactMap.put("birthday", birthday);
        contactMap.put("androidAccountType", androidAccountType);
        contactMap.put("androidAccountName", androidAccountName);

        ArrayList<HashMap<String, String>> emailsMap = new ArrayList<>();
        for (Item email : emails) {
            emailsMap.add(email.toMap());
        }
        contactMap.put("emails", emailsMap);

        ArrayList<HashMap<String, String>> phonesMap = new ArrayList<>();
        for (Item phone : phones) {
            phonesMap.add(phone.toMap());
        }
        contactMap.put("phones", phonesMap);

        ArrayList<HashMap<String, String>> addressesMap = new ArrayList<>();
        for (PostalAddress address : postalAddresses) {
            addressesMap.add(address.toMap());
        }
        contactMap.put("postalAddresses", addressesMap);

        return contactMap;
    }

    @Override
    public int compareTo(Contact contact) {
        String givenName1 = this.givenName == null ? "" : this.givenName.toLowerCase();
        String givenName2 = contact == null ? ""
            : (contact.givenName == null ? "" : contact.givenName.toLowerCase());
        return givenName1.compareTo(givenName2);
    }
}