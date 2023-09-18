package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUser();
    void removeUser(User user);
    void updateUser(User user);

    User findById(Long id);

    void removeById(Long id);

}
