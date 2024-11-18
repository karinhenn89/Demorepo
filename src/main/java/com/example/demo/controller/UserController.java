package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;              //instantsi muutuja. loon klassist muutuja.



    public UserController(UserService userService) {    //konstructor/constructor - sellel pole tüüpi, klassi nimetusega
        this.userService = userService;
    }

    @GetMapping("/get-all-users")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/remove-user-by-id/{id}")
    public String removeUserById(@PathVariable("id") Long id){
        return userService.removeUserById(id);
    }

    @PostMapping("add-user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update-user-details/{id}")
    public String updateUserDetails(@PathVariable("id") Long id, @RequestBody User IncomingUserData){
        return userService.updateUserDetails(id, IncomingUserData);
    }


 /*   @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }*/

    @GetMapping("/hello")
    public String hello() {
        return userService.hello();
    }

   /* @GetMapping("/multiple-users")
    public List<User> multipleUsers() {          //loome list kasutajatest
        return userService.multipleUsers();
    }*/

    @GetMapping("/fruits")
    public Map<Integer, String> getFruits() {
        return userService.getFruits();

    }

    // PathVariable
    @GetMapping("/user/{id}")
    public String getUserID(@PathVariable("id") int userId) {
        return userService.getUserID(userId);
    }

    @GetMapping("username/{name}")
    public String greetUser(@PathVariable("name") String userName) {
        return userService.greetUser(userName);
    }

    @GetMapping("users/{number}")
    public String squareNumber(@PathVariable("number") int numbeer) {
        return userService.squareNumber(numbeer);
    }

   /* @GetMapping("oneuser/{id}")
    public User userIdOneUser(@PathVariable("id") Long id) {          //loome list kasutajatest
        return userService.userIdOneUser(id);
    }*/
     @GetMapping("userorder/{userID}/order/{orderId}")
    public String getUserbyId(@PathVariable("userID") int id,
                              @PathVariable("orderId") int orderId) {
       return userService.getUserbyId(id,orderId);
    }
    @GetMapping("/fullname")
    public String fullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return userService.fullname(firstName, lastName);
    }

    @GetMapping("/greet-by-language")
    public String greetByLanguage(@RequestParam("firstName") String firstName,
                                  @RequestParam("language") String language) {
    return userService.greetByLanguage(firstName, language);

    }
}

