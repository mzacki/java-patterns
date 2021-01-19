package edu.ant.patterns.design.composite;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // let's create tree-like structure
        List<BranchPart> branchParts = Arrays.asList(
                new Fruit(),
                new Leaf(),
                new Leaf(),
                new Leaf(),
                new Branch(Arrays.asList(
                        new Fruit(),
                        new Leaf(),
                        new Leaf()
                ))
        );

        // main branch consists of all of above
        BranchPart branch = new Branch(branchParts);

        // trigger your chain saw and all parts will fall, too...
        branch.cut();
    }

}
