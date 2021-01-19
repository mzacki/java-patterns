package edu.ant.patterns.design.composite;

import edu.ant.patterns.utils.logger.LoggingService;
import java.util.List;

public class Branch implements BranchPart {

    private final List<BranchPart> parts;

    // branch consists of parts (eg.leaves)
    public Branch(List<BranchPart> parts) {
        this.parts = parts;
    }

    // If you cut the branch....
    @Override
    public boolean cut() {
        LoggingService.logMsg("Branch has been cut");
        // You will cut all the leaves as well!
        parts.forEach(BranchPart::cut);
        return true;
    }
}
