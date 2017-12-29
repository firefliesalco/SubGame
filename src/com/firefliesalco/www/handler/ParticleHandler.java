package com.firefliesalco.www.handler;

import java.util.ArrayList;

import com.firefliesalco.www.Particle;

public class ParticleHandler {

	public static ArrayList<Particle> particles = new ArrayList<Particle>();
	
	public void tick(){
		for(int i = 0; i < particles.size(); i++){
			
			particles.get(i).tick();
			
		}
	}
	
	public static void createParticle(Particle particle){
		particles.add(particle);
	}
	
	public static void removeParticle(Particle particle){
		particles.remove(particle);
	}
	
}
