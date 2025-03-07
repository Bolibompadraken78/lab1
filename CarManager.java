import java.util.ArrayList;

public class CarManager{

    private ArrayList<Vehicle> cars = new ArrayList<>();

    public CarManager (ArrayList<Vehicle> cars)
    {
        this.cars = cars;
    }

    public void AddCar(Car car)
    {
        cars.add(car);
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
}