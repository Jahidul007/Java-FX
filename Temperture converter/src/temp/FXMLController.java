/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 * FXML Controller class
 *
 * @author JAHIDUL ISLAM
 */
public class FXMLController implements Initializable {

   Float n=0f;
   String to;
   String from;
   Float result=0f;
    
    
    ObservableList<String>List=FXCollections.observableArrayList("Celsius","Fahrenheit","Kelvin");
     
        //close button
    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction()
    {
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML private javafx.scene.control.Button clearButton;
    
     @FXML
    private TextField input;
    
    
    
     
    @FXML
    private TextField output;

     //combobox
    @FXML
    private ComboBox one;
    @FXML
    private ComboBox two;
    
    @FXML private javafx.scene.control.Button converter;
    @FXML
    private void converterButtonAction()
    {
        n = Float.parseFloat(input.getText());
        to  = two.getSelectionModel().getSelectedItem().toString();
        from  = one.getSelectionModel().getSelectedItem().toString();
         
         
          if ( from.equals("Celsius") ){
           switch(to){
               case "Fahrenheit" :
                    result = ((9.0f / 5.0f ) * n) + 32;
                    output.setText(result.toString());
                   break ;
               case "Kelvin" :
                    result = (n * 1) + 273.15f;
                    output.setText(result.toString());
                    break ;
               default  :
                    result = n *1;
                    output.setText(result.toString());                 
          }
       }
          if ( from.equals("Fahrenheit") ){
           switch(to){
               case "Celsius" :
                    result = (n-32)*5/9f;
                    output.setText(result.toString());
                   break ;
               case "Kelvin" :
                    result = ((n-32)*5/9f)+273.15f;
                    output.setText(result.toString());
                    break ;
               default  :
                    result = n *1;
                    output.setText(result.toString());                 
          }
       }
          if ( from.equals("Kelvin") ){
           switch(to){
               case "Fahrenheit" :
                    result = ((n-273.15f)*9/5f)+32;
                    output.setText(result.toString());
                   break ;
               case "Celsius" :
                    result = n-273.15f;
                    output.setText(result.toString());
                    break ;
               default  :
                    result = n *1;
                    output.setText(result.toString());
    }
          }
    }
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        one.setValue("Celsius");
        one.setItems(List);
        two.setValue("Fahrenheit");
        two.setItems(List);
         
        //clear button
        clearButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent e) {
                input.setText("");
                output.setText("");
            }
        });
        
    }    
           
}
