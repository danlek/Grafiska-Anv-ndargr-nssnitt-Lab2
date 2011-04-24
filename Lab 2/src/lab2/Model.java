package lab2;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Model 
{
	private class ModelData
	{
		private String first;
		private String second;
		private String third;

		public ModelData()
		{
			first = "a";
			second = "b";
			third = "c";
		}
		public void setModelData(String data, int whichOne)
		{ 
			switch(whichOne)
			{
			case 1:
				first = data;
				break;
			case 2:
				second = data;
				break;
			case 3:
				third = data;
				break;
			}  
		}
		public Boolean processModelData()
		{
			Boolean connected = false;
			if (first == second && second == third)
			{
				connected = true;
			}
			return connected;
		}

		public void purgeModelData()
		{
			first = "a";
			second = "b";
			third = "c";
		}
	}

	private ModelData[] dataz;
	private ArrayList<Observer> observerList;
	private boolean gameOverManGameOver;
	private int counter;
	private String symbol;
	private int whichButton;
	public Model()
	{
		dataz = new ModelData[9];
		for(int i = 0; i < dataz.length; i++)
		{
			dataz[i] = new ModelData();
		}
		gameOverManGameOver = false;
		observerList = new ArrayList<Observer>();
		counter = 0;
	}
	public void addObserver(Observer o)
	{
		observerList.add(o);
	}
	public void notifyObservers()
	{
		for(int i = 0; i < observerList.size(); i++)
		{
			observerList.get(i).Notify();
		}
	}
	public void updateGameModel(int whichButton)
	{
		this.whichButton = whichButton;
		if (counter % 2 == 0)
		{
			symbol = "O";
		}
		else
		{
			symbol = "X";
		}
		switch (whichButton)
		{
		case 0:
			dataz[0].setModelData(symbol, 1);

			dataz[3].setModelData(symbol, 1);

			dataz[6].setModelData(symbol, 1);

			notifyObservers();

			checkGameModel("036");

			break;
		case 1:
			dataz[0].setModelData(symbol, 2);

			dataz[4].setModelData(symbol, 1);

			notifyObservers();

			checkGameModel("04");

			break;
		case 2:
			dataz[0].setModelData(symbol, 3);

			dataz[5].setModelData(symbol, 1);

			dataz[7].setModelData(symbol, 1);

			notifyObservers();

			checkGameModel("057");

			break;
		case 3:
			dataz[1].setModelData(symbol, 1);

			dataz[3].setModelData(symbol, 2);

			notifyObservers();

			checkGameModel("13");

			break;
		case 4:
			dataz[1].setModelData(symbol, 2);

			dataz[4].setModelData(symbol, 2);

			dataz[6].setModelData(symbol, 2);

			dataz[7].setModelData(symbol, 2);

			notifyObservers();

			checkGameModel("1467");

			break;
		case 5:
			dataz[1].setModelData(symbol, 3);

			dataz[5].setModelData(symbol, 2);

			notifyObservers();

			checkGameModel("15");

			break;
		case 6:
			dataz[2].setModelData(symbol, 1);

			dataz[3].setModelData(symbol, 3);

			dataz[7].setModelData(symbol, 3);

			notifyObservers();

			checkGameModel("237");

			break;
		case 7:
			dataz[2].setModelData(symbol, 2);

			dataz[4].setModelData(symbol, 3);

			notifyObservers();

			checkGameModel("24");

			break;
		case 8:
			dataz[2].setModelData(symbol, 3);

			dataz[5].setModelData(symbol, 3);

			dataz[6].setModelData(symbol, 3);

			notifyObservers();

			checkGameModel("256");

			break;
		}
	}
	public String getSymbol()
	{
		return symbol;
	}
	public int getWhichButton()
	{
		return whichButton;
	}
	public boolean isGameOver()
	{
		return gameOverManGameOver;
	}
	public void checkGameModel(String index)
	{ 
		Boolean connected = false;
		for(int i = 0; i < index.length(); i++)
		{
			int a = Integer.parseInt(String.valueOf(index.charAt(i)));
			connected = dataz[a].processModelData();
			if (connected == true)
			{
				gg();
				break;
			}
		}
		if(counter == 8 && connected == false)
		{
			tie();
		}
		else if(counter < 8 && connected == false)
		{
			counter++;
		}
	}
	public void gg()
	{
		JOptionPane.showMessageDialog(null, "GG, " + symbol + " vann!");
		gameOverManGameOver = true;
		notifyObservers();
		purgeGameModel();
	}
	public void tie()
	{
		JOptionPane.showMessageDialog(null, "Oavgjort!");
		gameOverManGameOver = true;
		notifyObservers();
		purgeGameModel();
	}
	public void purgeGameModel()
	{
		for(int i = 0; i < dataz.length; i++)
		{
			dataz[i].purgeModelData();
		}
		gameOverManGameOver = false;
		counter = 0;
	}
}

