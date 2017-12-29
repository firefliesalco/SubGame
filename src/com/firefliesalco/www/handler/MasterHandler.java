package com.firefliesalco.www.handler;

import com.firefliesalco.www.MainGame;
import com.firefliesalco.www.button.ButtonHandler;

public class MasterHandler {

	public static MouseHandler mouseHandler = new MouseHandler();
	public static ParticleHandler particleHandler = new ParticleHandler();
	public static SpawnerHandler spawnerHandler = new SpawnerHandler();
	public static GraphicsHandler graphicsHandler;
	public static EventHandler eventHandler = new EventHandler();
	public static ButtonHandler buttonHandler = new ButtonHandler();
	public static VisitorHandler visitors = new VisitorHandler();

	public static MainGame mainGame;
	
	public MasterHandler(MainGame mainGame) {
		MasterHandler.mainGame = mainGame;
	}

	public void start(){
		//MainGame.window.addMouseListener(mouseHandler);
	}
	
	public void tick(){
		graphicsHandler = new GraphicsHandler(MainGame.g);
		particleHandler.tick();
		spawnerHandler.tick();
		mouseHandler.tick();
		buttonHandler.tick();
		visitors.tick();
	}

	
}
