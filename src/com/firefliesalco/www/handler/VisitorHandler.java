package com.firefliesalco.www.handler;

import java.util.ArrayList;

import com.firefliesalco.www.GameState;
import com.firefliesalco.www.MainGame;
import com.firefliesalco.www.entities.VisitorEntity;

public class VisitorHandler {

	public static ArrayList<VisitorEntity> visitors = new ArrayList<VisitorEntity>();
	
	public void tick(){
		if(MainGame.state == GameState.DOCK){
			for(int i = 0; i < visitors.size(); i++){
				
				visitors.get(i).tick();
				
			}
		}
	}
	
	public static void createVisitor(VisitorEntity particle){
		visitors.add(particle);
	}
	
	public static void removeVisitor(VisitorEntity particle){
		visitors.remove(particle);
	}
	
}
