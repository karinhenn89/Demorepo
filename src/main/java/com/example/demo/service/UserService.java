package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service                                    //ütleb applicatsioonile, et on service classiga tegemist

public class UserService {

    private List<User> users = new ArrayList<>(List.of(             //See on MUUTUJA-private -et oleks kasutatav ainult klassi sees
            new User(1L, "Alice", "alice@example.com"),
            new User(2L, "Bob", "bob@example.com"),
            new User(3L, "Charlie", "charlie@example.com")));


    public List<User> printUsers() {
        return users;
    }

    public String removeUserById(Long id) {
        /*System.out.println("users before: " + users);*/
        for (User u : users) {
            if ((u.getId().equals(id))) {
                users.remove(u);
                return "User with ID " + id + " has been deleted." + users.toString();
            }
        }
        System.out.println("after for: " + users);
        return "User ID: " + id + " is not found!" + users.toString();
    }

    public String addUser(User user){

        users.add(user);
        return "User " + user.getName()+" has been added.";
    }

    public String updateUserDetails(Long id, User user) {
        for (User u : users) {
            if (user.getId().equals(id)) {
                u.setEmail(u.getEmail());

                return users.toString();
        }
        }

        return "";
    }

    public User getUser() {
        return new User(1L, "John Doe", "john.doe@example.com");
    }

    public String hello() {
        return "Hello World";
    }

    public List<User> multipleUsers() {          //loome list kasutajatest
        User user1 = new User(1L, "First User", "first.user@example.com");      //loome kolm uut objekti - kasutajat
        User user2 = new User(2L, "Second User", "second.user@example.com");
        User user3 = new User(3L, "Third User", "third.user@example.com");
        List<User> userList = new ArrayList<>();                                               //koostame uue listi, paneme kasutajad array listi
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }

    public Map<Integer, String> getFruits() {
        Map<Integer, String> fruits = new HashMap<>();
        fruits.put(1, "Apple");
        fruits.put(2, "Banana");
        fruits.put(3, "Orange");

        return fruits;
    }

    public String getUserID(int userId) {
        return "User ID: " + userId;
    }

    //Exercise 1 – Simple Greeting Endpoint
    //Objective: Create a @GetMapping endpoint that takes a name as a path variable and returns a greeting message.
    //Instructions:
    //Create a method called greetUser that accepts a name as a @PathVariable.
    //Return a greeting message, like "Hello, [name]!"
    public String greetUser(String userName) {
        return "Hello, " + userName + "!";
    }

    //Exercise 2 – Square a Number
    //Objective: Create an endpoint that takes a number as a path variable and returns the square of that number.
    //Instructions:
    //Define a new method in a controller class called squareNumber.
    //Use @PathVariable to retrieve the number from the URL.
    //Return the square of the number.
    public String squareNumber(int numbeer) {
        int squarenum = numbeer * numbeer;

        return "Square of " + numbeer + " is " + squarenum;
    }

    //Exercise 3 – Retrieve User by ID from a List
    //Objective: In this task, you will create a Spring Boot RESTful API that retrieves a user from a predefined list by their ID using a simple for loop.
    //Define a List<User> containing a few sample User objects. The list should contain at least 3 users with different ids.
    //Create a @GetMapping method that retrieves a user by their id. Use @PathVariable to get the id from the URL.
    //Inside the method, use a for loop to search through the list of users and return the user whose id matches the id in the URL. If no match is found,
    // return null.
    public User userIdOneUser(Long id) {          //loome list kasutajatest

        User user1 = new User(1L, "Bloody Mary", "first.user@example.com");      //loome kolm uut objekti - kasutajat
        User user2 = new User(2L, "Martiini Class", "second.user@example.com");
        User user3 = new User(3L, "What aHeck", "third.user@example.com");

        List<User> userList = new ArrayList<>();                                               //koostame uue listi, paneme kasutajad array listi
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        for (User user : userList) {
            if (user.getId().equals(id)) {              //user.getId() == id ---sedasi saaks ka selle näite puhul
                return user;
            }
        }
        return null;
    }

    // Create a @GetMapping method that retrieves a user by their id and order id. Use @PathVariable to get the id and order id from the URL.
    public String getUserbyId(int id,
                              int orderId) {
        String order = "User ID: " + id + ", have an order nr: " + orderId;
        return order;
    }
    //URL reale:
    //http://localhost:8080/api/users/fullname?firstName=kati&lastName=mati
    // määrame ise väärtused. fullname?firstName=PANEISEEESNIMI&lastname=PANEISEPEREKONNANIMI

    public String fullname(String firstName, String lastName) {
        return "Fullname is: " + firstName + " " + lastName;
    }

    ////GetMapping - @RequestParam
    ////Exercise 1 - Greeting Message with Custom Name and Language
    //Create an endpoint that returns a greeting message in different languages based on user input.
    //Endpoint: /greet-by-language
    //Parameters:
    //name: The name of the person to greet (default to "World" if not provided).
    //language: The language of the greeting (en for English, es for Spanish, fr for French, etc.)
    //Expected Behavior:
    //If name is "Alice" and language is es, return "Hola, Alice!".
    //If no name is provided, return a greeting with "World" as the default name.
    //Hint: Use switch statements to check the language parameter.

    //
    //  http://localhost:8080/api/users/greet-by-language?firstName=Alice&language=en
    public String greetByLanguage(String firstName,
                                  String language) {

        switch (language) {
            case "en":
                return "Hello" + " " + firstName + "!";
            case "es":
                return "Hola, " + firstName + "!";
            case "fr":
                return "Bonjorno, " + firstName + "!";
            default:
                return "tere";
        }
    }
}