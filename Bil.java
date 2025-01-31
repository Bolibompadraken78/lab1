import java.awt.*;

public abstract class Bil implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    //these are public because test class needs to access these direct due to no get methods exist for these variables
    public int dir = 0;
    public double posX;
    public double posY;


    public Bil(int NrDoors, double enginePower, Color color, String modelName)
    {
        this.nrDoors = NrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){return nrDoors;}

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }



    //methods that the child classes have different implementations to
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed( Math.max(0, Math.min(1, amount)));
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(Math.max(0, Math.min(1, amount)));
    }

    public void move() {

        switch (this.dir)
        {
            case 0:
                posY += currentSpeed;
                break;
            case 1:
                posX += currentSpeed;
                break;
            case 2:
                posY -= currentSpeed;
                break;
            case 3:
                posX -= currentSpeed;
                break;
            default:
                System.out.println(dir +  " " + getCurrentSpeed());
        }
    }

    public void turnLeft() {
        dir = (dir + -1 + 4)  % 4;
    }//plus 4 because -1 mod 4 is not 3 for some reason

    public void turnRight() {
        dir = (dir + 1) % 4;
    }
}
