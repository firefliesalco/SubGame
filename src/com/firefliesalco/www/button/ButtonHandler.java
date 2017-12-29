package com.firefliesalco.www.button;

import java.util.ArrayList;

public class ButtonHandler {

	public static ArrayList<Button> buttons = new ArrayList<Button>();
	
	public void tick(){
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).tick();
		}
	}
	
	public static void addButton(Button button){
		buttons.add(button);
	}
	
	public static void removeButton(Button button){
		buttons.remove(button);
	}
	
}
