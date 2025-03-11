public class CarFactory {
    public static Car createVolvo()
    {
        return new Volvo240();
    }
    public Car createSaab()
    {
        return new Saab95();
    }
    public Car createScania()
    {
        return new Scania();
    }

}
