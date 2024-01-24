package ba.unsa.etf.rpr.formular;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class UserControllerTest {
    private UserModel model;

    private ObservableList<User> loadData() {
        ObservableList<User> list = FXCollections.observableArrayList();
        list.add(new User("user", "user", "user", "user", "user"));

        return list;
    }

    @Start
    public void start(Stage stage) throws Exception {
        model = new UserModel();
        model.setUsers(loadData());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/form.fxml"));
        loader.setController(new UserController(model));

        stage.setTitle("Users");
        stage.setMinWidth(550);
        stage.setMinHeight(330);
        stage.setScene(new Scene(loader.load(), 600, 340));
        stage.show();
        stage.toFront();
    }

    @BeforeEach
    void setUpUserControllerTest() {
        model = new UserModel();
        model.setUsers(loadData());
    }

    @Test
    void addUserTest(FxRobot robot) {
        TextField firstname = robot.lookup("#firstnameField").queryAs(TextField.class);
        assertNotNull(firstname);
        TextField lastname = robot.lookup("#lastnameField").queryAs(TextField.class);
        assertNotNull(lastname);
        TextField email = robot.lookup("#emailField").queryAs(TextField.class);
        assertNotNull(email);
        TextField username = robot.lookup("#usernameField").queryAs(TextField.class);
        assertNotNull(username);
        PasswordField password = robot.lookup("#passwordField").queryAs(PasswordField.class);
        assertNotNull(password);

        robot.clickOn("#buttonAdd");
        assertEquals("NEW.USER", username.getText());

        robot.clickOn("#firstnameField");
        robot.write("firstname");
        assertEquals("firstname", firstname.getText());

        robot.clickOn("#lastnameField");
        robot.write("lastname");
        assertEquals("lastname", lastname.getText());

        robot.clickOn("#emailField");
        robot.write("email");
        assertEquals("email", email.getText());

        robot.clickOn("#usernameField");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("username");
        assertEquals("username", username.getText());

        robot.clickOn("#passwordField");
        robot.write("password");
        assertEquals("password", password.getText());

        Stage stage = (Stage) username.getScene().getWindow();
        Platform.runLater(stage::close);
    }
}