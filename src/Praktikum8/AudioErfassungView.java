package Praktikum8;

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

public class AudioErfassungView extends Stage {

    public AudioErfassungView(Stage primaryStage) {

        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10.0));
        grid.setVgap(10.0);
        grid.setHgap(10.0);
        grid.setAlignment(Pos.CENTER);

        Label titel = new Label("Titel: ");
        Label jahr = new Label("Jahr: ");
        Label interpret = new Label("Interpret: ");
        Label dauer = new Label("Dauer: ");

        grid.add(titel,0,0);
        GridPane.setHalignment(titel, HPos.RIGHT);
        grid.add(jahr,0,1);
        GridPane.setHalignment(jahr, HPos.RIGHT);
        grid.add(interpret,0,2);
        GridPane.setHalignment(interpret, HPos.RIGHT);
        grid.add(dauer,0,3);
        GridPane.setHalignment(dauer, HPos.RIGHT);

        TextField tftitel = new TextField();
        TextField tfjahr = new TextField();
        TextField tfinterpret = new TextField();
        TextField tfdauer = new TextField();

        grid.add(tftitel,1,0);
        grid.add(tfjahr,1,1);
        grid.add(tfinterpret,1,2);
        grid.add(tfdauer,1,3);

        Button btneu = new Button("Neu");
        Button btabbrechen = new Button("Abbrechen");

        HBox hb = new HBox();

        hb.getChildren().addAll(btneu,btabbrechen);
        hb.setSpacing(10.0);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10.0));


        BorderPane bp = new BorderPane();

        bp.setCenter(grid);
        bp.setBottom(hb);

        Scene scene = new Scene(bp,400,400);
        this.setTitle("AudioErfassungView");
        this.setScene(scene);

    }

    public void showview() {
        this.show();
    }
}
