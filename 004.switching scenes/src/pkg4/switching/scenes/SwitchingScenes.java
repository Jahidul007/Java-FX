
package pkg4.switching.scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class SwitchingScenes extends Application {
 
    Stage window;
    Scene scene1,scene2;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage primaryStage) throws Exception
    {
        window = primaryStage;
        
        Label label1= new  Label("welcome to the first scene!");
        Button button1 = new  Button ("Go to scene 2! ");
        button1.setOnAction(e->window.setScene(scene2));
        
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
       // Parent layout = null;
        scene1 = new Scene(layout1 ,200,200);
        
        Button button2 = new  Button ("This is nice one,go back to scene1");
        button2.setOnAction(e->window.setScene(scene1));
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,600,300);
        
        window.setScene(scene1);
        window.setTitle("NEW WINDOW");
        window.show();
        
    }
    
}