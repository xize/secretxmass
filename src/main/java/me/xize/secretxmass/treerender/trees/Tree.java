package me.xize.secretxmass.treerender.trees;

import org.bukkit.Location;
import org.bukkit.block.BlockState;

public interface Tree {
	
	public BlockState[] getBlocks(Location loc);

}
