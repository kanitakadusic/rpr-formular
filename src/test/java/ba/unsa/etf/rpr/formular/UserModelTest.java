package ba.unsa.etf.rpr.formular;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {
    private UserModel model;

    @BeforeEach
    void setUpUserModelTest() {
        model = new UserModel();

        ObservableList<User> list = FXCollections.observableArrayList();
        list.add(new User("firstname1", "lastname1", "email1", "username1", "password1"));
        list.add(new User("firstname2", "lastname2", "email2", "username2", "password2"));
        model.setUsers(list);
    }

    @Test
    void getUsersTest() {
        assertEquals(2, model.getUsers().size());

        assertEquals("firstname1", model.getUsers().get(0).getFirstname());
        assertEquals("lastname1", model.getUsers().get(0).getLastname());
        assertEquals("email1", model.getUsers().get(0).getEmail());
        assertEquals("username1", model.getUsers().get(0).getUsername());
        assertEquals("password1", model.getUsers().get(0).getPassword());

        assertEquals("firstname2", model.getUsers().get(1).getFirstname());
        assertEquals("lastname2", model.getUsers().get(1).getLastname());
        assertEquals("email2", model.getUsers().get(1).getEmail());
        assertEquals("username2", model.getUsers().get(1).getUsername());
        assertEquals("password2", model.getUsers().get(1).getPassword());
    }

    @Test
    void setUsersTest() {
        ObservableList<User> list = FXCollections.observableArrayList();
        list.add(new User("firstname", "lastname", "email", "username", "password"));
        model.setUsers(list);

        assertEquals(1, model.getUsers().size());

        assertEquals("firstname", model.getUsers().get(0).getFirstname());
        assertEquals("lastname", model.getUsers().get(0).getLastname());
        assertEquals("email", model.getUsers().get(0).getEmail());
        assertEquals("username", model.getUsers().get(0).getUsername());
        assertEquals("password", model.getUsers().get(0).getPassword());
    }

    @Test
    void getCurrentUserTest() {
        assertEquals("firstname1", model.getCurrentUser().getFirstname());
        assertEquals("lastname1", model.getCurrentUser().getLastname());
        assertEquals("email1", model.getCurrentUser().getEmail());
        assertEquals("username1", model.getCurrentUser().getUsername());
        assertEquals("password1", model.getCurrentUser().getPassword());
    }

    @Test
    void setCurrentUserTest() {
        model.setCurrentUser(model.getUsers().get(1));

        assertEquals("firstname2", model.getCurrentUser().getFirstname());
        assertEquals("lastname2", model.getCurrentUser().getLastname());
        assertEquals("email2", model.getCurrentUser().getEmail());
        assertEquals("username2", model.getCurrentUser().getUsername());
        assertEquals("password2", model.getCurrentUser().getPassword());
    }
}