/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg036.seticon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class SetIcon extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
      
        Image image = new Image(getClass().getResourceAsStream("whatisjavafx.png"));
        StackPane root = new StackPane();
   
        Label label= new Label("Here We set a Icon");
        label.setFont(Font.font ("Verdana", 25));
        label.fontProperty();
        
        root.getChildren().add(label);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Hello World!");
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
