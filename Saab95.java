import java.awt.*;

public class Saab95 extends Car {
    public boolean turboOn; //test needs it to be public

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    setTurboOff();
    }
    //assume only Saab class should have turbo
    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return super.getEnginePower() * 0.01 * turbo;
    }




}
