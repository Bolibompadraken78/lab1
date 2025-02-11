import java.awt.*;
import java.util.Stack;

public class CarTransport extends Lorry {
    public Stack<Car> cars = new Stack<>();
    public  CarTransport()
    {
        super(2 , 300, Color.red, "Biltransport");
    }
    @Override
    public void raise()
    {
        angle = 0;//this is up
    }

    @Override
    public void lower()
    {
        if(getCurrentSpeed() != 0)
        {
            return;
        }
        angle = 1;
    }
    public void addCar(Car car)
    {
        if(distance(car, this) < 20 && car.getClass() != CarTransport.class && angle == 1)
        {
            cars.push(car);
            car.posX = this.posX;
            car.posX = this.posY;


        }
        else
        {
            throw new RuntimeException("Car not close enough or car is a transport or ramp is not down");
        }


    }
    public void removeCar()
    {
        if(angle == 1)
        {
            cars.peek().posX = this.posX +5;
            cars.pop();
        }



    }
    @Override
    public void move()
    {
        if(angle !=0)
        {
            return;
        }
        super.move();
        for(Car c : cars)
        {
            c.posX = this.posX;
            c.posY = this.posY;
        }

    }

}
