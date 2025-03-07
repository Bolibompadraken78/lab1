import javax.swing.*;
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


    private CarController cc;

    private garage<Volvo240> volovGarage;
    private ArrayList<Vehicle> cars = new ArrayList<>();
    private DrawPanel drawPanel;
    private CarManager carManager;

    public static void main(String[] args)
    {
        Application app = new Application();
        app.drawPanel = new DrawPanel(X, Y-240);
        CarFactory carFactory = new CarFactory();
        app.carManager = new CarManager(app.cars);

        app.cc = new CarController("CarSim 1.0",X, Y, app.drawPanel, app.carManager );
        //app.drawPanel = new DrawPanel(X, Y-240);



        app.cars.add(carFactory.createVolvo());
        app.cars.add(carFactory.createSaab());
        app.cars.add(carFactory.createScania());

        app.volovGarage = new garage<>(5);

        for (Vehicle car : app.cars) {
            app.drawPanel.addCar(car, "pics/" + car.getClass().getSimpleName() + ".jpg");
        }
        app.cc.add(app.drawPanel);
        app.timer.start();

    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).posX);
                int y = (int) Math.round(cars.get(i).posY);
                Point carDimension = new Point(drawPanel.getImages().get(cars.get(i)).getWidth(), drawPanel.getImages().get(cars.get(i)).getHeight());
                Point workshopP = drawPanel.getvolvoWorkshopPoint();
                BufferedImage workshopImg = drawPanel.getVolvoWorkshopImage();

                if(x + carDimension.x >= cc.getWidth() || x <= 0)
                {

                    cars.get(i).turnRight();
                    cars.get(i).turnRight();


                }
                if(cars.get(i) instanceof Volvo240
                        && x + carDimension.x >= workshopP.x && x <= workshopP.x + workshopImg.getWidth()
                        && y + carDimension.y >= workshopP.y && y <= workshopP.y + workshopImg.getHeight())
                {

                    volovGarage.addCar((Volvo240) cars.get(i));
                    drawPanel.removeCar(cars.get(i));
                    cars.remove(cars.get(i));


                }
                drawPanel.moveit(cars.get(i),x, y);
                // repaint() calls the paintComponent method of the panel
                drawPanel.repaint();
            }
        }
    }
}
