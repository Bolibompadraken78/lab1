import java.awt.*;

public abstract class Lorry extends Car {
    public double angle;
    public Lorry(int NrDoors, double enginePower, Color color, String modelName)
    {
        super(NrDoors, enginePower, color, modelName);
    }
    @Override
    public double speedFactor()
    {
        return 1;
    }
    public abstract void raise();

    public abstract void lower();


    public void move()
    {
        if(angle != 0)
        {
            return;
        }
        super.move();

    }

    public double getAngle()
    {
        return angle;
    }
}
