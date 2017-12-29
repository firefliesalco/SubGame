package com.firefliesalco.www.handler;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GraphicsHandler extends JFrame{

	public Graphics g;
	private int gameHeight, gameWidth;
	
	public GraphicsHandler(Graphics2D g){
		this.g = g;
	}
	
	public void renderImage(String location, int x, int y){
		updatePoints();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(location));
		} catch (Exception e){
			
		}
		g.drawImage(img, ((int)( x / 1)), ((int)(y / 1)), this);
	}
	public void renderImage(String location, int x, int y, int width, int height){
		updatePoints();
		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(location));
		} catch (Exception e){
			
		}
		g.drawImage(img, x * gameWidth / 1932, y * gameHeight / 1092, width * gameWidth / 1932, height * gameHeight / 1092, this);
	}
	
	public void renderImage(String location, int x, int y, int width, int height, int red, int green, int blue){
		updatePoints();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(location));
		} catch (Exception e){
			
		}
		BufferedImage imgRecolored = changeRGB(img, red, green, blue);
		g.drawImage(imgRecolored, ((int) (x / 1)), ((int)(y / 1)), ((int)(width / 1)), ((int)(height / 1)), this);
	}
	
    public BufferedImage changeRGB(BufferedImage image, int r, int g, int b) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] += r;
                pixels[1] += g;
                pixels[2] += b;
                pixels[0] = Math.max(pixels[0], 255);
                pixels[1] = Math.max(pixels[1], 255);
                pixels[2] = Math.max(pixels[2], 255);
                pixels[0] = Math.min(pixels[0], 0);
                pixels[1] = Math.min(pixels[1], 0);
                pixels[2] = Math.min(pixels[2], 0);
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
	
    public void updatePoints(){
    	gameWidth = MasterHandler.mainGame.WIDTH;
    	gameHeight = MasterHandler.mainGame.HEIGHT;
    }
    
}
