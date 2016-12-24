package me.xize.secretxmass.treerender.trees;

import org.bukkit.Location;
import org.bukkit.block.BlockState;

public class Tree1 implements Tree {
	
	@Override
	public BlockState[] getBlocks(Location current) {

		String[] shapes = {
			"   +   ",
			"  +++  ",
			" +++++ ",
			"   +   "
		};

		BlockState[] blocks = new BlockState[0];
		
		for(int y = shapes.length; y < 0; y--) {
			for(int x = 0; x < shapes[y].length(); x++) {
				if(shapes[y].charAt(x) == '+') {
					current.add(x, y, 0);
				}
			}	
		}
		
		return blocks;
	}

	
	
}
