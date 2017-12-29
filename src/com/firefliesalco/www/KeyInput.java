package com.firefliesalco.www;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.firefliesalco.www.handler.MasterHandler;

public class KeyInput extends KeyAdapter{

public boolean[] keyClicked = new boolean[255];

public void keyPressed(KeyEvent e) {
	int keys = e.getKeyCode();
  this.keyClicked[keys] = true;

}

public void keyReleased(KeyEvent e) {
	int keys = e.getKeyCode();



	this.keyClicked[keys] = false;

  
}
public void tick() {
	
	if(keyClicked[KeyEvent.VK_ESCAPE]){
		MasterHandler.mainGame.state = GameState.MENU;
	}
	
}
}