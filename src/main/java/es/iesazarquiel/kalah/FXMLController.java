package es.iesazarquiel.kalah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class FXMLController implements Initializable {
    @FXML private ToggleGroup cpuVS;
    @FXML private RadioMenuItem cpuVScpu;
    @FXML private RadioMenuItem cpuVShuman;
    
    @FXML
    private void createNewMatch(ActionEvent event) {
        
        
        RadioMenuItem selectedItem = (RadioMenuItem) cpuVS.getSelectedToggle();
        if (selectedItem.equals(cpuVShuman)) {
            System.out.println("Hey! Human!");
        } else {
            System.out.println("me bot i am");
        }
    }
    
    @FXML
    private void closeApp(ActionEvent event) {
        Platform.exit();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
