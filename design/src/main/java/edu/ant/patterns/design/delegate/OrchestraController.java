package edu.ant.patterns.design.delegate;

public class OrchestraController implements Instrument {

    private Instrument instrument;

    @Override
    public void play() {
        instrument.play();
    }

}
