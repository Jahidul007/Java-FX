import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
       
       Menu fileMenu = new Menu("_File");
       
       //Menu items
       MenuItem newFile = new MenuItem("New...");
       newFile.setOnAction(e -> System.out.println("Create a new File"));
       fileMenu.getItems().addAll(newFile);
       
       fileMenu.getItems().add(new MenuItem("Open..."));
       fileMenu.getItems().add(new MenuItem("Save..."));
       fileMenu.getItems().add(new SeparatorMenuItem());
       fileMenu.getItems().add(new MenuItem("Setting..."));
       fileMenu.getItems().add(new SeparatorMenuItem());
       fileMenu.getItems().add(new MenuItem("Exit..."));
       
       //Edit menu
       Menu editMenu =new Menu("_Edit");
       editMenu.getItems().add(new MenuItem("Cut..."));
       editMenu.getItems().add(new MenuItem("Copy...")); 
       editMenu.getItems().add(new MenuItem("Move..."));
      
       MenuItem paste = new MenuItem("Paste");
       paste.setOnAction(e -> System.out.println("Pasting a File"));
       paste.setDisable(true);
       editMenu.getItems().addAll(paste);
       
     
       // Help Menu 
       Menu helpMenu = new Menu("Help");
       CheckMenuItem showLines = new CheckMenuItem("Show Line Number");
       showLines.setOnAction(e ->{
           if(showLines.isSelected())
           {
               System.out.println("Program will now display the line");
           }
           else
               System.out.println("Hidding line number");
       });
       
       CheckMenuItem autoSave = new CheckMenuItem("Enable AutoSave");
       autoSave.setSelected(true);
       helpMenu.getItems().addAll(showLines,autoSave);
       
       //difficulty Radio menu Item
       Menu difficultyMenu = new Menu("Difficulty");
       ToggleGroup  difficultyToggle= new ToggleGroup();
       
       RadioMenuItem easy = new RadioMenuItem("Easy");
       RadioMenuItem medium = new RadioMenuItem("Medium");
       RadioMenuItem hard = new RadioMenuItem("Hard");
       
       easy.setToggleGroup(difficultyToggle);
       medium.setToggleGroup(difficultyToggle); 
       hard.setToggleGroup(difficultyToggle);
       
       difficultyMenu.getItems().addAll(easy,medium,hard);
       
       
       // Main Men u bar 
       MenuBar menuBar = new MenuBar();
       menuBar.getMenus().addAll(fileMenu,editMenu,difficultyMenu,helpMenu);
       
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