package com.firefliesalco.www.handler;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import com.firefliesalco.www.MainGame;
import com.firefliesalco.www.button.Button;
import com.firefliesalco.www.button.ButtonHandler;

public class MouseHandler extends MouseAdapter{

	public static Point mouseLocation = new Point(0, 0);
	
	public void tick(){
			MainGame.graphics.g.drawString(MouseInfo.getPointerInfo().getLocation().toString(), 300, 500);
			checkButtonHover();
	}
	
	public boolean isInside(int x, int y, int width, int height){

		mouseLocation = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(mouseLocation, MasterHandler.mainGame.frame);
		MainGame.graphics.g.drawString(mouseLocation.toString(), 500, 500);
		if(mouseLocation.x >= x * MasterHandler.mainGame.WIDTH / 1936 && mouseLocation.x <= (x + width) * MasterHandler.mainGame.WIDTH / 1936 && mouseLocation.y >= y * MasterHandler.mainGame.HEIGHT / 1056 && mouseLocation.y <= (y + height) * MasterHandler.mainGame.HEIGHT / 1056){
			return true;
		}
		return false;
	}
	
	public void mousePressed(MouseEvent e){
		checkButtons();
	}

	private void checkButtons() {
		for(int i = 0; i < ButtonHandler.buttons.size(); i++){
			Button button = ButtonHandler.buttons.get(i);
			if(isInside(button.x, button.y, button.width, button.height)){
				button.onClick();
			}
		}
	}
	
	private void checkButtonHover() {
		for(int i = 0; i < ButtonHandler.buttons.size(); i++){
			Button button = ButtonHandler.buttons.get(i);
			if(isInside(button.x, button.y, button.width, button.height)){
				button.onHover();
			}else{
				button.notHover();
			}
		}
	}
	
}
