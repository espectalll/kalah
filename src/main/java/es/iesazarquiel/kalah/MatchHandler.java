package es.iesazarquiel.kalah;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MatchHandler extends Service<String> {
    private final FXMLController controller;
    private final Match match;
    
    @Override
    protected Task<String> createTask() {
        
        return null;
    }
    
    MatchHandler(FXMLController controller) {
        this.controller = controller;
        this.match = controller.getCurrentMatch();
    }
}
