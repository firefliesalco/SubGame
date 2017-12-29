package com.firefliesalco.www.entities;

import com.firefliesalco.www.MainGame;

public class SubmarineEntity extends Entity {
	
	public int propellerTier = 1;
	public int hullTier = 1;
	public int torpedoTier = 1;
	public int missileTier = 1;

	public SubmarineEntity(int x, int y) {
		super(x, y);
	}
	

	@Override
	public void tick(){
		MainGame.graphics.renderImage("images/submarine/player/hull.png", x, y);
	}
	
	public int getYOff(int tick){
		if(tick < 2 ||(tick > 24 && tick < 26)){
			return 0;
		}
		else if(tick <= 16){
			return -1;
		}else if(tick >= 30){
			return 1;
		}
		return 0;
	}

}
