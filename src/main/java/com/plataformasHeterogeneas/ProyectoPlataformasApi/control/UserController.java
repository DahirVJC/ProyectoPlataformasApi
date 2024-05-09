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
        return userService.register(u);
    }

    @GetMapping("/login")
    @ResponseBody
    public User getUserByIdAndName(@RequestParam String name, @RequestParam String password){
        // ?name=x&password=x
        return userService.login(name, password);
    }

    @GetMapping("/find/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PutMapping("/increase/{id}")
    public String increaseEnemiesDefeated(@PathVariable long id){
        userService.increaseEnemiesDefeated(id);
        return HttpStatus.OK.toString();
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
        userService.register(u);
        return HttpStatus.OK.toString();
    }
}