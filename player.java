package com.main.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.main.engine.GameLoop;

public class Player implements KeyListener{

	double x,y;
	int width;
	int height;
	
	static boolean right,left,up,down;
	
	public Player(int width,int height) {
		this.width = width;
		this.height = height;
		x = 1280 / 2 - width / 2;
		y = 720 / 2 - height / 2;
	}
	
	
	public Player() {}


	public void tick(){
		
		int iX = (int)x;
		int iY = (int)y;
		
		for(Block b : GameLoop.blocks){
			//RIGHT
			if(b.isSolid()){
				if(Collision.PlayerCBlock(new Point(iX + width + (int) GameLoop.xOffset + 2, iY + (int) GameLoop.yOffset + 2), b)
				|| Collision.PlayerCBlock(new Point(iX + width +(int) GameLoop.xOffset + 2, iY +height + (int)GameLoop.yOffset - 1), b)){
					right = false;	
				}
				
				//LEFT
				if(Collision.PlayerCBlock(new Point(iX + (int) GameLoop.xOffset - 4, iY +(int) GameLoop.yOffset + 2), b)
				|| Collision.PlayerCBlock(new Point(iX + (int) GameLoop.xOffset - 1, iY +height + (int)GameLoop.yOffset - 1), b)){
					left = false;	
				}
				
				if(Collision.PlayerCBlock(new Point(iX + (int)GameLoop.xOffset + 1, iY + (int)GameLoop.yOffset - 4), b)
				|| Collision.PlayerCBlock(new Point(iX + width + (int)GameLoop.xOffset - 1, iY + (int)GameLoop.yOffset - 4), b)) {
					up = false;
				}
				
				if(Collision.PlayerCBlock(new Point(iX + (int)GameLoop.xOffset + 2, iY + height + (int)GameLoop.yOffset + 1), b)
				|| Collision.PlayerCBlock(new Point(iX + width + (int)GameLoop.xOffset - 1,  iY + height + (int)GameLoop.yOffset + 1), b)) {
					y = b.getY() - (int)GameLoop.yOffset - height;
					down = false;
				}
			}
		}
		
		if(right){
			GameLoop.xOffset+=4;
		}
		if(left){
			GameLoop.xOffset-=4;
		}
		if(up){
			GameLoop.yOffset-=4;
		}
		if(down){
			GameLoop.yOffset+=4;
		}
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, width, height);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			left = true;
		}
		System.out.println("asd");
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			left = false;
		}
	}


	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
