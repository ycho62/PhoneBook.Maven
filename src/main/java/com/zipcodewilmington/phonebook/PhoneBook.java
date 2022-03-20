package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = new LinkedHashMap<>();
        this.phonebook.putAll(map);
    }

    public PhoneBook() {
        this(new HashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if(phonebook.containsKey(name)) {
                phonebook.get(name).add(phoneNumber);
            }else

            phonebook.put(name, new ArrayList<>());
            phonebook.get(name).add(phoneNumber);

    }

    public void addAll(String name, String... phoneNumbers) {
        if(phonebook.get(name)==null) {
            phonebook.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
        }else phonebook.get(name).add(Arrays.toString(phoneNumbers));
//phonebook.computeIfAbsent( name, k -> new ArrayList<>(Array.asList(phoneNumbers)));
}

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String,List<String>>phonebook : phonebook.entrySet()) {
            String name = phonebook.getKey();
            List<String> phoneNumbers = phonebook.getValue();
            for(String number : phoneNumbers) {
                if (number==phoneNumber) {
                    return name;
                }
            }

        }
        return null;
    }

    public List<String> getAllContactNames() {
       return Arrays.asList((phonebook.keySet()).toArray(new String[phonebook.size()]));
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
