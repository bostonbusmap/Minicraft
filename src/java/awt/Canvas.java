package java.awt;

import java.awt.image.BufferStrategy;

import com.schneeloch.other.GameView;

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
