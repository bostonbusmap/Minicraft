package fakejava.awt.image;

import fakejava.awt.Graphics;

import android.graphics.Canvas;

public class BufferStrategy {

	public Graphics getDrawGraphics(Canvas canvas) {
		return new Graphics(canvas);
	}

	public void show() {
		
	}

}
