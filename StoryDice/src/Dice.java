import java.util.*;
public class Dice 
{
	private String[] RollImages;
	private String[] RollWords;
	private String[] dice1t = {"dog", "flower", "hot air balloon", "airplane" , "sheep", "pyramid"};
	private String[] dice2t = {"think", "house", "clock", "bee", "book", "fish"};
	private String[] dice3t = {"bug", "lock", "fire", "question", "compass", "key"};
	private String[] dice1g = {"src/d1image1.jpg","src/d1image2.jpg","src/d1image3.jpg","src/d1image4.jpg","src/d1image5.jpg","src/d1image6.jpg"};
	private String[] dice2g = {"src/d2image1.jpg","src/d2image2.jpg","src/d2image3.jpg","src/d2image4.jpg","src/d2image5.jpg","src/d2image6.jpg"};
	private String[] dice3g = {"src/d3image1.jpg","src/d3image2.jpg","src/d3image3.jpg","src/d3image4.jpg","src/d3image5.jpg","src/d3image6.jpg"};
	/**
	 *constructor that creates a dice object that has a string array
	 *that either contains words depicting images for the text based
	 *version of the game or the filenames of the images for the gui
	 *version of the game.
	 *@param gooey is a boolean that tells the game to either initialize a text based or gui based roll
	 */
	
	public Dice()
	{
		RollImages = new String[3];
		RollWords = new String[3];
		Random r = new Random();
		int rand1 = r.nextInt(6);
		int rand2 = r.nextInt(6);
		int rand3 = r.nextInt(6);
		RollImages[0] = dice1g[rand1];
		RollImages[1] = dice1g[rand2];
		RollImages[2] = dice1g[rand3];
		RollWords[0] = dice1t[rand1];
		RollWords[1] = dice1t[rand2];
		RollWords[2] = dice1t[rand3];
		
	}
	/**
	 * This simple getter method returns the roll
	 * @return returns the string array of the roll results for use by other classes
	 */
	public String[] getRollImages(){
		return RollImages;
	}
	
	public String[] getRollWords()
	{
		return RollWords;
	}
	
	public String getRollImages(int index)
	{
		return RollImages[index];
	}
	
	
}
