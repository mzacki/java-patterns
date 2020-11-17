package edu.ant.patterns.factory;

/**
 * Factory method design pattern. Although any single bee plays various roles during her life, from simple cleaner
 * through soldier to skilled worker, for the sake of clarity we assume that there exists central bee factory that
 * fetches bee resources of given type accordingly to colony's demand.
 */

public class BeeFactory {

    public Bee create(BeeRole role) {
        switch (role) {
            case CLEANER:
                return new Cleaner();
            case NURSE:
                return new Nurse();
            case SENTRY:
                return new Sentry();
            case SOLDIER:
                return new Soldier();
            case WORKER:
                return new Worker();
            default:
                throw new IllegalArgumentException("No such role in the beehive!");
        }
    }

}
