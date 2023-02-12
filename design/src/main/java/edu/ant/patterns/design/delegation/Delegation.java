package edu.ant.patterns.design.delegation;

public class Delegation {

    /**
     * Delegation lays between Inheritance and Composition paradigm.
     * Java does not support Delegation (according to Eckel).
     * Delegation methods can be generated automatically in Intellij IDEA:
     * ALT + INSERT -> Delegate Methods...
     * <a href="https://www.jetbrains.com/help/idea/generating-code.html#generate-delegation-methods">...</a>
     * Delegation is considered as cleaner than is-like-a inheritance:
     * <a href="https://www.jetbrains.com/help/idea/replace-inheritance-with-delegation.html#replace_inheritance_example">...</a>
     * */

    private final DelegationControls delegationControls = new DelegationControls();

    public <T> void control(T param) {
        delegationControls.control(param);
    }

    public <T> void accept(T param) {
        delegationControls.accept(param);
    }

    public <T> void reject(T param) {
        delegationControls.reject(param);
    }

    public <T> void cancel(T param) {
        delegationControls.cancel(param);
    }

}
