package pl.edu.wszib.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public boolean authenticateUser(User user) {
        User userFormDb = this.userDAO.getUserByLogin(user.getLogin());

        if(userFormDb != null &&
                userFormDb.getPass().equals(DigestUtils.md5Hex(user.getPass()))) {
            return true;
        }

        return false;
    }
}
