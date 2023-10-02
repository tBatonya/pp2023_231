package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional
    public void addUsers(User user) {
        userDao.addUsers(user);
    }

    @Override
    @Transactional
    public User userById(Long id) {

        return userDao.userById(id);
    }

    @Transactional
    @Override
    public void update(User updateUser) {
        userDao.update(updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
