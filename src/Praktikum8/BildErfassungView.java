package Praktikum8;

import Praktikum6.Bild;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.awt.*;

public class BildErfassungView extends Stage {

//    private Bild bild;
//    private Stage primaryStage;
//
//    public BildErfassungView(Bild bild, Stage primaryStage) {
//        this.bild = bild;
//        this.primaryStage = primaryStage;
//    }
    public BildErfassungView(Stage primaryStage) {
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0));
        grid.setHgap(5.0);
        grid.setVgap(5.0);
        grid.setAlignment(Pos.CENTER);

        BorderPane bp = new BorderPane();

        Label l1 = new Label("Titel: ");
        Label l2 = new Label("Ort: ");
        Label l3 = new Label("Aufnahmejahr: ");

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();

        Button b1 = new Button("Neu");
        Button b2 = new Button("Abbrechen");


        grid.add(l1,0,0);
        GridPane.setHalignment(l1, HPos.RIGHT);
        grid.add(l2,0,1);
        GridPane.setHalignment(l2, HPos.RIGHT);
        grid.add(l3,0,2);
        GridPane.setHalignment(l3, HPos.RIGHT);

        grid.add(tf1,1,0);
        grid.add(tf2,1,1);
        grid.add(tf3,1,2);

        HBox hb = new HBox();
        hb.getChildren().addAll(b1,b2);
        hb.setAlignment(Pos.CENTER);

        bp.setCenter(grid);
        bp.setBottom(hb);

        Scene scene = new Scene(bp,300,300);
        this.setScene(scene);

    }
    public void showview() {
        this.show();
    }
}
