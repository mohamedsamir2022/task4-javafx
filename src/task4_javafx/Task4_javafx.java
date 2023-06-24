/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package task4_javafx;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 
public class Task4_javafx extends Application {

  
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane  = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));
        Label l1=new Label("firstname");
        Label l2=new Label("lastname");
        Label l3=new Label("Email");
        TextField tf1=new TextField();
        TextField tf2=new TextField();
        TextField tf3=new TextField();

        Button btn1 = new Button("submit");
        Button btn2 = new Button("clear");














        pane.add(l1, 0, 0);
        pane.add(tf1, 1, 0);

        pane.add(l2, 0, 1);
        pane.add(tf2, 1, 1);

        pane.add(l3, 0, 2);
        pane.add(tf3, 1, 2);

        pane.add(btn1, 0, 3);
        pane.add(btn2, 1, 3);
        btn1.setOnAction(event -> {
            if (Objects.equals(tf1.getText(), "") && Objects.equals(tf2.getText(), "")
                    && Objects.equals(tf3.getText(), "")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing data");
                alert.setHeaderText("   Pls Enter All Data");
                alert.showAndWait();

            }
            else {
                try (PrintWriter writer = new PrintWriter("Data.csv")) {

                    String sb = "firstname" +
                            ',' +
                            "lastname" +
                            ',' +
                            "email" +
                            '\n' +
                            tf1.getText() +
                            ',' +
                            tf2.getText() +
                            ',' +
                            tf3.getText() +
                            '\n';

                    writer.write(sb);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("   Data saved successfully");
                    alert.showAndWait();
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            }
        });
        //





        Scene scene = new Scene(pane, 300, 250);
        //scene.getStylesheets().add(task4_javafx.Task4_javafx.class.getResource("task4.css").toString());


        primaryStage.setTitle("Data App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}