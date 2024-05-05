package com.plataformasHeterogeneas.ProyectoPlataformasApi.servicio;

import com.plataformasHeterogeneas.ProyectoPlataformasApi.Repository.UserRepository;
import com.plataformasHeterogeneas.ProyectoPlataformasApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
    @Override
    public User getUserByName(String name){
        Iterable<User> userRepositoryAll = userRepository.findAll();
        if (!userRepositoryAll.iterator().hasNext()){
            return null;
        }
        for(User u : userRepositoryAll){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }
    @Override
    public User searchUser(String name){
        User user = getUserByName(name);
        if(!user.equals(null)){
            User dummy = user;
            dummy.setId(0);
            dummy.setPassword("REDACTED");
            return dummy;
        }
        return null;
    }
    @Override
    public User registerUser(User U) {
        return userRepository.save(U);
    }

    @Override
    public User loginUser(String name, String password) {
        User user = getUserByName(name);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(long id) {
        try{
            Optional<User> a = getUserById(id);
            userRepository.delete(a.get());
            return true;
        }catch (Exception ex){
            //logger.warn(ex.getMessage())
            return false;
        }
    }
}