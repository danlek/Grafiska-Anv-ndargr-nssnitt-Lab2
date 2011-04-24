package lab2;
import javax.swing.*;

import java.awt.*;


public class Viewer extends JPanel implements Observer 
{
	private class SpelPlan extends JPanel
	{
		private JButton[] spelPlan;
		private Controller kontroll;
		public SpelPlan(Controller k)
		{
			super(new GridLayout(3, 3));
			kontroll = k;
			spelPlan = new JButton[9];
			for(int i = 0; i < spelPlan.length; i++)
			{
				spelPlan[i] = new JButton();
				spelPlan[i].setName(String.valueOf(i));
				spelPlan[i].setText("");
				spelPlan[i].addActionListener(kontroll);
				this.add(spelPlan[i]);
			}
		}
		public void updateSpelPlan(String symbol, int whichButton)
		{
			spelPlan[whichButton].setText(symbol);
		}
		public void purgeSpelPlan()
		{
			for(int i = 0; i < spelPlan.length; i++)
			{
				spelPlan[i].setText("");
			}
		}
	}
	
	private JFrame frame;
	private Controller c;
	private Model m;
	private SpelPlan spelPlanet;
	public Viewer(int spelPlan, Model m, Controller c)
	{
		super(new GridLayout(0,1));
		frame = new JFrame("Lab 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
		if(spelPlan == 1)
		{
			frame.setLocation(0, 0);
		}
		else
		{
			frame.setLocation(810, 0);
		}

		this.c = c;

		this.m = m;

		spelPlanet = new SpelPlan(c);
		this.add(spelPlanet);

		m.addObserver(this);
	}
	@Override
	public void Notify() 
	{
		if(m.isGameOver())
		{
			reset();
		}
		else
		{
			update();
		}
	}
	public void update()
	{
		spelPlanet.updateSpelPlan(m.getSymbol(), m.getWhichButton());
	}
	public void reset()
	{
		spelPlanet.purgeSpelPlan();
	}

}
