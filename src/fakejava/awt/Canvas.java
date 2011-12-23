package fakejava.awt;


import com.schneeloch.other.GameView;

import fakejava.awt.image.BufferStrategy;

public class Canvas {
	private GameView gameView;
	
	public void setGameView(GameView gameView)
	{
		this.gameView = gameView;
		
	}
	
	protected boolean hasFocus()
	{
		return true;
	}
	
	protected BufferStrategy getBufferStrategy()
	{
		return new BufferStrategy();
	}
	
	protected BufferStrategy createBufferStrategy(int x)
	{
		return new BufferStrategy();
	}
	
	protected void requestFocus()
	{
		
	}
}
