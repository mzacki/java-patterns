package edu.ant.patterns.basic.polymorphism;

class Parent {

    String field = "parent";

    String getField() {
        return field;
    }

    static String staticGetter() {
        return "staticGetter() parent";
    }

    String dynamicGetter() {
        return "dynamicGetter() parent";
    }

    private void method() {
        System.out.println("Private method from Parent (superclass)");
    }

    public static void main(String[] args) {
        Parent parent = new SubClass(); // upcasting
        SubClass subClass = new SubClass();
        parent.method(); // prints: "private method from Parent (superclass)", so Parent method is invoked, not SubClass method
        // there is no runtime binding here, Parent method is private, hence final, prevents overriding
        // "Parent parent" refrence calls method() from Parent, although it is SubClass() object.

        System.out.println(parent.field); // parent - from Parent (compile-type binding)
        System.out.println(parent.getField()); // subclass - from SubClass (polymorphism, runtime binding)
        System.out.println(subClass.field); // subclass
        System.out.println(subClass.getField()); // subclass
        System.out.println(subClass.getParentField()); // parent

        System.out.println(parent.dynamicGetter()); // dynamicGetter() subclass
        System.out.println(parent.staticGetter()); // staticGetter() parent
        System.out.println(subClass.dynamicGetter()); // dynamicGetter() subclass
        System.out.println(subClass.staticGetter()); // staticGetter() subclass
    }

}
