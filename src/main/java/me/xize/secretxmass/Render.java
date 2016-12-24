package me.xize.secretxmass;

public interface Render {

	/**
	 * builds/renders a structure
	 * 
	 * @author xize
	 */
	public void render();
	
	/**
	 * returns true if the async thread is done
	 * 
	 * @author xize
	 * @return boolean
	 */
	public boolean isDone();
	
}
