import java.util.ArrayList;
import java.util.List;

public class garage
{
    private List<Car> cars;
    private Car allowedCar;
    int maxAmount;
    public garage(Car allowedCar,int maxAmount)
    {
        this.maxAmount = maxAmount;
        this.allowedCar = allowedCar;
    }
    public garage(int maxAmount)
    {
        this.maxAmount = maxAmount;

    }
    public void addCar(Car car)
    {
        if(cars.size() < maxAmount)
        {
            if (allowedCar == null) {
                cars.add(car);
            } else if (car.getClass() == allowedCar.getClass()) {
                addCar(car);
            }else throw new RuntimeException("wrong car type");
        }else throw new RuntimeException("garage is full");

    }
    public void removeCar(Car car)
    {
        cars.remove(car);
    }
}
