package fakejava.awt;

import fakejava.awt.image.BufferedImage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graphics {

	private final Canvas canvas;
	private final Paint fillPaint;
	private final Paint picturePaint;
	
	public Graphics(Canvas canvas)
	{
		this.canvas = canvas;
		this.fillPaint = new Paint();
		fillPaint.setStyle(Style.FILL);
		fillPaint.setColor(Color.BLACK);
		
		picturePaint = new Paint();
	}
	
	public void fillRect(int x, int y, int width, int height) {
		canvas.drawRect(x, y, x + width, y + height, fillPaint);
	}

	public void drawImage(BufferedImage image, int xo, int yo, int ww, int hh,
			Object object) {
		// TODO Auto-generated method stub
		final int imageWidth = image.getWidth();
		final int imageHeight = image.getHeight();
		canvas.save();
		float sx = (float)ww/imageWidth;
		float sy = (float)hh/imageHeight;
		canvas.scale(sx, sy);
		canvas.drawBitmap(image.getBitmap(), xo/sx, yo/sy, null);
		//canvas.drawBitmap(image.getData(), 0, imageWidth, xo / sx, yo / sy, imageWidth, imageHeight, false, picturePaint);
		canvas.restore();
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
