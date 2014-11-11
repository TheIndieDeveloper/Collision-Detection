package com.main.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.main.engine.GameLoop;

public class Block extends Rectangle{

	int BlockSize = 32;
	boolean solid;
	
	public Block(int x, int y, boolean isSolid) {
		solid = isSolid;
		setBounds(x, y, BlockSize, BlockSize);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics2D g){
		
		if(solid){
			g.setColor(Color.RED);
		}else{
			g.setColor(Color.GREEN);
		}
		g.fillRect(x - (int) GameLoop.xOffset, y - (int)GameLoop.yOffset, BlockSize, BlockSize);
		
	}

	public boolean isSolid() {
		return solid;
	}

}
