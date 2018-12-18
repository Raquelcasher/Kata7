package kata7;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private static final double SecondsPerCycle = 2 * Math.PI / 60;
    private static final double MinutesPerCycle = 2 * Math.PI / (60 * 60);
    private static final double HoursPerCycle = 2 * Math.PI / (60 * 60 * 60);
    private double seconds;
    private double minutes;
    private double hours;
    private final List<Observer> observers = new ArrayList<>();

    public Watch(double seconds, double minutes, double hours) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        Timer timer = new Timer();
        timer.schedule(setTimerTask(),0,1);
    }

    private TimerTask setTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObservers();
            }
        };
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    public void add(Observer o) {
        this.observers.add(o);
    }

    private void step() {
        seconds = normalize(seconds + SecondsPerCycle);
        minutes = normalize(minutes + MinutesPerCycle);
        hours = normalize(hours + HoursPerCycle);
    }

    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update(null,null);
        }
    }

    private double normalize(double d) {
        return d % (2 * Math.PI);
    }



}