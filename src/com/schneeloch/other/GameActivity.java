package com.schneeloch.other;


import com.mojang.ld22.Game;
import com.mojang.ld22.InputHandler;
import com.mojang.ld22.R;

import fakejava.awt.BorderLayout;
import fakejava.awt.Dimension;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Adapted from lunar lander example
 * @author schneg
 *
 */
public class GameActivity extends Activity  {
	private GameView gameView;
	private GameThread gameThread;
	private Button up;
	private Button down;
	private Button left;
	private Button right;
	private Button attack;
	private Button menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		
		gameView = (GameView)findViewById(R.id.surface);
		gameThread = gameView.getThread();
		
		if (savedInstanceState == null)
		{
			gameThread.setState(GameThread.STATE_READY);
			
		}
		else
		{
			gameThread.restoreState(savedInstanceState);
		}
		
		up = (Button)findViewById(R.id.buttonUp);
		down = (Button)findViewById(R.id.buttonDown);
		left = (Button)findViewById(R.id.buttonLeft);
		right = (Button)findViewById(R.id.buttonRight);
		attack = (Button)findViewById(R.id.buttonAttack);
		menu = (Button)findViewById(R.id.buttonMenu);
		
		setUpButtonListeners(up, InputHandler.UP);
		setUpButtonListeners(down, InputHandler.DOWN);
		setUpButtonListeners(left, InputHandler.LEFT);
		setUpButtonListeners(right, InputHandler.RIGHT);
		setUpButtonListeners(attack, InputHandler.ATTACK);
		setUpButtonListeners(menu, InputHandler.MENU);
	}
	
	private void setUpButtonListeners(Button button, final int code) {
		button.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_DOWN)
				{
					doPress(code, event.getAction() == MotionEvent.ACTION_DOWN);
				}
				return false;
			}
		});
	}

	private void doPress(int code, boolean isDown)
	{
		Log.i("Minicraft", "keyevent " + code + " is " + isDown);
		gameThread.getInputHandler().keyEvent(code, isDown);		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		gameView.getThread().pause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
		gameThread.saveState(outState);
		
	}

}
