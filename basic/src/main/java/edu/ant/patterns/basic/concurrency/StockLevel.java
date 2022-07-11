package edu.ant.patterns.basic.concurrency;

public class StockLevel {

    // suppose it's empty or has low stock level
    private int currentInventory;

    public StockLevel(int initInventory) {
        this.currentInventory = initInventory;
    }

    public boolean poll(int quantity) {
        // STEP 2:
        // THREAD #2 concurrently enters the method...
        if (currentInventory >= quantity) {
            // STEP 3:
            // THREAD #2 evaluates condition to true as THREAD #1 has not managed to update the inventory yet

            // STEP 0:
            // BOTTLENECK!
            // if store engine or database lags (heavy workload, multiple users, fetching upstream data, sourcing downstream data)
            // inventory update may be delayed

            //  STEP 1:
            //  THREAD #1 delays the update of current inventory
            currentInventory = currentInventory - quantity;

            Warehouse.fetchItem();
            // STEP 4:
            // RISK OF UNDERSTOCKING!!!
            // both threads fetch product from warehouse
            // THREAD #2 does not know the true level of inventory
            return true;
        }
        return false;
    }

}
