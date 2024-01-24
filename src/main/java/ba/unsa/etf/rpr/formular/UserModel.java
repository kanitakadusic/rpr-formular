package ba.unsa.etf.rpr.formular;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {
    private ObservableList<User> users;
    private ObjectProperty<User> currentUser;

    public UserModel() {
        users = FXCollections.observableArrayList();
        currentUser = new SimpleObjectProperty<>();
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<User> users) {
        this.users = users;

        if (users.isEmpty()) setCurrentUser(null);
        else setCurrentUser(this.users.get(0));
    }

    public User getCurrentUser() {
        return currentUser.get();
    }

    public ObjectProperty<User> currentUserProperty() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser.set(currentUser);
    }
}
