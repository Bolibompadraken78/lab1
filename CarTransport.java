import java.awt.*;
//import java.lang.classfile.instruction.ReturnInstruction;
import java.util.Stack;

public class CarTransport extends Car{
    private Stack<Car> cars = new Stack<>();
    private Ramp ramp = new Ramp(1);
    private int maxAmount;
    public  CarTransport(int maxAmount)
    {
        super(2 , 300, Color.red, "CarTransport",0,0);
        this.maxAmount = maxAmount;

    }

    public void raise()
    {
        ramp.raise(1);
    }


    public void lower()
    {
        if(getCurrentSpeed() == 0)
        {
            ramp.lower(1);
            System.out.println("fast");
        }


    }
    public void addCar(Car car)
    {
        if(distance(car, this) < 20 && car.getClass() != CarTransport.class && ramp.getAngle() == 0 && cars.size() < maxAmount)
        {
            cars.push(car);
            car.posX = this.posX;
            car.posY = this.posY;


        }
        else
        {
            throw new RuntimeException("Car not close enough or car is a transport or ramp is not down or transport is full");
        }


    }
    public void removeCar()
    {
        if(ramp.getAngle() == 0)
        {
            cars.peek().startEngine();
            cars.peek().move();

            cars.pop();
        }



    }
    public Stack<Car> getCars()
    {
        return cars;
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public void move()
    {
        if(ramp.getAngle() == 1)
        {
            super.move();

            for(Car c : cars)
            {
                c.posX = this.posX;
                c.posY = this.posY;
            }
        }
    }


}
