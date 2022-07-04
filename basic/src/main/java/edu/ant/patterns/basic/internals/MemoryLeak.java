package edu.ant.patterns.basic.internals;

/**
 * Example of potential memory leak in Java
 * From nice book
 * Java in a Nutshell. A Desktop Quick Reference 7th Edition
 * by Ben Evans and David Flanagan
 * */

public class MemoryLeak {

    private static int computeSth(int[] array) {
        // stub method, let's return any int
        return array.length;
    }

    private static void doSomething(int result) {
        // stub methd
    }

    public static void main(String args[]) {
        // declaration of big, memory consuming array
        // initially its empty and fill in with zeroes by default
        int[] maxSizeArray = new int[2_147_483_647];
        // max size of array depends on JVM
        // circa  2^31 – 1 (max int size)
        int result = computeSth(maxSizeArray);

        /**
         * At this point, the array is no longer needed, and it could be garbage collected from now on.
         * But maxSizeArray is a local variable, and it keeps the reference to the array object
         * until main method returns.
         * But the main method never returns because it has void keyword.
         * */
        maxSizeArray = null; // explicit cleaning of the reference, otherwise no garbage collection

        // Everlasting loop handling the result derived from the array
        for(;;) doSomething(result);
    }

}
