package edu.ant.patterns.builder;

import java.util.List;

public class Beehive {

    private Type type;
    private List<Box> boxes;
    private int height;
    private Colony colony;

    private Beehive() {}

    public Type getType() {
        return type;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public int getHeight() {
        return height;
    }

    public Colony getColony() {
        return colony;
    }

    public static class Builder {

        private final Beehive beehive;

        public Builder() {
            beehive = new Beehive();
        }

        public Builder setType(Type type) {
            beehive.type = type;
            return this;
        }

        public Builder setBoxes(List<Box> boxes) {
            beehive.boxes = boxes;
            beehive.height = boxes.size();
            return this;
        }

        public Builder setColony(Colony colony) {
            beehive.colony = colony;
            return this;
        }

        public Builder setHeight(int height) {
            beehive.height = height;
            return this;
        }

        public Beehive build() {
            return beehive;
        }
    }

    @Override
    public String toString() {
        return "Beehive{" +
                "type=" + type +
                ", boxes=" + boxes +
                ", height=" + height +
                ", colony=" + colony +
                '}';
    }
}
