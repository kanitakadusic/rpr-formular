module ba.unsa.etf.rpr.formular {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens ba.unsa.etf.rpr.formular to javafx.fxml;
    exports ba.unsa.etf.rpr.formular;
}