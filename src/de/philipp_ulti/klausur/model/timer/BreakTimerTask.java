package de.philipp_ulti.klausur.model.timer;

import javax.swing.*;
import java.util.TimerTask;

public class BreakTimerTask extends TimerTask {

    @Override
    public void run() {
        JOptionPane.showMessageDialog(new JFrame("Message"),"Break time!");
    }
}
