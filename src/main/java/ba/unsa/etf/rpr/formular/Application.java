package ba.unsa.etf.rpr.formular;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private ObservableList<User> loadData() {
        ObservableList<User> list = FXCollections.observableArrayList();
        list.add(new User("Sandra", "Bullock", "sandra.bullock@info.com", "sandra.bullock", "123"));
        list.add(new User("Cillian", "Murphy", "cillian.murphy@info.com", "cillian.murphy", "456"));

        return list;
    }

    @Override
    public void start(Stage stage) throws IOException {
        UserModel model = new UserModel();
        model.setUsers(loadData());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/form.fxml"));
        loader.setController(new UserController(model));

        stage.setTitle("Users");
        stage.setMinWidth(550);
        stage.setMinHeight(330);
        stage.setScene(new Scene(loader.load(), 600, 340));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}