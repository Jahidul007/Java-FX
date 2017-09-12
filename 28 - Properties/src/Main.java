import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
          
        Person Abir = new Person();
        Abir.firstNameProperty().addListener((v,oldValue,newValue)->{
             System.out.println("Name changed to "+newValue);
             System.out.println("firstNameProperty(): "+Abir.firstNameProperty());
             System.out.println("getFirstName(): "+Abir.getFirstName());
        });
        btn= new Button("Click me");
        btn.setOnAction(e->Abir.setFirstName("Brooklyn"));
        
        
        VBox layout= new VBox(8);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(btn);
             
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

    
}