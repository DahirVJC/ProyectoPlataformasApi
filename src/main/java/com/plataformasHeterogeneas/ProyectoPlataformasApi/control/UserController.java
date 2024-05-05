package com.plataformasHeterogeneas.ProyectoPlataformasApi.control;

import com.plataformasHeterogeneas.ProyectoPlataformasApi.model.User;
import com.plataformasHeterogeneas.ProyectoPlataformasApi.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public User registerUser(@RequestBody User u){
        return userService.registerUser(u);
    }

    @GetMapping("/login")
    @ResponseBody
    public User getUserByIdAndName(@RequestParam String name, @RequestParam String password){
        // ?name=x&password=x
        return userService.loginUser(name, password);
    }

    @GetMapping("/find/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @GetMapping("/search/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.searchUser(name);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable long id){
        if(getUserById(id).isEmpty()) {
            //logger.info()
            return false;
        }
        return userService.deleteUser(id);
    }
    @PutMapping("update")
    public String updateUser(@RequestBody User u){
        userService.registerUser(u);
        return HttpStatus.OK.toString();
    }
}