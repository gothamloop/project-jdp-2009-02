package com.kodilla.ecommercee.controller;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/task")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser() {
        System.out.println("The user has been created");;
    }

    @RequestMapping(method = RequestMethod.GET, value = "blockUser")
    public void blockUser(@RequestParam Long Id) throws UserNotFoundException {
        UserDto testingUserDto = new UserDto(1L, "user1", "userDescription");
    }

    @RequestMapping(method = RequestMethod.POST, value = "generateToken", consumes = APPLICATION_JSON_VALUE)
    public String generateToken(@RequestParam String username, @RequestParam String password) {
        username = "user1";
        password ="password1";
        return "Test token";
    }
}
