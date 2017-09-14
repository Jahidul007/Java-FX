/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author JAHIDUL ISLAM
 */
public class Main extends Application {
    
    
    Stage window;
    Scene scene;
    Button btn;


    @Override
    public void start(Stage primaryStage) {
        window =primaryStage;
        window.setTitle("Java-Fx Check Box");
       
        
        
        
        
        //check boxes
        
        CheckBox box1 = new  CheckBox("Fish");
        CheckBox box2 = new  CheckBox("Vegetable");
        box2.setSelected(true);
        //Button
        btn= new Button("Order Now");  
        btn.setOnAction(e->handleOptions(box1,box2));
        
    
        VBox layout =  new VBox(10);
        layout.setPadding(new Insets(20 ,20 ,20 ,20));
        layout.getChildren().addAll(box1,box2,btn); 
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    //Handle check box options 
    
    private void  handleOptions(CheckBox box1 ,CheckBox box2)
    {
        String message = "Users order:\n";
        if(box1.isSelected())
            message+= "Fish\n";
        if(box2.isSelected())
            message+= "Vegetable\n";
        System.out.println(message);
    }
    
}
