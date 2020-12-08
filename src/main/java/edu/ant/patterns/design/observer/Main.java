package edu.ant.patterns.design.observer;

import edu.ant.utils.logger.LoggingService;

public class Main {
    public static void main(String[] args) {
        BeeMonitor beeMonitor = new BeeMonitor("Monitor1");
        
        beeMonitor.addListener(new Observer("Smartphone1"));
        beeMonitor.addListener(new Observer("Desktop1"));
        beeMonitor.addListener(new Observer("Laptop1"));

        Analyzer analyzer = new Analyzer("Analyzer 1");
        beeMonitor.addListener(analyzer);

        String msg = "Data pack part 1";

        LoggingService.logTwoArgs(beeMonitor.getId(), msg);
        beeMonitor.publish(msg);


        String msg2 = "Data pack part 2";

        LoggingService.logTwoArgs(beeMonitor.getId(), msg2);
        beeMonitor.publish(msg2);
        
    }
}
