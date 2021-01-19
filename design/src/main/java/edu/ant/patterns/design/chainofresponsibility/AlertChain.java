package edu.ant.patterns.design.chainofresponsibility;

public abstract class AlertChain {

    // next link in the chain
    private AlertChain link;

    public void appendLink(AlertChain link) {
        this.link = link;
    }

    // prompting next link to act if exists
    public void callNextLink() {
        if (link != null) {
            link.perform();
        }
    }

    // performing hands-on action
    abstract void perform();
}
