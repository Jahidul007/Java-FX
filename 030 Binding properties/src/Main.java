import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
        //btn= new Button("Click me");  
       
        //Input and labels 
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label ("Welcome to the site ");
        Label secondLabel = new Label();
        
        HBox bottomText = new HBox(firstLabel,secondLabel);
        bottomText.setAlignment(Pos.CENTER);
        
        
         
        VBox layout= new VBox(10,userInput,bottomText);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(btn);
        
        secondLabel.textProperty().bind(userInput.textProperty());
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

   

    
}