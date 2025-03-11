import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarManager{

    private ArrayList<Vehicle> cars = new ArrayList<>();
    private DrawPanel drawPanel;
    private garage volovGarage;
    private int X;


    public CarManager (DrawPanel drawPanel, garage volovGarage, int X)
    {
        CarFactory carFactory = new CarFactory();

        this.addCar(carFactory.createVolvo());
        this.addCar(carFactory.createSaab());
        this.addCar(carFactory.createScania());

        this.drawPanel = drawPanel;
        this.X = X;
        this.volovGarage = volovGarage;
    }
    void update(){
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
    }
        drawPanel.repaint();

    }


    // Calls the gas method for each car once
    void gas(double gas) {


        for (Vehicle car : cars)
        {
            car.gas(gas);
        }
    }
    void brake(double brake) {
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void raise(double amount) {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raise(amount);
            }
        }
    }
    void lower(double amount) {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lower(amount);
            }
        }
    }
    void startEngine() {
        for (Vehicle car : cars) {

            car.startEngine();

        }
    }
    void stopEngine() {
        for (Vehicle car : cars) {

            car.stopEngine();

        }
    }
    public void addCar(Vehicle car)
    {
        if(cars.size() <6) {
            cars.add(car);
            drawPanel.addCar(car, "pics/" + car.getClass().getSimpleName() + ".jpg", (int) car.posX, (int) car.posY);
        }
    }
    public void removeCar()
    {
        if(cars.size() > 0) {
            System.out.println(cars);
            drawPanel.removeCar(cars.get(0));
            cars.remove(cars.get(0));
            System.out.println(cars);
        }
    }
}