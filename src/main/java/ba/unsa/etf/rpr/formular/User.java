package ba.unsa.etf.rpr.formular;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty email;
    private SimpleStringProperty username;
    private SimpleStringProperty password; // ?

    public User() {
        this.firstname = new SimpleStringProperty("");
        this.lastname = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.username = new SimpleStringProperty("NEW.USER");
        this.password = new SimpleStringProperty("");
    }

    public User(String firstname, String lastname, String email, String username, String password) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public final String getFirstname() {
        return firstname.get();
    }

    public final SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public final void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public final String getLastname() {
        return lastname.get();
    }

    public final SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public final void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public final String getEmail() {
        return email.get();
    }

    public final SimpleStringProperty emailProperty() {
        return email;
    }

    public final void setEmail(String email) {
        this.email.set(email);
    }

    public final String getUsername() {
        return username.get();
    }

    public final SimpleStringProperty usernameProperty() {
        return username;
    }

    public final void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return getUsername();
    }
}