package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public void addUsers(User user);
    public User userById(Long id);
    public User update(User user);

    public void delete(Long id);
}
