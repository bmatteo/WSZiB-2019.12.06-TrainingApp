package src.pl.edu.wszib.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;
import pl.edu.wszib.services.IUserService;
import src.pl.edu.wszib.configuration.AppConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
public class AuthenticationServiceImplTest {

    @Autowired
    IAuthenticationService authenticationService;

    @Test
    public void authenticateUserTest() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPass("mateusz");

        boolean result = this.authenticationService.authenticateUser(user);

        Assert.assertTrue(result);
    }
}
