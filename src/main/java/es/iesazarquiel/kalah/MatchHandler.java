package es.iesazarquiel.kalah;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MatchHandler extends Service<String> {
    private final FXMLController controller;
    private final Match match;
    
    protected void nextTurn(Integer player) throws InterruptedException {
        int[][] houses = match.getHouses();
        int[] stores = match.getStores();
        if (player.equals(1)) {
            int moveFrom = (int) (Math.random() * 6);
            while (houses[0][moveFrom] == 0) {
                moveFrom = (int) (Math.random() * 6);
            }
            if (moveFrom == 0) {
                stores[0] += 1;
                houses[0][0] -= 1;
            } else if (houses[0][moveFrom] == 1) {
                stores[0] += houses[0][moveFrom] + houses[1][moveFrom];
                houses[0][moveFrom] = 0;
                houses[1][moveFrom] = 0;
            } else {
                for (int i = moveFrom; i > 0; i--) {
                    houses[0][i] += 1;
                    houses[0][moveFrom] -= 1;
                    if (houses[0][moveFrom] == 0) break;
                }
                stores[0] += houses[0][moveFrom];
                houses[0][moveFrom] = 0;
            }
            for (int i = 0; i < houses[0].length; i++) {
                if (houses[0][i] == 1) {
                    stores[0] += houses[0][i] + houses[1][i];
                    houses[0][i] = 0;
                    houses[1][i] = 0;
                }
            }
        } else {
            int moveFrom = (int) (Math.random() * 6);
            while (houses[1][moveFrom] == 0) {
                moveFrom = (int) (Math.random() * 6);
            }
            if (moveFrom == houses[1].length) {
                stores[1] += 1;
                houses[1][houses[1].length] -= 1;
            } else if (houses[1][moveFrom] == 1) {
                stores[1] += houses[0][moveFrom] + houses[1][moveFrom];
                houses[0][moveFrom] = 0;
                houses[1][moveFrom] = 0;
            } else {
                for (int i = moveFrom; i < houses[1].length; i++) {
                    houses[0][i] += 1;
                    houses[0][moveFrom] -= 1;
                    if (houses[1][moveFrom] == 0) break;
                }
                stores[1] += houses[1][moveFrom];
                houses[1][moveFrom] = 0;
            }
            for (int i = 0; i < houses[1].length; i++) {
                if (houses[1][i] == 1) {
                    stores[1] += houses[0][moveFrom] + houses[1][moveFrom];
                    houses[0][moveFrom] = 0;
                    houses[1][moveFrom] = 0;
                }
            }
        }
        match.setHouses(houses);
        match.setStores(stores);
        boolean winner = false;
        for (int i = 0; i < houses.length; i++) {
            controller.setStoreLabel(i + 1, stores[i]);
            int counter = 0;
            for (int j = 0; j < houses[0].length; j++) {
                controller.setHouseLabel((i + 1) * (j + 1), houses[i][j]);
                counter += houses[i][j];
            }
            if (counter == 0) winner = true;
        }
        Thread.sleep(750);
        if (winner) {
            System.out.println("¡Ha ganado el jugador " + player + "!");
        }
        else {
            nextTurn(player.equals(1) ? 2 : 1);
        }
    };
    
    @Override
    protected Task<String> createTask() {
        try {
            nextTurn(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(MatchHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    MatchHandler(FXMLController controller) {
        this.controller = controller;
        this.match = controller.getCurrentMatch();
    }
}
