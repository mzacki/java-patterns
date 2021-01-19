package edu.ant.patterns.basic.oop.anthill;

import java.util.Set;

/**
 * Created by Matt on 29.12.2018 at 10:35.
 */

public class Anthill {

    // Association: objects of different classes are inter-related
    // exemplary use in entity relations like many-to-many, one-to-many etc.

    // Composition is narrower kind of association with one-way
    // relationship (HAS-A).
    private Pantry pantry;

    // Aggregation occurs when there is two-way relation
    // (eg. no anthill without dwellers, no dwellers without anthill)
    // a.k.a PART-OF
    private Set<Dweller> dwellers;

    public Anthill(Pantry pantry, Set<Dweller> dwellers) {
        this.pantry = pantry;
        this.dwellers = dwellers;
    }

    // Encapsulation example: no way to access private fields from outside
    // unless using getters and setters methods.
    public Pantry getPantry() {
        return pantry;
    }

    public void setPantry(Pantry pantry) {
        this.pantry = pantry;
    }

    public Set<Dweller> getDwellers() {
        return dwellers;
    }

    public void setDwellers(Set<Dweller> dwellers) {
        this.dwellers = dwellers;
    }

}
