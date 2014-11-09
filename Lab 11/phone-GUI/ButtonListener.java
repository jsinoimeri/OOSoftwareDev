import java.awt.event.*;
import javax.swing.*;

/**
 * SYSC 2004 Fall 2013 Lab 11 Solution
 * 
 * The listener for the dialling buttons (digits 0-9, plus * and #)
 * on a phone keypad.
 * 
 * @version December 2, 2013
 */
public class ButtonListener implements ActionListener
{   
	private PhonePanel p;
	
    public ButtonListener(PhonePanel p)
    {
    	this.p = p;
    }
   
    public void actionPerformed(ActionEvent event)
    {
        /* Get a reference to the button that was clicked. */ 
        JButton button = (JButton) event.getSource();
        
        /* Get the text that is displayed on the button. */
        String key = button.getText();
        
        
        p.refreshUI(key);
    }
}
