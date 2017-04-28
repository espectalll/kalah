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
            if (id >= 1 && id <= 2) {
                Label label = (Label) scene.lookup("#store" + id);
                label.setText(Integer.toString(value));
            } else {
                throw new IllegalArgumentException("Incorrect ID");
            }
        } catch (Exception ex) {
            Logger.getLogger(MatchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void setHouseLabel(Integer id, Integer value) {
        try {
            if (id >= 1 && id <= 12) {
                Label label = (Label) scene.lookup("#house" + id);
                label.setText(Integer.toString(value));
            } else {
                throw new IllegalArgumentException("Incorrect ID");
            }
        } catch (Exception ex) {
            Logger.getLogger(MatchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected Match getCurrentMatch() {
        return currentMatch;
    }
}
