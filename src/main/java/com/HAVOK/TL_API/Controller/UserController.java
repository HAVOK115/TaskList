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

    // User methods
    @GetMapping(path = "/get")
    public List<User> get(){
        return this.us.get();
    }

    @GetMapping(path = "/get/{id}")
    public Optional<User> getById(@RequestParam(name = "id") Integer id){
        return this.us.getById(id);
    }
}
