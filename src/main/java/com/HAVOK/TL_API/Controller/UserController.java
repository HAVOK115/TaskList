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
    public List<User> get(@RequestParam Integer id){
        List<User> res = null;

        if(id != null){
            res = this.us.getById(id).stream().toList();
        }else{
            res = this.us.get();
        }
        return res;
    }
}
