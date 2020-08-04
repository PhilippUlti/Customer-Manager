package de.philipp_ulti.klausur.model.timer;

import java.util.Timer;

public class BreakAlarm {

    private final int interval = 59*1000;

    /**
     * method to start a timer
     */
    public void begin() {
        Timer timer = new Timer(true);
        timer.schedule(new BreakTimerTask(),interval,interval);
    }

}
