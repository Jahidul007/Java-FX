/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7.closing.the.program.properly;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class ClosingTheProgramProperly extends Application {
    Stage window;
    Button btn;
    @Override
    public void start(Stage primaryStage) {
        window =primaryStage;
        window.setTitle("Java-Fx");
        
        window.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
                });
        btn= new Button("Close program");  
        btn.setOnAction(e->closeProgram());
    
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram() {
      Boolean answer = ConfirmBox.display("title","Sure you want to exit?");
      if(answer)
       window.close();
    }

   
    
}
