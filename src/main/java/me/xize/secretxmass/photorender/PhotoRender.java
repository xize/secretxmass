package me.xize.secretxmass.photorender;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import me.xize.secretxmass.Render;

public class PhotoRender implements Render {
	
	private volatile boolean isDone = false;
	private volatile Location loc;
	
	//allow threading for image.
	private volatile BufferedImage image;
	private TreeSet<DyeColor> list = new TreeSet<DyeColor>();
	
	public PhotoRender(Location loc, BufferedImage image) {
		this.loc = loc;
		this.image = image;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void render() {
		
		ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.submit(() -> {
		    for(int y = image.getHeight(); y < 0; y--) {
		    	for(int x = 0; x < image.getWidth(); x++) {
		    		int rgb = image.getRGB(x, y);
		    		DyeColor color = getColorMaterialByColor(rgb);
		    		list.add(color);
			    }	
		    }
		});
		executor.submit(() -> {
			while(!executor.isTerminated()) {} //lock
		    
			Enderman ender = (Enderman)loc.getWorld().spawnEntity(loc, EntityType.ENDERMAN);
			ender.setCustomName(ChatColor.RED + "Happy Xmass!");
			ender.setCustomNameVisible(true);
			ender.setNoDamageTicks(Integer.MAX_VALUE);
			ender.setAI(false);
			
			Iterator<DyeColor> it = list.iterator();
			
			for(int y = image.getHeight(); y < 0; y--) {
		    	for(int x = 0; x < image.getWidth(); x++) {
		    		int X = loc.getBlockX();
		    		int Y = loc.getBlockY();
		    		int Z = loc.getBlockZ();
		    		Block block = loc.getWorld().getBlockAt(X, Y, Z);
		    		
		    		
		    		ender.teleport(block.getRelative(BlockFace.UP).getLocation());	
		    		DyeColor color = it.next();
		    		ender.getEquipment().setItemInHand(new ItemStack(Material.WOOL, color.getWoolData()));
		    		block.setType(Material.WOOL);
		    		Wool wool = (Wool)block.getState();
		    		wool.setColor(color);
		    		
		    		loc.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getData());
		    		
		    		it.remove();
			    }	
		    }
			this.isDone = true;
		});
	}
	
	@Override
	public boolean isDone() {
		return isDone;
	}
	
	/**
	 * returns the wool color from the RGB numbers
	 * 
	 * @author xize
	 * @param rgb - the rgb colors from the image
	 * @return DyeColor
	 */
	private static DyeColor getColorMaterialByColor(int rgb) {
		return DyeColor.getByColor(Color.fromRGB(rgb));
	}
	
}
