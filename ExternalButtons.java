import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExternalButtons extends JFrame {

    private Application application;
    private JPanel buttonPanel;
    private CarFactory CarFactory;
    private int maxCars = 4;




    public ExternalButtons(Application app) {
        CarFactory = new CarFactory();
        application = app;
        InitComponents();
    }

    public static void main(String[] args)
    {

        Application app = new Application();
        new ExternalButtons(app);



    }


    public void InitComponents()
    {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100, 100)); // Layout for buttons

        JButton addCar =  new JButton("addVolvo");
        JButton removeCar =  new JButton("removeCar");

        buttonPanel.add(addCar);
        buttonPanel.add(removeCar);
        buttonPanel.setBackground(Color.CYAN);
        application.add(buttonPanel, BorderLayout.SOUTH);
        application.pack();
        application.revalidate();
        application.repaint();

        //Listeners
        addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();
            }
        });




    }
    public void addCar()
    {
        if(application.getNumberOfCars() <= maxCars)
        {
            application.addCar(CarFactory.createVolvo());
        }

    }
    public  void removeCar()
    {
        application.removeCar();
    }


}
