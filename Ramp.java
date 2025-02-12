public class Ramp {

    private double currentAngle;
    private double maxAngle;
    public Ramp(int maxAngle)
    {
        this.maxAngle = maxAngle;
    }


    public void raise(double increase)
    {
        if(increase < 0)//make sure not increase is negatve or moving
        {
            return;
        }
        else if(currentAngle + increase > maxAngle)
        {
            currentAngle = maxAngle;


        }
        else
        {
            currentAngle += increase;
        }
    }

    public void lower(double decrease)
    {
        if(decrease < 0)//make sure not decrease is negatve or moving
        {
            return;
        }
        else if(currentAngle - decrease < 0)
        {
            currentAngle = 0;

        }
        else
        {
            currentAngle -= decrease;
        }
    }



    public double getAngle()
    {
        return currentAngle;
    }

}
