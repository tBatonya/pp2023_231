package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();
    public void addUsers(User user);

    public User userById(Long id);

    public User update(User user);

    public void delete(Long id);


}