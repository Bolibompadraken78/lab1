import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Application extends JFrame{

    public Application()
    {

        drawPanel = new DrawPanel(X, Y-240);
        CarFactory carFactory = new CarFactory();
        carManager = new CarManager(cars);

        cc = new CarController(carManager, X, Y );

        //app.drawPanel = new DrawPanel(X, Y-240);



        cars.add(carFactory.createVolvo());
        cars.add(carFactory.createSaab());
        cars.add(carFactory.createScania());

        volovGarage = new garage<>(5);

        for (Vehicle car : cars) {
            drawPanel.addCar(car, "pics/" + car.getClass().getSimpleName() + ".jpg");
        }
        // app.cc.add(app.drawPanel);
        initComponents();
        timer.start();
    }

    private final int delay = 50;
    private Timer timer = new Timer(delay, new Application.TimerListener());

    private static final int X = 800;
    private static final int Y = 800;


    private CarController cc;

    private garage<Volvo240> volovGarage;
    ArrayList<Vehicle> cars = new ArrayList<>();
    private DrawPanel drawPanel;
    private CarManager carManager;
    private String title = "CarSim 1.0";



    public static void main(String[] args)
    {
        Application app = new Application();


    }
    private void initComponents() {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);







        // This actionListener is for the gas button only



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(cc.getControlPanel2());
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

                if(x + carDimension.x >= X || x <= 0)
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
