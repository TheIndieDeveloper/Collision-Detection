package com.main.Entity;

import java.awt.Point;

public class Collision {

	public static boolean PlayerCBlock(Point p, Block b){
		return b.contains(p);
	}
	
}
