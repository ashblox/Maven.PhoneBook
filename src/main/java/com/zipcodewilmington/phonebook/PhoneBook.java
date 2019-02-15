package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, String> people;

    public PhoneBook() {
        this.people = new TreeMap<String, String>();
    }

    public void add(String name, String phoneNumber) {
        people.put(name, phoneNumber);
    }

    public void remove(String name) {
        people.remove(name);
    }

    public String lookup(String name) {
        return people.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        String name = "";
        for (Map.Entry<String, String> entry: people.entrySet()) {
            if (entry.getValue() == phoneNumber) {
                name = entry.getKey();
            }
        }
        return name;
    }

    public String display() {
        String allNames = "";
        for (Map.Entry<String, String> entry: people.entrySet()) {
            allNames += entry.getKey() + " ";
            allNames += entry.getValue() + "\n";
        }
        allNames = allNames.trim();
        return allNames;
    }



}
