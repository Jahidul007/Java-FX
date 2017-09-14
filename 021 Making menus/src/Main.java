import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    
    
    BorderPane  layout;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
     
       // File menu
       
       Menu fileMenu = new Menu("File");
       
       //Menu items
       fileMenu.getItems().add(new MenuItem("New Project..."));
       fileMenu.getItems().add(new MenuItem("New Module..."));
       fileMenu.getItems().add(new MenuItem("Import Project..."));
       
       // Main Men u bar 
       MenuBar menuBar = new MenuBar();
       menuBar.getMenus().addAll(fileMenu);
       
        
        
        
        layout = new BorderPane();     
        layout.setTop(menuBar);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

    
}