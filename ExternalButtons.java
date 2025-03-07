import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExternalButtons extends JFrame {

    private Application application;
    private JPanel buttonPanel;
    private CarFactory CarFactory;
    private int maxCars = 4;




    public ExternalButtons() {

        InitComponents();
    }

    public static void main(String[] args)
    {
        Application app = new Application();

        ExternalButtons eB = new ExternalButtons();
        eB.application = app;

    }


    public void InitComponents()
    {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension((800/2)+4, 200)); // Layout for buttons

        JButton addCar =  new JButton("addVolvo");
        JButton removeCar =  new JButton("removeCar");

        buttonPanel.add(addCar);
        buttonPanel.add(removeCar);
        buttonPanel.setBackground(Color.CYAN);
        application.add(buttonPanel);
        application.revalidate();
        application.repaint();

        //Listeners
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar(CarFactory.createVolvo());
            }
        });

        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();
            }
        });




    }
    public void addCar(Vehicle car)
    {
        if(application.cars.size() <= maxCars)
        {
            application.cars.add(car);
        }

    }
    public  void removeCar()
    {
        application.cars.remove(application.cars.getFirst());
    }


}
