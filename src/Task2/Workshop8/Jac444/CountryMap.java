/*
Student: Mitchell Culligan
id: 161293170
email: mculligan@myseneca.ca
Professor: Mahboob Ali
 */
package Task2.Workshop8.Jac444;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.Map;
import java.util.HashMap;

public class CountryMap extends Application {

    public static final HashMap<String,String> CAPS =
            new HashMap<>(Map.of("CANADA","Ottawa",
                                    "USA","Washingtion D.C",
                                    "RUSSIA", "Moscow",
                                    "FRANCE", "Paris",
                                 "ENGLAND", "London" ,
                                    "MEXICO", "Mexico City",
                                    "CHINA","Bejing",
                                    "JAPAN","Tokyo"));
    private TextField country;
    public CountryMap(){
        this.country = new TextField();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene;
        BorderPane root = new BorderPane();
        HBox hb = new HBox(5);
        Label lbl = new Label("Enter country for capital: ");
        Button search = new Button("Search");
        search.setPrefSize(75,25);
        BorderPane.setMargin(search, new Insets(8,8,8,8));
        BorderPane.setAlignment(search,Pos.BOTTOM_CENTER);
        search.setOnMouseClicked((e)-> this.displayCap());
        hb.getChildren().addAll(lbl,this.country );
        BorderPane.setMargin(hb,new Insets(8,8,8,8));
        root.setCenter(hb);
        root.setBottom(search);
        scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Capital City Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void displayCap(){
            Stage stage= new Stage();
            Scene scene;
            Label lbl = new Label();
            String capital = CountryMap.CAPS.get(this.country.getText().trim().toUpperCase());
            BorderPane bp = new BorderPane();
            Button close = new Button("Close");
            BorderPane.setMargin(close,new Insets(8,8,8,8));
            BorderPane.setMargin(lbl, new Insets(8,8,8,8));
            BorderPane.setAlignment(lbl, Pos.CENTER);
            BorderPane.setAlignment(close, Pos.BOTTOM_CENTER);
            if(capital!=null){
                lbl.setText("The Capital of "+this.country.getText().trim()+ " is "+capital);
            }
            else lbl.setText("Country not found!");

            close.setPrefSize(75,25);
            stage.setTitle("Capital City Program");
            stage.setResizable(false);
            close.setOnMouseClicked((e)-> ((Node)e.getSource()).getScene().getWindow().hide());
            bp.setCenter(lbl);
            bp.setBottom(close);
            scene = new Scene(bp, 250, 150);
            stage.setScene(scene);
            stage.show();


    }



}
