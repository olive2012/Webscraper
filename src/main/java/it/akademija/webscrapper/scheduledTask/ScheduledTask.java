package it.akademija.webscrapper.scheduledTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTask{
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


//    scheduler.scheduleAtFixedRate(yourRunnable,8,8,TimeUnit.HOURS);
}
