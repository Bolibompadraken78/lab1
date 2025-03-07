import java.awt.*;

public abstract class Vehicle implements Movable
{

    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int dir = 1;
    //should be protected but test is not a subtybe of car
    public double posX;
    public double posY;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car



    public Vehicle(Color color, String modelName,double posX, double posY, int nrDoors, double enginePower)
    {
        this.color = color;
        this.modelName = modelName;
        this.posX = posX;
        this.posY = posY;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;

    }
    @Override
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

    @Override
    public void turnLeft() {
        dir = (dir + -1 + 4)  % 4;
    }

    @Override
    public void turnRight() {
        dir = (dir + 1) % 4;
    }

    @Override
    public void gas(double amount) {
        incrementSpeed( Math.max(0, Math.min(1, amount)));
    }

    @Override
    public void brake(double amount) {
        decrementSpeed(Math.max(0, Math.min(1, amount)));
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
    public int getNrDoors(){return nrDoors;}

    public double getEnginePower(){
        return enginePower;
    }





    //methods that the child classes have different implementations to
    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public double distance(Car car1, Car car2)
    {
        return (Math.sqrt((Math.pow(car1.posX - car2.posX, 2)) + (Math.pow(car1.posY - car2.posY, 2))));
    }
    public int getDir()
    {
        return dir;
    }

}
