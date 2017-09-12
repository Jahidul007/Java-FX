/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.embedding.layouts;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class EmbeddingLayouts extends Application {
    Stage window;
    Button btn;
    @Override
    public void start(Stage primaryStage) {
        window =primaryStage;
        window.setTitle("Java-Fx");
        
       HBox topMenu= new HBOx();
       Button buttonA= new Button("File");
       Button buttonB= new Button("Edit");
       Button buttonC= new Button("view");
       topMenu.getChildren().addAll(buttonA,buttonB,buttonC); 
       
       VBox leftMenu= new VBOx();
       Button buttonD= new Button("D");
       Button buttonE= new Button("E");
       Button buttonF= new Button("F");
       leftMenu.getChildren().addAll(buttonD,buttonE,buttonF);

       
       //btn= new Button("Close program");  
        
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(topMenu);
    borderPane.setLeft(leftMenu);
    
        
        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    private static class HBOx extends HBox {

        public HBOx() {
        }
    }

    private static class VBOx extends VBox {

        public VBOx() {
        }
    }

    
}
