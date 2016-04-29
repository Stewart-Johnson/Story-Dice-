import java.util.*;
public class Dice 
{
	private String[] Roll;
	private String[] dice1t = {"dog", "flower", "hot air balloon", "airplane" , "worry", "sheep"};
	private String[] dice2t = {"pyramids", "think", "house", "clock", "bee", "books"};
	private String[] dice3t = {"fish", "magic", "bugs", "lock", "fire", "question"};
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
	
	public Dice(boolean gooey)
	{
		Roll = new String[3];
		Random r = new Random();
		if(gooey == false){
			Roll[0] = dice1t[r.nextInt(6)];
			Roll[1] = dice2t[r.nextInt(6)];
			Roll[2] = dice3t[r.nextInt(6)];
		}else{
			Roll[0] = dice1g[r.nextInt(6)];
			Roll[1] = dice2g[r.nextInt(6)];
			Roll[2] = dice3g[r.nextInt(6)];
		}
		
	}
	/**
	 * This simple getter method returns the roll
	 * @return returns the string array of the roll results for use by other classes
	 */
	public String[] getRoll(){
		return Roll;
	}
	
	public String getRoll(int index)
	{
		return Roll[index];
	}
	
	
}