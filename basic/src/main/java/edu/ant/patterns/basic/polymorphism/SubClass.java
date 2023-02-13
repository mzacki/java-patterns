package edu.ant.patterns.basic.polymorphism;

class SubClass extends Parent {

    String field = "subclass";

    String getField() {
        return this.field;
    }

    String getParentField() {
        return super.field;
    }

    static String staticGetter() {
        return "staticGetter() subclass";
    }

    String dynamicGetter() {
        return "dynamicGetter() subclass";
    }

    private void method() {
        System.out.println("Private method from SubClass");
    }

}
