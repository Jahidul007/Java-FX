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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    Stage window;
    Scene scene ;
    Button btn;
    
    
    
    
    TreeView<String>tree;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window =primaryStage;
        window.setTitle("Java-Fx");
        btn= new Button("Click me");  
       TreeItem<String>root,jahid,abir;
         
       //root
        root = new TreeItem<>();
        root.setExpanded(true);
        
        //jahid
        jahid = makeBranch("jahid",root);
        makeBranch("Jahir",jahid);
        makeBranch("Hasan",jahid);
        makeBranch("Deen",jahid);
        
        //abir
        abir = makeBranch("abir",root);
        makeBranch("Ahsan",abir);
        makeBranch("Beboson",abir);
        makeBranch("Raihan",abir);
        
        //Create tree 
        tree = new TreeView<>(root);
        tree.setShowRoot(true);
        
     
        VBox layout= new VBox(8);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String>parent) {
        
        TreeItem<String> item = new TreeItem<> (title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    
}