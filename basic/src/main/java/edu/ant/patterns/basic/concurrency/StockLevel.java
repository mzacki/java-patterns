package edu.ant.patterns.basic.concurrency;

public class StockLevel {

    private int currentInventory;

    public StockLevel(int initInventory) {
        this.currentInventory = initInventory;
    }

    public boolean poll(int quantity) {
        // 3) THREAD #2 enters the method...
        if (currentInventory >= quantity) {
            // 4) THREAD #2 evaluates condition to true as THREAD #1 did not manage to update the inventory

            //  1) BOTTLENECK:
            // if store engine or database lags (heavy workload, multiple users, fetching upstream data, sourcing downstream data)
            // inventory update may be delayed

            //  2) THREAD #1 lags to update current inventory
            currentInventory = currentInventory - quantity;

            return true;
        }
        return false;
    }

}
