package es.iesazarquiel.kalah;

public class Match {
    private boolean vsHuman = false;
    private int[][] houses = {
        {3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3}
    };
    private int[] stores = { 0, 0 };

    public int[][] getHouses() {
        return houses;
    }

    public void setHouses(int[][] houses) {
        this.houses = houses;
    }

    public int[] getStores() {
        return stores;
    }

    public void setStores(int[] stores) {
        this.stores = stores;
    }

    public boolean isVsHuman() {
        return vsHuman;
    }

    public void setVsHuman(boolean vsHuman) {
        this.vsHuman = vsHuman;
    }
}
