package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUser();

    void updateUser(User user);
    User findById(Long id);

    void removeById(Long id);
}
