package edu.ant.patterns.design.strategy;

import edu.ant.patterns.utils.logger.LoggingService;


public class DeterrenceStingStrategy implements StingStrategy {

    @Override
    public void sting() {
        LoggingService.logMsg("Sting attack as a last resort (remember not to sting too deeply)");
    }

}
