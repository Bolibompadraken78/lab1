import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class Test2 {
    private Car car;
    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;
    private CarTransport carTransport;

    @Before
    public void setUp() {
        volvo = new Volvo240();//NrDoors = 4, enginePower = 100, color = black, name = Volvo240
        saab = new Saab95();//NrDoors = 2, enginePower = 125, color = red, name = Saab95
        scania = new Scania();
        carTransport = new CarTransport(2);

    }

    @Test
    public void testInitialization() {
        assertEquals(2, saab.getNrDoors());
        assertEquals(125, saab.getEnginePower(), 0.0001);
        assertEquals(Color.RED, saab.getColor());
        assertEquals(0, saab.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void testSetColor(){
        saab.setColor(Color.BLACK);
        assertEquals(Color.BLACK, saab.getColor());
    }

    @Test
    public void testStartStopEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.0001);

        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testTurnLeft() {
        saab.turnLeft();
        assertEquals(3, saab.dir);

        saab.turnLeft();
        assertEquals(2, saab.dir);

        saab.turnLeft();
        assertEquals(1, saab.dir);

        saab.turnLeft();
        assertEquals(0, saab.dir);

    }

    @Test
    public void testTurnRight() {
        saab.turnRight();
        assertEquals(1, saab.dir);

        saab.turnRight();
        assertEquals(2, saab.dir);

        saab.turnRight();
        assertEquals(3, saab.dir);

        saab.turnRight();
        assertEquals(0, saab.dir);
    }

    @Test
    public void testMove() {
        // dir = 0 (up)
        saab.startEngine();
        saab.move();
        assertEquals(0.0, saab.posX, 0.0001);
        assertEquals(0.1, saab.posY, 0.0001);

        saab.turnRight(); // dir = 1 (right)
        saab.move();
        assertEquals(0.1, saab.posX, 0.0001);
        assertEquals(0.1, saab.posY, 0.0001);


        saab.turnRight(); // dir = 2 (down)
        saab.move();
        assertEquals(0.1, saab.posX, 0.0001);
        assertEquals(0.0, saab.posY, 0.0001);

        saab.turnRight(); // dir = 3 (left)
        saab.move();
        assertEquals(0.0, saab.posX, 0.0001);
        assertEquals(0.0, saab.posY, 0.0001);

        //dont test deafault
    }

    @Test
    public void testSaabTurbo() {
        saab.setTurboOn();
        assertTrue(saab.turboOn);

        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }

    @Test
    public void testSaabSpeedFactor() {
        saab.setTurboOn();
        double turboSpeedFactor = saab.speedFactor();

        saab.setTurboOff();
        double normalSpeedFactor = saab.speedFactor();

        assertTrue(turboSpeedFactor > normalSpeedFactor);
    }

    @Test
    public void testVolvoSpeedFactor() {
        assertTrue(volvo.speedFactor() > 0);
    }

    //not sure if should be tested
    @Test
    public void testGasAndBrake() {
        saab.startEngine();
        double initialSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        assertTrue(saab.getCurrentSpeed() > initialSpeed);

        saab.brake(0.5);
        assertTrue(saab.getCurrentSpeed() <= initialSpeed);
    }

    //scania tests

    @Test
    public void testRaiseAndLower()
    {
        scania.raise(50);
        assertEquals(50, scania.getAngle(), 0.001);

        scania.raise(50);
        assertEquals(70, scania.getAngle(), 0.001);

        scania.lower(50);
        assertEquals(20, scania.getAngle(), 0.001);

        scania.lower(50);
        assertEquals(0, scania.getAngle(), 0.001);


    }
    @Test
    public void Addcar(){

        carTransport.lower();
        carTransport.addCar(saab);
        carTransport.addCar(volvo);
        carTransport.removeCar();


        assertEquals(saab, carTransport.cars.peek());//last in ws removed so next last in is peek

        carTransport.raise();

        carTransport.startEngine();
        carTransport.move();

        carTransport.dir = 1;
        carTransport.move();

        assertEquals(carTransport.posY, saab.posY , 0.001);//should be 0.1 on both
        assertEquals(carTransport.posX, saab.posX , 0.001);

    }

    @Test
    public void GarageTest()
    {
        garage<Volvo240> volovGarage= new garage<>(2);
        volovGarage.addCar(volvo);
        //volovGarage.addCar(saab); //compiler error
    }



}


