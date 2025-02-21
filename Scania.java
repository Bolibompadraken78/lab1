import java.awt.*;

public class Scania extends Car {
    private Ramp ramp;
    public  Scania()
    {
        super(2, 200, Color.black, "Scania",0,0);
        ramp = new Ramp(70);
    }

    public void raise(double increase)
    {
        ramp.raise(increase);
    }

    public void lower(double decrease)
    {
        if(getCurrentSpeed() == 0)
        {
            ramp.lower(decrease);
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }
    public double getAngle()
    {
        return ramp.getAngle();
    }

    @Override
    public void move()
    {
        if(ramp.getAngle() == 0)
        {
            super.move();
        }


    }
}
