package com.HAVOK.TL_API.Service;

import com.HAVOK.TL_API.Model.User;
import com.HAVOK.TL_API.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public List<User> get(){
        return this.ur.findAll();
    }

    public Optional<User> getById(Integer id){
        return this.ur.findById(id);
    }

    public List<User> getByUserName(String username){
        return this.ur.getUsersByUserName(username);
    }

    public Optional<User> getByEmail(String mail){
        return this.ur.getUserByEmail(mail);
    }
}
