
package imageview;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class ImageView extends Application {

   
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Image image = new Image(getClass().getResourceAsStream("whatisjavafx.png"));
        javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView(image);
        javafx.scene.image.ImageView iv2 = new javafx.scene.image.ImageView(image);
        VBox hBox = new VBox();
        hBox.getChildren().addAll(iv,iv2);
        StackPane root = new StackPane();
        root.getChildren().addAll(hBox);
        Scene scene = new Scene(root, 500, 550);
        
        primaryStage.setTitle("ImageView!");
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
