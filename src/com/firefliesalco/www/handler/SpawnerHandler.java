package com.firefliesalco.www.handler;

import java.util.ArrayList;

import com.firefliesalco.www.ParticleSpawner;

public class SpawnerHandler {
	public static ArrayList<ParticleSpawner> spawners = new ArrayList<ParticleSpawner>();
	
	public void tick(){
		for(int i = 0; i < spawners.size(); i++){
			
			spawners.get(i).tick();
			
		}
	}
	
	public static void createParticle(ParticleSpawner spawner){
		spawners.add(spawner);
	}
	
	public static void removeParticle(ParticleSpawner spawner){
		spawners.remove(spawner);
	}
	
}
