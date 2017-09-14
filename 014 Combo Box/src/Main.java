import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    
    ComboBox<String>comboBox; 
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
        btn= new Button("Submit");  
       
         
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Lion",
                "Beauty and The Beast",
                "The Fury",
                "The man who know infiity"
        );
        
        
        comboBox.setEditable(true);
        
        comboBox.setPromptText("What is your Favorite movie?");
        btn.setOnAction(e->printMovie());
        comboBox.setOnAction(e->System.out.println("User selected :"+comboBox.getValue()));
        
        VBox layout= new VBox(8);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox,btn);
             
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

    private void printMovie() {
       System.out.println("Editorial movie: "+comboBox.getValue());
    }

    
}