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
        btn= new Button("Click me");  
        
        ChoiceBox<String>choiceBox = new ChoiceBox<>(); 
        
        //Add items to your list which you can add items to
         choiceBox.getItems().add("Fish");
         choiceBox.getItems().add("Vegetable");
         choiceBox.getItems().addAll("Meat","Fruit","Mutton");
         
        //set a default value
        choiceBox.setValue("Fish");
        
        btn.setOnAction(e->getChoice(choiceBox));
        
        VBox layout= new VBox(8);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,btn);
             
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    //to get th value of the selected item
    
    private void getChoice(ChoiceBox<String>choiceBox)
    {
        String food = choiceBox.getValue();
        System.out.println("I want to eat "+food);
    }

    
}