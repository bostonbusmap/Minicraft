package com.mojang.ld22.gfx;

import java.io.InputStream;

import fakejava.awt.image.BufferedImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SpriteSheet {
	public int width, height;
	public int[] pixels;

	public SpriteSheet(InputStream stream) {
		Bitmap image = BitmapFactory.decodeStream(stream);
		width = image.getWidth();
		height = image.getHeight();
		image.getPixels(pixels, 0, width, 0, 0, width, height);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = (pixels[i] & 0xff) / 64;
		}
	}
}