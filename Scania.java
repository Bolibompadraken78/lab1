import java.awt.*;

public class Scania extends Lorry {

    public  Scania()
    {
        super(2, 200, Color.black, "Scania");
    }

    @Override
    public void raise()
    {
        throw new IllegalArgumentException ("must have a amount");
    }
    public void raise(double increase)
    {
        if(increase < 0 || getCurrentSpeed() != 0)//make sure not increase is negatve or moving
        {
            return;
        }
        else if(angle + increase > 70)
        {
            angle = 70;

        }
        else
        {
            angle += increase;
        }
    }

    @Override
    public void lower()
    {
        throw new IllegalArgumentException ("must have a amount");
    }
    public void lower(double decrease)
    {
        if(decrease < 0 || getCurrentSpeed() != 0)//make sure not decrease is negatve or moving
        {
            return;
        }
        else if(angle - decrease < 0)
        {
            angle = 0;

        }
        else
        {
            angle -= decrease;
        }
    }

}
