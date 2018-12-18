package kata7;

import javax.swing.JFrame;

public class Main extends JFrame {

    public Main(Watch watch, WatchDisplay watchDisplay) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Watch");
        new WatchPresenter(watch, watchDisplay);
        this.add(watchDisplay);
    }

    public void launch() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main(new Watch(Math.PI/2, Math.PI/2, Math.PI/2), new WatchDisplay()).launch();
    }

}