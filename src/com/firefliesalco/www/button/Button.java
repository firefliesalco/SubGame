package com.firefliesalco.www.button;

import com.firefliesalco.www.GameState;
import com.firefliesalco.www.MainGame;

public class Button {

	public int x,y,width,height;
	public String location;
	public GameState state;
	
	public Button(int x, int y, int width, int height, String location, GameState state){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.location = location;
		this.state = state;
	}
	
	public void onClick(){}
	
	public void onHover(){}
	
	public void tick(){
		if(MainGame.state == state){
			MainGame.graphics.renderImage(location, x, y, width, height);
		}
	}

	public void notHover() {}
	
}
