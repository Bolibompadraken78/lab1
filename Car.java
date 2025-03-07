import java.awt.*;

public abstract class Car extends Vehicle{
    public Car(int NrDoors, double enginePower, Color color, String modelName, int x, int y)
    {
        super(color,modelName,x,y,NrDoors,enginePower);


        stopEngine();
    }





}
