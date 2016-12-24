package me.xize.secretxmass.treerender;

import org.bukkit.Location;

import me.xize.secretxmass.Render;

public class TreeRender implements Render {

	private final Location loc;
	
	public TreeRender(Location loc) {
		this.loc = loc;
	}
	
	@Override
	public void render() {
		
	}

	@Override
	public boolean isDone() {
		return false;
	}
	
}
