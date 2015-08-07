package cooperjd.simon;

import java.awt.Color;
import java.util.*;

/**
 * 
 * @author cooperjd
 * Class that holds and manipulates all of the colors
 *
 */
public class ColorManager {

	/**
	 * The palette that holds all of the colors
	 */
    public ArrayList<Color> colors;
    private ArrayList<Color> highlights;
	
    /**
     * This constructor creates a new color palette with colors
     */
	public ColorManager(){
		colors = new ArrayList<Color>();
		highlights = new ArrayList<Color>();
		
		colors.add(new Color(204,0,0));		//Red
		colors.add(new Color(0, 102, 0)); 	//Green
		colors.add(new Color(0, 0, 102)); 	//Blue
		colors.add(new Color(255, 128, 0)); //Orange
		colors.add(new Color(204, 0, 102));	//Pink
		colors.add(new Color(204, 204, 0));	//Yellow
		colors.add(new Color(102, 0, 102));	//Purple
		colors.add(new Color(51, 204, 204));//Light Blue
		
		highlights.add(new Color(255,0,0));		//Red
		highlights.add(new Color(0, 153, 0)); 	//Green
		highlights.add(new Color(0, 0, 153)); 	//Blue
		highlights.add(new Color(255, 179, 0)); //Orange
		highlights.add(new Color(255, 0, 153));	//Pink
		highlights.add(new Color(255, 255, 0));	//Yellow
		highlights.add(new Color(153, 0, 153));	//Purple
		highlights.add(new Color(102, 255, 255));//Light Blue
	}
	
	/**
	 * Gets a color from the palette
	 * @param index The index of the color in the palette to return
	 * @return The color that was retrieved from the palette 
	 */
	public Color getColor(int index){
		return colors.get(index);
	}
	
	public Color getHighlight(int index){
		return highlights.get(index);
	}
	
	/**
	 * This removes a color from the color palette
	 * @param index This is the index of the color that will be removed from the palette
	 */
	public void removeColor(int index){
		colors.remove(index);
	}
	
	/**
	 * This resets the palette with all the original colors
	 */
	public void ResetPalette(){
		for(Color c : colors)
			colors.remove(c);
		
		colors.add(new Color(204,0,0));		//Red
		colors.add(new Color(0, 102, 0)); 	//Green
		colors.add(new Color(0, 0, 102)); 	//Blue
		colors.add(new Color(255, 128, 0)); //Orange
		colors.add(new Color(204, 0, 102));	//Pink
		colors.add(new Color(255, 255, 0));	//Yellow
		colors.add(new Color(102, 0, 102));	//Purple
		colors.add(new Color(51, 255, 255));//Light Blue
	}
	
	/**
	 * Gets how many colors are left in the palette
	 * @return how many colors are left in the array
	 */
	public int size(){
		return colors.size();
	}
}
