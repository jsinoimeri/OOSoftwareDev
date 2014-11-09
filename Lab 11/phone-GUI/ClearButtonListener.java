import java.awt.event.*;


/**
 * SYSC 2004 Fall 2013 Lab 11 Solution
 * 
 * The listener for the dialling buttons (digits 0-9, plus * and #)
 * on a phone keypad.
 * 
 * @version December 2, 2013
 */
public class ClearButtonListener implements ActionListener
{   
	private PhonePanel p;
	
    public ClearButtonListener(PhonePanel p)
    {
    	this.p = p;
    }
   
    public void actionPerformed(ActionEvent event)
    {     
        p.clearText();
    }
}
