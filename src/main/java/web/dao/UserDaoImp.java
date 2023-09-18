package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> listUser() {
        return entityManager.createQuery("FROM User u", User.class)
                .getResultList();
    }

    @Override
    public void removeById(Long id) {
        removeUser(findById(id));
    }

    @Override
    public void removeUser(User user) {
        try {
            entityManager.remove(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
