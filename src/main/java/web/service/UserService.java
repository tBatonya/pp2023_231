package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public void addUsers(User user);
    public User userById(Long id);
    public void update(User user);

    public void delete(Long id);
}