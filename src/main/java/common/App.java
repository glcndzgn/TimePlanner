package common;

import core.TimePlanner;
import widgets.Chronometer;
import widgets.Today;
import widgets.UtcClock;

public class App {
    public App() {
    }

    public void startTimePlanner(){
        TimePlanner timePlanner = new TimePlanner();

        timePlanner.add(new UtcClock());
        timePlanner.add(new Today());
        timePlanner.add(new Chronometer());

        timePlanner.start();

    }
}
