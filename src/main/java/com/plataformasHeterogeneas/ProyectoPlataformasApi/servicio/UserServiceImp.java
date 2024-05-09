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
            if(u.getUserName().equals(name)){
                return u;
            }
        }
        return null;
    }
    @Override
    public User register(User U) {
        return userRepository.save(U);
    }

    @Override
    public User login(String name, String password) {
        User user = getUserByName(name);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public void increaseEnemiesDefeated(long id) {
        Optional<User> optionalUser = getUserById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            int enemies = user.getEnemiesDefeated() + 1;
            user.setEnemiesDefeated(enemies);
        }
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