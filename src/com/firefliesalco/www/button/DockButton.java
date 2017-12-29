package com.firefliesalco.www.button;

import com.firefliesalco.www.GameState;
import com.firefliesalco.www.MainGame;

public class DockButton extends Button{

	public DockButton(int x, int y, int width, int height, String location, GameState state) {
		super(x, y, width, height, location, state);
	}
	
	@Override
	public void onClick(){
		MainGame.state = GameState.DOCK;
	}
	
	@Override
	public void onHover(){
		location = "images/DockHover.png";
	}
	
	@Override
	public void notHover(){
		location = "images/Dock.png";
	}

}
