package com.HAVOK.TL_API.Controller;

import com.HAVOK.TL_API.Model.User;
import com.HAVOK.TL_API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/API/v1/users")
public class UserController {
    @Autowired
    UserService us;

    /*
     * Methods that retrieves user information
     *
     * Returns all the users -> http://localhost:8080/API/v1/users/get
     * Returns all the task by their username -> http://localhost:8080/API/v1/tasks/get?user={}
     * Returns a user by the email -> http://localhost:8080/API/v1/tasks/get?email={}
     * Returns a user by the id -> http://localhost:8080/API/v1/tasks/get?id={}
     */

    @GetMapping(path = "/get")
    public List<User> get(@RequestParam(required = false) Integer id,
                          @RequestParam(required = false, name = "user") String username,
                          @RequestParam(required = false, name= "email") String mail){
        List<User> res = null;

        if(id != null){
            res = this.us.getById(id).stream().toList();
        }else if(username != null){
            res = this.us.getByUserName(username);
        }else if(mail != null){
            res = this.us.getByEmail(mail).stream().toList();
        }else{
            res = this.us.get();
        }
        return res;
    }

    // Endpoint to create an user -> http://localhost:8080/API/v1/users/create
    @PostMapping(path = "/create")
    public void create(@RequestBody User u){
        this.us.create(u);
    }

    // Endpoint to delete an user -> http://localhost:8080/API/v1/users/delete
    @DeleteMapping(path = "/delete")
    public void delete(@RequestParam(required = true, name = "id") Integer id){
        this.us.delete(id);
    }
}
