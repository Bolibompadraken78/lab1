import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Application{

    private final int delay = 50;
    private Timer timer = new Timer(delay, new Application.TimerListener());
    private static final int X = 800;
    private static final int Y = 800;
    private CarManager cM;

    public Application()
    {
        DrawPanel drawPanel = new DrawPanel(X, Y-240);
        garage<Volvo240> volovGarage = new garage<>(5);

        this.cM = new CarManager(drawPanel,volovGarage,X);
        CarController cc = new CarController(cM, X);
        CarView carView = new CarView("CarSim 1.0", drawPanel, cc.getControlPanel2(), X, Y);

        timer.start();
    }

    public static void main(String[] args)
    {
        new Application();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
              cM.update();
        }
    }









}
