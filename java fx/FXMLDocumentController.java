/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationstart;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author peterhempel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Button add;
    @FXML private Button sub;
    @FXML private Label display;
    @FXML private Button clear;
    @FXML private Button dot;
    @FXML private Button tgaplaner;
    @FXML private Button zone;
    @FXML private Button twplaner;
    @FXML private Button negate;
    @FXML private Button equals;
    @FXML private Button div;
    @FXML private Button mul;
    @FXML private Button vonbis;
    @FXML private Button pm;
    @FXML private Button architekt;
    @FXML private TextArea ausgabe;
    
    private Double operand1 =null;
    private Double operand2 = null;
    private String operation;
    public Double result_calculation = null;
    private boolean operandOK;
    private String paper = "";
    private final String paperBuffer = "";
    private final  String displayedText = ("");
    private double einDouble;
    
    Honorar honorar = new Honorar();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
            
            //display.textProperty().bind(displayedText);
    }
    
    @FXML private void handleNumberAction (ActionEvent event)
    {
        
    Button source =  (Button) event.getSource();
        
        String num = display.getText(); 
                if ("0".equals(num) && !(",".equals(source.getText()))) 
                {
                    num = source.getText();
                }
                else 
                {
                num = num + source.getText();
                }
            display.textProperty().set(num);
    }
    
    @FXML private void handleButtonAction(ActionEvent event) 
    {
        if (!"0".equals(display.getText()) && !operandOK)
           {
               Button source = (Button) event.getSource();
               operation = source.getText();
               operand1 = string_to_double(display.getText());
               paper = paper + operand1 + operation;
               display.setText("0");
               operandOK = true;
           }
       if (result_calculation != null && !operandOK)
           {
               Button source = (Button) event.getSource();
               operation = source.getText();
               
               paper = paper + operand1 + operation;
               display.setText("0");
               operandOK = true;
           }
    }
    
 
     @FXML private void handleEnterAction (ActionEvent event)
     {
        if (operandOK)
        {
             operand2 = string_to_double(display.getText());
             
             switch (operation)
                 {
                    case "+":
                        result_calculation = operand1 + operand2;
                        break; 
                    case "-":
                        result_calculation = operand1 - operand2;
                        break;
                    case "x":
                        result_calculation = operand1 * operand2;
                        break;
                    case "/":
                        result_calculation = operand1 / operand2;
                  }
          
                    paper = paper + operand2 + " = ";
                    operation = "";
                    display.setText("0");              
                   operandOK = false;
                    
        }
ausgabe.textProperty().set(paper + result_calculation + "\n" + ausgabe.textProperty().getValue());
paper = "";
operand1 = result_calculation;
}
 
     
     @FXML private void ArchitektAction (ActionEvent event)
     {
         ausgabe.textProperty().set(honorar.setArch(result_calculation) + ausgabe.textProperty().getValue());
     }
     
     @FXML private void ZoneAction (ActionEvent event)
     {
         Button source = (Button) event.getSource();
               operation = source.getText();
               switch (operation)
                 {
                    case "Zone I":
                        source.setText("Zone II");
                        honorar.Zone = 2;
                        break; 
                    case "Zone II":
                        source.setText("Zone III");
                        honorar.Zone = 3;
                        break;
                    case "Zone III":
                        source.setText("Zone IV");
                        honorar.Zone = 4;
                        break;
                    case "Zone IV":
                        source.setText("Zone V");
                        honorar.Zone = 5;
                        break;
                    case "Zone V":
                        source.setText("Zone I");
                        honorar.Zone = 1;
                  }
               
     }
     
     @FXML private void AbschlagAction (ActionEvent event)
     {
         Button source = (Button) event.getSource();      
         operation = source.getText();
               switch (operation)
                 {
                    case "Mittelsatz":
                        source.setText("Dreiviertalsatz");
                        honorar.Abschlag = 75;
                        break; 
                    case "Dreiviertalsatz":
                        source.setText("Höchssatz");
                        honorar.Abschlag = 100;
                        break;
                    case "Höchssatz":
                        source.setText("Mindestsatz");
                        honorar.Abschlag = 0;
                        break;
                    case "Mindestsatz":
                        source.setText("Viertelsatz");
                        honorar.Abschlag = 25;
                        break;
                    case "Viertelsatz":
                        source.setText("Mittelsatz");
                        honorar.Abschlag = 50;
                  }  
     }
     
    double string_to_double (String inputString)
    {
        Locale locde = new Locale("de", "DE");
        try
        {
        NumberFormat nf = NumberFormat.getInstance(locde);
        Number number = nf.parse(inputString);
        double d = number.doubleValue();
        return d;
        }
        catch (java.text.ParseException ex)
        {
                System.out.println("Fehler");
                return 0;
        }
    }
 
}
