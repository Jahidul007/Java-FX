/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.creatingbasicwindow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Creatingbasicwindow extends Application {
    Button button; 
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Title of the Window");
        button = new Button();
        button.setText("Click me ");
        
      StackPane layout = new StackPane();
       layout.getChildren().add(button);
        
        Scene scene = new Scene(layout, 300, 250);
        
        ///primaryStage.setTitle("New One");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
}
