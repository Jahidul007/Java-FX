import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
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
    ListView<String>listView;
      
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
        btn= new Button("Submit");  
       
        listView = new ListView<>();
        listView.getItems().addAll("Taitanic","Taken","Jhon wick","FAF");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //btn.setOnAction(e->printMovie());
        
        btn.setOnAction(e->buttonCLicked());
        VBox layout= new VBox(8);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,btn);
             
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

   /* private void printMovie() {
       System.out.println("This is me ");
    }*/

    private void buttonCLicked() {
        
        String message = "";
        ObservableList<String>movies;
        movies = listView.getSelectionModel().getSelectedItems();
        for(String m:movies)
        {
            message+=m+"\n";
        }
    System.out.println("User selected movies :\n" +message);
    }

    
}