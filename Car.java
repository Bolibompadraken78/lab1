import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name


    private int dir = 1;
    //should be protected but test is not a subtybe of car
    public double posX;
    public double posY;



    public Car(int NrDoors, double enginePower, Color color, String modelName, int x, int y)
    {
        this.nrDoors = NrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.posX = x;
        this.posY = y;
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

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }



    public void gas(double amount){
        incrementSpeed( Math.max(0, Math.min(1, amount)));
    }


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
    public double distance(Car car1, Car car2)
    {
        return (Math.sqrt((Math.pow(car1.posX - car2.posX, 2)) + (Math.pow(car1.posY - car2.posY, 2))));
    }
    public int getDir()
    {
        return dir;
    }


}
