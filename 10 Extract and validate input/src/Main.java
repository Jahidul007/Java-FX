import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    Scene scene ;
    Button btn;
    @Override
    public void start(Stage primaryStage) throws Exception {
       window = primaryStage;
       window.setTitle("Java_Fx");
       
       
       //form
       TextField nameInput = new TextField();
       btn = new Button("Click me");
       btn.setOnAction(e->isInt(nameInput,nameInput.getText()));
       
       //layout
       VBox layout = new VBox(10);
       //GridPane grid = new GridPane();
       layout.setPadding(new Insets(20,20,20,20));
       layout.getChildren().addAll(nameInput,btn);
        
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
    
    
    private boolean isInt (TextField input,String message)
    {
        try
        {
            int age = Integer.parseInt(input.getText());
            System.out.println("user is "+age);
            return true;
        }
        catch(NumberFormatException e)
                {
                   System.out.println("Error "+ message+" is not a number");
                   return false;
                }
    }

  
}
