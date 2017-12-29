package com.firefliesalco.www;

import java.awt.Canvas;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;

public class Window extends Canvas{
	private static final long serialVersionUID = 6894091588122552427L;

		public JFrame frame;
		public Random r = new Random();
		public String[] possibleText = {
				"Destroy your enemies!",
				"Launch Missiles!",
				"Nuclear Powered!",
				"Upgrade your sub!",
				"Wood subs just make sense.",
				"Find VIP's!",
				"Fill your battle flag!",
				"Collect Weapons!",
				"Grab all the skins!",
				"Hide under the waves!",
				"Enjoy mediocre pixel art!"
				
		};
	
	public Window(int width, int height, MainGame game){
		frame = new JFrame("My Little Sub");
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width - 30, height - 100));
		frame.setResizable(true);
		frame.setLocation(0,0);
		frame.add(game);
		frame.setVisible(true);
		frame.isShowing();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomizeText();
		game.start();
	}
	
	public void randomizeText(){
		frame.setTitle("My Little Sub - " + possibleText[r.nextInt(possibleText.length)]);
	}
}
