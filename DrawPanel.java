import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private Map<Car, Point> carPositions = new HashMap<>();
    private Map<Car, BufferedImage> carImages = new HashMap<>();


    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);

    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addCar(Car car, String imagePath) {
        try {
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
            carImages.put(car, image);
            carPositions.put(car, new Point((int) car.posX, (int) car.posY));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void removeCar(Car car)
    {
        carImages.remove(car);
    }

    public void moveit(Car car, int x, int y) {
        Point point = carPositions.get(car);
            point.x = x;
            point.y = y;


    }
    public  Map<Car, BufferedImage> getImages()
    {
        return carImages;
    }
    public BufferedImage getVolvoWorkshopImage()
    {
        return volvoWorkshopImage;
    }
    public Point getvolvoWorkshopPoint()
    {
        return volvoWorkshopPoint;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Map.Entry<Car, Point> entry : carPositions.entrySet()) {
            BufferedImage image = carImages.get(entry.getKey());
            Point point = entry.getValue();
            g.drawImage(image, point.x, point.y, null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
