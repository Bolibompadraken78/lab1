import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class    CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
     CarView frame;
    // A list of cars, modify if needed
     ArrayList<Car> cars = new ArrayList<>();
     garage<Volvo240> volovGarage;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

         cc.cars.add(new Volvo240());
         cc.cars.add(new Saab95());
         cc.cars.add(new Scania());

        cc.volovGarage = new garage<>(5);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        //adds car pic to panel
        for (Car car : cc.cars) {
            cc.frame.drawPanel.addCar(car, "pics/" + car.getClass().getSimpleName() + ".jpg");
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move();
                int x = (int) Math.round(cars.get(i).posX);
                int y = (int) Math.round(cars.get(i).posY);
                Point carDimension = new Point(frame.drawPanel.getImages().get(cars.get(i)).getWidth(), frame.drawPanel.getImages().get(cars.get(i)).getHeight());
                Point workshopP = frame.drawPanel.getvolvoWorkshopPoint();
                BufferedImage workshopImg = frame.drawPanel.getVolvoWorkshopImage();

                if(x + carDimension.x >= frame.getWidth() || x <= 0)
                {

                    cars.get(i).turnRight();
                    cars.get(i).turnRight();


                }
                if(cars.get(i) instanceof Volvo240
                        && x + carDimension.x >= workshopP.x && x <= workshopP.x + workshopImg.getWidth()
                        && y + carDimension.y >= workshopP.y && y <= workshopP.y + workshopImg.getHeight())
                {

                    volovGarage.addCar((Volvo240) cars.get(i));
                    frame.drawPanel.removeCar(cars.get(i));
                    cars.remove(cars.get(i));


                }
                frame.drawPanel.moveit(cars.get(i),x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;

        for (Car car : cars)
        {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void raise(double amount) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raise(amount);
            }
        }
    }
    void lower(double amount) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lower(amount);
            }
        }
    }
    void startEngine() {
        for (Car car : cars) {

                 car.startEngine();

        }
    }
    void stopEngine() {
        for (Car car : cars) {

            car.stopEngine();

        }
    }

}
