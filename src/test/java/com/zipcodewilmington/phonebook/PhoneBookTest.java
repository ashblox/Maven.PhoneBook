package com.zipcodewilmington.phonebook;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest1() {
        // Given a phonebook exists
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(phoneNumber);

        // When a new name is added to the phonebook
        phonebook.add(name, phoneNumber);
        ArrayList<String> actual = phonebook.lookup(name);

        // Then the retrieved number(s) should equal the phone number associated with the name added
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2() {
        // Given a phonebook exists with a contact (name & number) pre-existing; and a new phone number exists
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String initialPhoneNumber = "";
        phonebook.add(name, initialPhoneNumber);
        String newPhoneNumber = "";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(initialPhoneNumber);
        expected.add(newPhoneNumber);


        // When a name is added to the phonebook
        phonebook.add(name, newPhoneNumber);
        ArrayList<String> actual = phonebook.lookup(name);

        // Then the retrieved number should equal the phone number associated with the name added
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecordTest() {
        // Given a phonebook exists with a given name and number
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "";
        phonebook.add(name, phoneNumber);

        // When we remove the contact from the phonebook & try to look them up by their name
        phonebook.removeRecord(name);
        ArrayList<String> retrievedNumbers = phonebook.lookup(name);

        // Then the retrieved list of numbers should be null since the contact no longer exists
        Assert.assertNull(retrievedNumbers);
    }

    @Test
    public void lookupTest() {
        // Given a phonebook exists with a given name and number
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber1 = "";
        phonebook.add(name, phoneNumber1);
        String phoneNumber2 = "";
        phonebook.add(name, phoneNumber2);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(phoneNumber1);
        expected.add(phoneNumber2);

        // When we lookup the person by their name, their phone number should be returned
        ArrayList<String> actual = phonebook.lookup(name);

        // Then the retrieved number should match the number we added to the phonebook
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookupTest() {
        // Given a phonebook exists and a name and set of numbers are added to it
        PhoneBook phonebook = new PhoneBook();
        String expected = "name";
        String phoneNumber1 = "";
        phonebook.add(expected, phoneNumber1);
        String phoneNumber2 = "";
        phonebook.add(expected, phoneNumber2);

        // When we reverse lookup a person by their number, their name should be returned
        String actual = phonebook.reverseLookup(phoneNumber1);

        // Then the retrieved name should match the name we added to the phonebook
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayTest() {
        // Given a phonebook exists and a bunch of names and numbers are added to it
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Elsa", "543-6789");
        phonebook.add("Daniel", "456-9876");
        phonebook.add("Daniel", "567-3467");
        phonebook.add("Audrey", "345-9845");
        phonebook.add("Elsa", "345-8764");
        String expected = "Audrey 345-9845\nDaniel 456-9876 567-3467\nElsa 543-6789 345-8764";

        // When the display function is called, an alphabetical list of names and numbers should be returned
        String actual = phonebook.display();

        // Then the list of numbers should show Audrey, Daniel, and Elsa (and their numbers) in that order
        Assert.assertEquals(expected, actual);
    }
}
