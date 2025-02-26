import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240",1,300);
    }

    @Override
    public double speedFactor(){
        return super.getEnginePower() * 0.01 * trimFactor;
    }



}
