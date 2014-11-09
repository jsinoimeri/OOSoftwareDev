import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The listener for the Tick button in the clock UI.
 */
public class ResetButtonListener implements ActionListener
{
   private ClockPanel panel;
   private RollOverCounter counter;
   
   /**
    * The listener stores references to the minutes counter in the 
    * clock and the panel in its user interface.
    */
   public ResetButtonListener(ClockPanel panel, RollOverCounter counter)
   {
      this.panel = panel;
      this.counter = counter;
   }
   
   /**
    * Calls methods to increment the clock and update the UI to
    * reflect the new state of the clock.
    */
   public void actionPerformed(ActionEvent event)
   {
	   this.counter.reset();
	   this.panel.refreshUI();
   }
}