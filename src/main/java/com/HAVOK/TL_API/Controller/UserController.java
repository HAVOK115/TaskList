package com.HAVOK.TL_API.Controller;

import com.HAVOK.TL_API.Model.User;
import com.HAVOK.TL_API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/API/v1/users")
public class UserController {
    @Autowired
    UserService us;

    /*
     * Methods that retrieve user information
     *
     * Returns all the users -> http://localhost:8080/API/v1/users/get
     * Returns a user by their username -> http://localhost:8080/API/v1/users/get?username={}
     * Returns a user by the email -> http://localhost:8080/API/v1/users/get?userEmail={}
     * Returns a user by the id -> http://localhost:8080/API/v1/users/get?id={}
     */

    @GetMapping(path = "/get")
    public List<User> get(@RequestParam(required = false) Integer id,
                          @RequestParam(required = false, name = "username") String username,
                          @RequestParam(required = false, name = "userEmail") String userEmail){

        if (id != null) {
            return this.us.getById(id).stream().toList();
        } else if (username != null) {
            return this.us.getByUserName(username);
        } else if (userEmail != null) {
            return this.us.getByEmail(userEmail).stream().toList();
        } else {
            return this.us.get();
        }
    }

    // Endpoint to create a user -> http://localhost:8080/API/v1/users/create
    @PostMapping(path = "/create")
    public void create(@RequestBody User u) {
        this.us.create(u);
    }

    // Endpoint to delete a user -> http://localhost:8080/API/v1/users/delete
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam(required = true, name = "id") Integer id) {
        this.us.delete(id);
    }
}
