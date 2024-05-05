package com.plataformasHeterogeneas.ProyectoPlataformasApi.servicio;

import com.plataformasHeterogeneas.ProyectoPlataformasApi.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);
    User getUserByName(String name);//Returns the first user with the username name. Returns all data with no filters
    User searchUser(String name);//Hides user's sensible information
    User registerUser(User U);
    User loginUser(String name, String password);
    boolean deleteUser(long id);
}
