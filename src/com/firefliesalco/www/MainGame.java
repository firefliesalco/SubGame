package com.firefliesalco.www;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.firefliesalco.www.Particle.ParticleType;
import com.firefliesalco.www.button.ButtonHandler;
import com.firefliesalco.www.button.DockButton;
import com.firefliesalco.www.entities.VisitorEntity;
import com.firefliesalco.www.handler.GraphicsHandler;
import com.firefliesalco.www.handler.MasterHandler;
import com.firefliesalco.www.handler.MouseHandler;
import com.firefliesalco.www.handler.SpawnerHandler;
import com.firefliesalco.www.handler.VisitorHandler;


public class MainGame extends Canvas implements Runnable{

	private static final long serialVersionUID = -4675090720139589751L;
	public int WIDTH = 1000, HEIGHT = 700;
	private Thread thread;
	private KeyInput keys;
	public static GraphicsHandler graphics;
	public int waterTick = 0;
	public Random r = new Random();
	public int waterStage = 0;
	public int yOffset = 0;
	public int velocity = 0;
	public int tickNumber = 0;
	public Window window;
	public JFrame frame;
	public int titleTick = 0;
	public static Graphics2D g;
	public MasterHandler handler = new MasterHandler(this);
	public static GameState state = GameState.MENU;
	public static Point mousePos = new Point(0,0);
	
	public int bobTick = 0;
	public int bobAmount = 0;
	
	
	private boolean running = true;
	public MainGame(){
		window = new Window((int) WIDTH, (int) HEIGHT, this);
		frame = window.frame;
		keys = new KeyInput();
		this.addKeyListener(keys);
		this.addMouseListener(MasterHandler.mouseHandler);
		tick();
		render();
		postStartup();
}


	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;


	}
	public synchronized void stop(){
	try{
		thread.join();
		running = false;
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	private void render(){
		WIDTH = frame.getWidth();
		HEIGHT = frame.getHeight();
		SwingUtilities.convertPointFromScreen(MouseHandler.mouseLocation, window);
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		if(waterTick == 10){
			waterTick = 0;
			waterStage = r.nextInt(3);
		}else{
			waterTick++;
		}
		if(titleTick >= 500){
			window.randomizeText();
			titleTick = 0;
		}else{
			titleTick++;
		}
		
		bobTick++;
		if(bobTick > 3){
			bobAmount++;
			bobTick = 0;
		}
		
		yOffset = (int)((Math.sin(Math.toRadians(bobAmount*10)))*10);

		graphics = new GraphicsHandler(g);
		if(state == GameState.DOCK){
			graphics.renderImage("images/Pier" + waterStage + ".png", 0, 0, 1936, 1056);
			graphics.renderImage("images/woodSubmarine.png", 340, 230 + yOffset, 750, 400);
			graphics.renderImage("images/WaterCover.png",410, 450, 650, 80);
		}
		if(state == GameState.MENU){
			graphics.renderImage("images/Menu.png", 0, 0, 1936, 1056);
			graphics.renderImage("images/TitleText.png", 0, 0, 1536, 1056);
		}
		handler.tick();
		g.dispose();
		bs.show();

		
		
	}
	private void tick(){
		Random r = new Random();
		if(r.nextInt(20)==0){
			VisitorHandler.visitors.add(new VisitorEntity((r.nextInt(1)==0)?"Right":"Left"));
		}
		
		
		keys.tick();

	}

	public void run(){
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 30.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 10){
				tick();
				render();
				delta--;
			}

			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1500;
				}

			}
		}
	public static void main(String args[]){	
		
		new MainGame();

	}
	
	
	public void postStartup(){
		SpawnerHandler.createParticle(new ParticleSpawner(new Particle(1900, 900, -2, 0, 0, 0, 1050, 120, ParticleType.WATER, GameState.DOCK), 20, 4, 10));
		SpawnerHandler.createParticle(new ParticleSpawner(new Particle(1000, 410, -2, 0, 0, 0, 350, 120, ParticleType.WATER, GameState.DOCK), 20, 4, 10));
		handler.start();
		ButtonHandler.addButton(new DockButton(30,820,300,200, "images/Dock.png", GameState.MENU));
		
		
		
	}
	
	public void preStartup(){
		
	}
	
}
