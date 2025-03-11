import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 /** This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
   **/


public class CarView extends JFrame{



    public CarView(String title, JPanel drawPanel ,JPanel cPanel, int X, int Y)
    {
        initComponents(title,drawPanel,cPanel, X, Y);
    }


     private void initComponents(String title, JPanel drawPanel,JPanel cPanel, int X, int Y) {

         this.setTitle(title);
         this.setPreferredSize(new Dimension(X,Y));
         this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         this.add(drawPanel);
         this.add(cPanel);

         this.pack();


         // Get the computer screen resolution
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         // Center the frame
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         // Make the frame visible
         this.setVisible(true);
         // Make sure the frame exits when "x" is pressed
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }



    }

