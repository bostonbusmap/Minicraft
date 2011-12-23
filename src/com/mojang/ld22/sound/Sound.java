package com.mojang.ld22.sound;

import com.mojang.ld22.R;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
	public static Sound playerHurt;
	public static Sound playerDeath;
	public static Sound monsterHurt;
	public static Sound test;
	public static Sound pickup;
	public static Sound bossdeath;
	public static Sound craft;

	public static void initSounds(Context context)
	{
		playerHurt = new Sound(context, R.raw.playerhurt);
		playerDeath = new Sound(context, R.raw.death);
		monsterHurt = new Sound(context, R.raw.monsterhurt);
		test = new Sound(context, R.raw.test);
		pickup = new Sound(context, R.raw.pickup);
		bossdeath = new Sound(context, R.raw.bossdeath);
		craft = new Sound(context, R.raw.craft);
	}
	
	private MediaPlayer clip;

	private Sound(Context context, int resource) {
		clip = MediaPlayer.create(context, resource);
	}

	public void play() {
		clip.start();
	}
}