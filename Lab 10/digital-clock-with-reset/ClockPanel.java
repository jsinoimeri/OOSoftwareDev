import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A panel containing a digital clock display ("hh : mm") and a 
 * button to increment the time by one minute each time it is pushed.
 */
public class ClockPanel extends JPanel
{
   private RollOverCounter minutes;
   private RollOverCounter hours;
   
   private JLabel hoursDisplay;
   private JLabel minutesDisplay;
   private JLabel colon;
  private JButton tickButton,
   				   resetButton;
   
   private TickButtonListener listener;
   private ResetButtonListener reset_listener;

   /**
    * Initializes the user interface.
    */
   public ClockPanel()
   {
      tickButton = new JButton("Tick"); 
      hoursDisplay = new JLabel("  ");
      minutesDisplay = new JLabel("  ");
      colon = new JLabel(":");
      resetButton = new JButton("Reset");
   
      /* Place the button and the labels in the panel. */
      add(tickButton);
      add(hoursDisplay);
      add(colon);
      add(minutesDisplay);
      add(resetButton);

      // setBackground (Color.cyan);
      setPreferredSize (new Dimension(350, 60));
      
      /* Create the model (a counter that keeps track of minutes, which is chained
       * to a counter that keeps track of hours).
       */      
      hours = new RollOverCounter(0, 23, null);
      minutes = new RollOverCounter(0, 59, hours); 
      
      /* Display the current time. */    
      hoursDisplay.setText("" + hours.toString());
      minutesDisplay.setText("" + minutes.toString());
      
      this.listener = new TickButtonListener(this, this.minutes);
      this.tickButton.addActionListener(this.listener);
      
      this.reset_listener = new ResetButtonListener(this, this.minutes);
      this.resetButton.addActionListener(this.reset_listener);
   }
   
   /**
    * Updates the user interface to show the current time.
    */
   public void refreshUI()
   {
	   hoursDisplay.setText("" + hours.toString());
	   minutesDisplay.setText("" + minutes.toString());
   }      
}