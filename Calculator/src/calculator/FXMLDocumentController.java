/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author JAHIDUL ISLAM
 */
public class FXMLDocumentController implements Initializable {
    
    Float data = 0f;
    Integer operation = -1;
   @FXML
    private Button nine;

    @FXML
    private Button six;

    @FXML
    private Button one;

    @FXML
    private TextField display;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Label label;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button equal;

    @FXML
    private Button division;

    @FXML
    private Button four;

    @FXML
    private Button multiplication;

    @FXML
    private Button five;

    @FXML
    private Button substract;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource()==one)
        {
            display.setText(display.getText()+"1");
        }
        else if (event.getSource()==two)
        {
            display.setText(display.getText()+"2");
        }
        else if(event.getSource()==three)
        {
            display.setText(display.getText()+"3");
        }
        else if(event.getSource()==four)
        {
            display.setText(display.getText()+"4");
        }
         else if (event.getSource()==five)
        {
            display.setText(display.getText()+"5");
        }
        else if(event.getSource()==six)
        {
            display.setText(display.getText()+"6");
        }
        else if(event.getSource()==seven)
        {
            display.setText(display.getText()+"7");
        }
        
         else if (event.getSource()==eight)
        {
            display.setText(display.getText()+"8");
        }
        else if(event.getSource()==nine)
        {
            display.setText(display.getText()+"9");
        }
        else if(event.getSource()==zero)
        {
            display.setText(display.getText()+"0");
        }
        else if(event.getSource()==clear)
        {
            display.setText("");
        }
        else if(event.getSource()==plus)
        {
            data=Float.parseFloat(display.getText());
            operation = 1;
            display.setText("");
        }
       
        else if(event.getSource()==substract)
        {
            data=Float.parseFloat(display.getText());
            operation = 2;
            display.setText("");
        }
        
        else if(event.getSource()==multiplication)
        {
            data=Float.parseFloat(display.getText());
            operation = 3;
            display.setText("");
        }
         else if(event.getSource()==division)
        {
            data=Float.parseFloat(display.getText());
            operation = 4;
            display.setText("");
        }
         else if(event.getSource()==equal)
        {
          Float  second =Float.parseFloat(display.getText());
            
          switch(operation){
              case 1:
                  Float ans = data+second;
                  display.setText(String.valueOf(ans));break;
              case 2:
                  ans = data-second;
                  display.setText(String.valueOf(ans));break;
              case 3:
                   ans = data*second;
                  display.setText(String.valueOf(ans));break;
              case 4:
              try{
                      ans = data/second;
                  }catch(Exception e){display.setText("error");break;}
                display.setText(String.valueOf(ans));break;
          }
          
        }
        
         
        
    }
    @Override
    public void initialize(URL url ,ResourceBundle rb)
    {
        
    }

   
    
}
