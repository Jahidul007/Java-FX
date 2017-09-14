/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handle.user.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HandleUserEvent extends Application implements EventHandler<ActionEvent>{
    
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
        
        button.setOnAction(this);
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
  
    }

    @Override
    public void handle(ActionEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(event.getSource()==button)
        {
            System.out.println("I love it");
        }
    }
    
    }

    

