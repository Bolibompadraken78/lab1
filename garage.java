import java.util.ArrayList;
import java.util.List;

public class garage<T extends Car>
{
    private List<T> cars = new ArrayList<>(0);




    int maxAmount;

    public garage(int maxAmount)
    {

        this.maxAmount = maxAmount;

    }
    public void addCar(T car)
    {
        if(cars.size() < maxAmount)
        {
                cars.add(car);
        }
        else throw new RuntimeException("garage is full" + cars);

    }
    public void removeCar(T car)
    {
        cars.remove(car);
    }
}
