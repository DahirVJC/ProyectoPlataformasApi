package com.plataformasHeterogeneas.ProyectoPlataformasApi.servicio;

import com.plataformasHeterogeneas.ProyectoPlataformasApi.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);
    User getUserByName(String name);
    User register(User U);
    User login(String name, String password);
    void increaseEnemiesDefeated(long id);
    boolean deleteUser(long id);
}
