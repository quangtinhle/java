package Praktikum8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.awt.*;

public class Hauptfenster extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       MenuBar mb = new MenuBar();
        BorderPane bp = new BorderPane();
        bp.setTop(mb);

        Menu datei = new Menu("Datei");
        Menu medium = new Menu("Medium");
        Menu anzeige = new Menu("Anzeige");

        MenuItem laden = new MenuItem("Laden");
        MenuItem speichern = new MenuItem("Speichern");
        MenuItem liste = new MenuItem("Beenden");

        MenuItem audio = new MenuItem("Audio neu");
        MenuItem bild = new MenuItem("Bild neu");

        MenuItem erscheinung = new MenuItem("Erscheinungsjahr");
        MenuItem neuste = new MenuItem("Neuestes Medium");

        datei.getItems().addAll(laden,speichern,liste);
        medium.getItems().addAll(audio,bild);
        anzeige.getItems().addAll(erscheinung,neuste);

        mb.getMenus().addAll(datei,medium,anzeige);

        Scene scene = new Scene(bp, 300, 150);

        primaryStage.setTitle("Medienverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();

        BildErfassungView b = new BildErfassungView(primaryStage);
        b.showview();
    }
}
