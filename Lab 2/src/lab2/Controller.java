package lab2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Controller implements ActionListener
{
	private JButton temp = new JButton();
	private Model m;
	public Controller(Model m)
	{
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		temp = (JButton)e.getSource();
		if(temp.getText() == "")
		{
			m.updateGameModel(Integer.parseInt(temp.getName()));
		}
		else
		{
			
		}
	}

}
