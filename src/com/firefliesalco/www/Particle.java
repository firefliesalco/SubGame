package com.firefliesalco.www;

import com.firefliesalco.www.handler.ParticleHandler;

public class Particle {

	int x,y,xvelocity,yvelocity,life,size,stage = 1;
	ParticleType type;
	GameState state;
	
	public enum ParticleType {
		

		
		WATER("water", 1);
		
		public String texture;
		public int stages;
		
		private ParticleType(String texture, int stages){
			this.texture = texture;
			this.stages = stages;
		}
		
	}
	
	public Particle(int x, int y, int xvelocity, int yvelocity, int xpull, int ypull, int life, int size,ParticleType type, GameState state){
		this.x = x;
		this.y = y;
		this.xvelocity = xvelocity;
		this.yvelocity = yvelocity;
		this.type = type;
		this.life = life;
		this.size = size;
		this.state = state;
	}

	
	public void tick(){
		x += xvelocity;
		y += yvelocity;
		life--;
		if(life == 0){
			ParticleHandler.removeParticle(this);
		}
		if(MainGame.state == state){
			MainGame.graphics.renderImage("images/particles/" + type.texture + "/" + type.texture + stage +".png", x, y, size, size);
		}
		if(stage == type.stages){
			stage = 1;
		}else{
			stage++;
		}
	}
	
}



