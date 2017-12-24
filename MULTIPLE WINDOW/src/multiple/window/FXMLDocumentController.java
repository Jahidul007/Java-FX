/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private AnchorPane AP;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       AnchorPane root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));

        AP.getChildren().setAll(root);
       
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
