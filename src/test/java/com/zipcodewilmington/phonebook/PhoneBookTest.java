package com.zipcodewilmington.phonebook;

import jdk.internal.jline.internal.TestAccessible;
import jdk.nashorn.internal.AssertsEnabled;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest() {
        // Given a phonebook exists
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "1234567";

        // When a name is added to the phonebook
        phonebook.add(name, phoneNumber);
        String retrievedNumber = phonebook.lookup(name);

        // Then the retrieved number should equal the phone number associated with the name added
        Assert.assertEquals(phoneNumber, retrievedNumber);
    }

    @Test
    public void removeTest() {
        // Given a phonebook exists and a name and number are added to it
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "123-4567";
        phonebook.add(name, phoneNumber);

        // When we remove the contact from the phonebook & try to look them up by their name
        phonebook.remove(name);
        String retrievedNumber = phonebook.lookup(name);

        // Then the retrieved phone number should be null since the contact no longer exists
        Assert.assertNull(retrievedNumber);
    }

    @Test
    public void lookupTest() {
        // Given a phonebook exists and a name and number are added to it
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "123-4567";
        phonebook.add(name, phoneNumber);

        // When we lookup the person by their name, their phone number should be returned
        String retrievedNumber = phonebook.lookup(name);

        // Then the retrieved number should match the number we added to the phonebook
        Assert.assertEquals(phoneNumber, retrievedNumber);
    }

    @Test
    public void reverseLookupTest() {
        // Given a phonebook exists and a name and number are added to it
        PhoneBook phonebook = new PhoneBook();
        String name = "name";
        String phoneNumber = "123-4567";
        phonebook.add(name, phoneNumber);

        // When we reverse lookup a person by their number, their name should be returned
        String retrievedName = phonebook.reverseLookup(phoneNumber);

        // Then the retrieved name should match the name we added to the phonebook
        Assert.assertEquals(name, retrievedName);
    }

    @Test
    public void displayTest() {
        // Given a phonebook exists and a bunch of names and numbers are added to it
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("Elsa", "543-6789");
        phonebook.add("Daniel", "456-9876");
        phonebook.add("Audrey", "345-9845");

        // When the display function is called, an alphabetical list of names and numbers should be returned
        String listOfNamesAndNumbers = phonebook.display();

        // Then the list of numbers should show Audrey, Daniel, and Elsa (and their numbers) in that order
        Assert.assertEquals("Audrey 345-9845\nDaniel 456-9876\nElsa 543-6789", listOfNamesAndNumbers);
    }
}
