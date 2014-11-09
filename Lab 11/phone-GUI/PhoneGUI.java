import javax.swing.JFrame;

/**
 * SYSC 2004 Fall 2013 Lab 11 Solution
 * A mockup of the GUI for a telephone.
 * 
 * @version December 2, 2013
 */
public class PhoneGUI
{
   /**
    * Creates and displays the main program frame.
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Telephone");
      PhonePanel panel = new PhonePanel();
      
      frame.getContentPane().add(panel);      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
   
}
