package com.firefliesalco.www.entities;

import java.util.Random;

import com.firefliesalco.www.handler.MasterHandler;

public class VisitorEntity extends Entity{

	public int maxY = 0;
	public boolean facingLeft = true;
	public int xMov,yMov;
	public int xOff,yOff;
	
	public VisitorEntity(String enterance) {
		super((enterance.equals("right")) ? 1920 : 0, (enterance.equals("right")) ? 400 : 700);
		Random r = new Random();
		xOff = r.nextInt(60)-30;
		yOff = r.nextInt(60)-30;
		
	}
	
	public void tick(){
		
		if(720 > x && x < 810){
			maxY = 210;
		}else{
			maxY = 375;
		}
		
		if(xMov > 0){
			MasterHandler.graphicsHandler.renderImage("images/entity/visitors/normal.png", x + xOff, y + yOff, 100, 100);
		}else{
			System.out.println();
			MasterHandler.graphicsHandler.renderImage("images/entity/visitors/normal.png", 100 + x + xOff, y + yOff, -100,100);
			int age;
		}
	}

}
