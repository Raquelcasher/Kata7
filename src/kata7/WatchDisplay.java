package kata7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel{
    private Point[] points = new Point[3];

    public void paint (Point[] points) {
        this.points = points;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        int width = 2;
        int xo = getWidth() / 2;
        int yo = getHeight() / 2;
        for (Point point : points) {
            g2(g).setStroke(new BasicStroke(width ++));
            g.drawLine(xo, yo, xo - point.x, yo - point.y);
        }
    }

    private Graphics2D g2 (Graphics g) {
        return (Graphics2D) g;
    }
}