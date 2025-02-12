import java.util.ArrayList;
import java.util.List;

public class garage<T extends Car>
{
    private List<T> cars;




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
        }else throw new RuntimeException("garage is full");

    }
    public void removeCar(T car)
    {
        cars.remove(car);
    }
}
