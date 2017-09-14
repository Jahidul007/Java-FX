package pkg6.communicatinng.btn.windows;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class CommunicatinngBtnWindows extends Application {
    Stage window;
    Button button;
    
    @Override
    public void start(Stage primaryStage) {
        
        window = primaryStage; 
        window.setTitle("NEW WINDOW");
        button= new Button("Click me");
        
        button.setOnAction(e-> {
           
                boolean result = ConfirmBox.display("The Title of window","Are you want to medona's pic ?");
                System.out.println(result);
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(button);
        
        Scene scene = new Scene(root, 300, 250);
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
