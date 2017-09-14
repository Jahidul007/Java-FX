
package anonyous.inner.classes.and.lamda;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AnonyousInnerClassesAndLamda extends Application {
    
   Button button; 
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Title of the Window");
        button = new Button();
        button.setText("Click me ");
        
        button.setOnAction(e ->
        {
            System.out.println("hey now brown cow");
             System.out.println("hey now black cow");
            
                });
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
  
    }

}
