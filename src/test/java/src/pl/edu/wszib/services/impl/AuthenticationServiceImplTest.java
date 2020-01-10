package src.pl.edu.wszib.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;
import src.pl.edu.wszib.configuration.AppConfigurationTest;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.text.IsEmptyString.emptyString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
@WebMvcTest
public class AuthenticationServiceImplTest {

    @Autowired
    IAuthenticationService authenticationService;

    @MockBean
    IUserDAO userDAO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void authenticateUserTest() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPass("mateusz");
        Mockito.when(this.userDAO.getUserByLogin(anyString()))
                .thenReturn(new User(1, "mateusz",
                        "617f41f48d1d4f9c787aed6b0ebc6f7d",
                        "mateusz", "mateusz", 75));

        boolean result = this.authenticationService.authenticateUser(user);

        Assert.assertTrue(result);

        verify(this.userDAO, times(1)).getUserByLogin(any());
    }

    @Test
    public void callLoginPage() throws Exception {
        String expectedViewName = "loginForm";

        this.mockMvc.perform(get("/loginPage"))
                .andExpect(status().isOk())
                .andExpect(view().name(expectedViewName))
                .andExpect(model().attribute("errorMessage", emptyString()))
                .andExpect(model().attribute("userModel", notNullValue()));

    }

    @Test
    public void test() {
        // założenia testu

        boolean result = authenticationService.cos();

        Assert.assertTrue(result);
    }
}
