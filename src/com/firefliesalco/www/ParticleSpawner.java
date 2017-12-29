package com.firefliesalco.www;

import java.util.Random;

import com.firefliesalco.www.handler.ParticleHandler;

public class ParticleSpawner {

	public int interval;
	public Particle particle;
	public int currentTick = 0;
	public Random random = new Random();
	public int xOff,yOff;
	
	
	public ParticleSpawner(Particle particle, int interval, int xOff, int yOff){
		this.particle = particle;
		this.interval = interval;
		this.xOff = xOff;
		this.yOff = yOff;
	}
	
	public void tick(){
		if(currentTick == interval){
			currentTick = 0;
			ParticleHandler.createParticle(new Particle(particle.x + random.nextInt(xOff * 2) - xOff, particle.y + random.nextInt(yOff * 2) - yOff, particle.xvelocity, particle.yvelocity, 0, 0, particle.life, particle.size, particle.type, GameState.DOCK));
		}else{
			currentTick++;
		}
	}
	
}
