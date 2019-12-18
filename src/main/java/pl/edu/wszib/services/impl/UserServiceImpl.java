package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IUserService;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void registerUser(User user) {
        User userFromDb = this.userDAO.getUserByLogin(user.getLogin());
        if(userFromDb == null) {
            this.userDAO.saveUser(user);
        }
    }

    @Override
    public User getUserByLogin(String login) {
        return this.userDAO.getUserByLogin(login);
    }
}
