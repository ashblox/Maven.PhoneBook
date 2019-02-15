package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, ArrayList<String>> people;

    public PhoneBook() {
        this.people = new TreeMap<String, ArrayList<String>>();
    }

    public void add(String name, String phoneNumber) {
        if (people.containsKey(name)) {
            ArrayList<String> retrievedNumbers = people.get(name);
            retrievedNumbers.add(phoneNumber);
            people.put(name, retrievedNumbers);
        } else {
            ArrayList<String> newNumber = new ArrayList<String>();
            newNumber.add(phoneNumber);
            people.put(name, newNumber);
        }
    }

    public void removeNumber(String name, String phoneNumber) {
        ArrayList<String> numbers = lookup(name);
        for (String number: numbers) {
            if (number == phoneNumber) {
                numbers.remove(number);
            }
        }
        people.put(name, numbers);
    }

    public void removeRecord(String name) {
        people.remove(name);
    }

    public ArrayList<String> lookup(String name) {
        ArrayList<String> numbers = people.get(name);
        return numbers;
    }

    public String reverseLookup(String phoneNumber) {
        String name = "";
        for (Map.Entry<String, ArrayList<String>> entry: people.entrySet()) {
            ArrayList<String> numbers = entry.getValue();
            for (String number: numbers) {
                if (number == phoneNumber) {
                    name = entry.getKey();
                }
            }
        }
        return name;
    }

    public String display() {
        String allNames = "";
        for (Map.Entry<String, ArrayList<String>> entry: people.entrySet()) {
            allNames += entry.getKey() + " ";
            ArrayList<String> values = entry.getValue();
            for (String number: values) {
                allNames += number + " ";
            }
            allNames = allNames.trim();
            allNames += "\n";
        }
        allNames = allNames.trim();
        return allNames;
    }



}
