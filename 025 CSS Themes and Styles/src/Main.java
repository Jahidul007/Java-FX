

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author JAHIDUL ISLAM
 */
public class Main extends Application {

  
    Stage window;
    Button btn;
    @Override
    public void start(Stage primaryStage) {
        window =primaryStage;
        window.setTitle("Java-Fx");
       
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10); 
        
        
        //name label ghfgh
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);
        
        ///name input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput,1,0);
       
        //passLabel
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);
        
        //password Input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,1,1);
        
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,1,2);
        
        
        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);
        
        
        Scene scene = new Scene(grid,300,250);
        scene.getStylesheets().add("newfile.css");
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
  
}
