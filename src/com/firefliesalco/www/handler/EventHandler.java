package com.firefliesalco.www.handler;

public class EventHandler {

	
	public static boolean isInside(int x, int y, int width, int height){
		if(MasterHandler.mouseHandler.isInside(x, y, width, height)){
			return true;
		}
		return false;
	}
	
}
