package ba.unsa.etf.rpr.formular;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserController {
    private final UserModel model;

    public ListView<User> usersList;
    public TextField firstnameField;
    public TextField lastnameField;
    public TextField emailField;
    public TextField usernameField;
    public PasswordField passwordField;

    public UserController(UserModel model) {
        this.model = model;
        usersList = new ListView<>();
    }

    @FXML
    public void initialize() {
        usersList.setItems(model.getUsers());

        usernameField.textProperty().addListener((observableValue) -> usersList.refresh());

        usersList.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldUser, newUser) -> {
            if (oldUser != null) {
                firstnameField.textProperty().unbindBidirectional(oldUser.firstnameProperty());
                lastnameField.textProperty().unbindBidirectional(oldUser.lastnameProperty());
                emailField.textProperty().unbindBidirectional(oldUser.emailProperty());
                usernameField.textProperty().unbindBidirectional(oldUser.usernameProperty());
                passwordField.textProperty().unbindBidirectional(oldUser.passwordProperty());
            }

            model.setCurrentUser(newUser);

            if (newUser == null) {
                firstnameField.setText("");
                lastnameField.setText("");
                emailField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            } else {
                firstnameField.textProperty().bindBidirectional(newUser.firstnameProperty());
                lastnameField.textProperty().bindBidirectional(newUser.lastnameProperty());
                emailField.textProperty().bindBidirectional(newUser.emailProperty());
                usernameField.textProperty().bindBidirectional(newUser.usernameProperty());
                passwordField.textProperty().bindBidirectional(newUser.passwordProperty());
            }

            usersList.refresh();
        }));

        usersList.getSelectionModel().selectFirst();
    }

    public void addUser() {
        model.getUsers().add(new User());
        model.setCurrentUser(model.getUsers().getLast());

        usersList.getSelectionModel().selectLast();
        usersList.refresh();
    }

    public void endProgram() {
        javafx.application.Platform.exit();
    }
}