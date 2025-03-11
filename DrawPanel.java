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

    private Map<Object, Point> objPositions = new HashMap<>();
    private Map<Object, BufferedImage> carImages = new HashMap<>();


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

    public void addCar(Object obj, String imagePath, int X, int Y) {
        try {
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
            carImages.put(obj, image);
            objPositions.put(obj, new Point( X,  Y));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void removeCar(Object obj)
    {

        carImages.remove(obj);

    }

    public void moveit(Object obj, int x, int y) {
        Point point = objPositions.get(obj);
            point.x = x;
            point.y = y;


    }
    public  Map<Object, BufferedImage> getImages()
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
        for (Map.Entry<Object, Point> entry : objPositions.entrySet()) {
            BufferedImage image = carImages.get(entry.getKey());
            Point point = entry.getValue();
            g.drawImage(image, point.x, point.y, null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
