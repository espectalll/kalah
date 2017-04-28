package es.iesazarquiel.kalah;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FXMLController implements Initializable {
    private Match currentMatch;
    
    @FXML private VBox root;
    @FXML private GridPane tableGrid;
    // @FXML private ToggleGroup cpuVS;
    // @FXML private RadioMenuItem cpuVScpu;
    // @FXML private RadioMenuItem cpuVShuman;
    
    @FXML private Label store1;
    @FXML private Label store2;
    
    @FXML private Label house1;
    @FXML private Label house2;
    @FXML private Label house3;
    @FXML private Label house4;
    @FXML private Label house5;
    @FXML private Label house6;
    
    @FXML private Label house7;
    @FXML private Label house8;
    @FXML private Label house9;
    @FXML private Label house10;
    @FXML private Label house11;
    @FXML private Label house12;
    
    private Scene scene;
    
    @FXML
    private void createNewMatch(ActionEvent event) {
        tableGrid.setDisable(false);
        currentMatch = new Match();
        // RadioMenuItem selectedItem = (RadioMenuItem) cpuVS.getSelectedToggle();
        // currentMatch.setVsHuman(selectedItem.equals(cpuVShuman));
        new MatchHandler(this).createTask();
    }
    
    @FXML
    private void closeApp(ActionEvent event) {
        Platform.exit();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    protected void setStoreLabel(Integer id, Integer value) {
        try {
            switch (id) {
                case 1: store1.setText(Integer.toString(value)); break;
                case 2: store2.setText(Integer.toString(value)); break;
                default: throw new IllegalArgumentException("Incorrect ID"); 
            }
        } catch (Exception ex) {
            Logger.getLogger(MatchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void setHouseLabel(Integer id, Integer value) {
        try {
            switch (id) {
                case 1: house1.setText(Integer.toString(value)); break;
                case 2: house2.setText(Integer.toString(value)); break;
                case 3: house3.setText(Integer.toString(value)); break;
                case 4: house4.setText(Integer.toString(value)); break;
                case 5: house5.setText(Integer.toString(value)); break;
                case 6: house6.setText(Integer.toString(value)); break;
                case 7: house7.setText(Integer.toString(value)); break;
                case 8: house8.setText(Integer.toString(value)); break;
                case 9: house9.setText(Integer.toString(value)); break;
                case 10: house10.setText(Integer.toString(value)); break;
                case 11: house11.setText(Integer.toString(value)); break;
                case 12: house12.setText(Integer.toString(value)); break;
                default: throw new IllegalArgumentException("Incorrect ID"); 
            }
        } catch (Exception ex) {
            Logger.getLogger(MatchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected Match getCurrentMatch() {
        return currentMatch;
    }
}
