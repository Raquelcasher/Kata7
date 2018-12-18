package kata7;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class WatchPresenter implements Observer{

    private Watch watch;
    private WatchDisplay watchDisplay;

    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watchDisplay = watchDisplay;
        this.watch.add(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.watchDisplay.paint(PointOf(watch.getSeconds(), watch.getMinutes(), watch.getHours()));
    }

    private Point[] PointOf(double seconds, double minutes, double hours) {
        Point[] points = new Point[3];
        points[0] = PointOf(seconds, 120);
        points[1] = PointOf(minutes,100);
        points[2] = PointOf(hours, 75);
        return points;
    }

    private Point PointOf(double value, int length) {
        return new Point(toInt(Math.cos(value) * length), toInt(Math.sin(value) * length));
    }

    private int toInt(double d) {
        return (int) d;
    }
}