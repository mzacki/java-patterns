package edu.ant.patterns.design.strategy;


public class StingerBee {

    private StingStrategy stingStrategy;

    public StingerBee(StingStrategy stingStrategy) {
        this.stingStrategy = stingStrategy;
    }

    public void sting() {
        stingStrategy.sting();
    }

    public void setStingStrategy(StingStrategy stingStrategy) {
        this.stingStrategy = stingStrategy;
    }

}
