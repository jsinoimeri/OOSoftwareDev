import java.awt.*;
import javax.swing.*;


public class PhonePanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	private JLabel number;
	private KeypadPanel keypad;
	private JButton clear;
	
	
	public PhonePanel()
	{
		ClearButtonListener listener = new ClearButtonListener(this);
		
		setLayout(new BorderLayout());
		this.number = new JLabel(" ");
		this.keypad = new KeypadPanel(this);
		this.clear = new JButton("Clear");
		
		
		add(number, BorderLayout.NORTH);
		add(clear);
		add(keypad, BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(200, 300));

		
		this.clear.addActionListener(listener);
	}
	
	
	public void clearText() 
	{
		this.number.setText(" ");
	}

	
	public void refreshUI(String text)
	{
		String s = this.number.getText() + text;
		
		this.number.setText(s);
	}
}
