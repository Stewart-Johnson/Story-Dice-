
import java.util.*;

/** 
 * The Dice class for the Story-Dice game. This class takes String arrays with dice and their corresponding symbols
 * and randomly rolls them and passes them as Rolls to the Player class to be printed/shown in the main
 * 
 * @author Ryan Gonzales Stewart Johnson
 * 
 * @version April 29, 2016
 * 
 */

public class Dice 
{
	// initialize the RollImages and RollWords String array
	private String[] RollImages;
	private String[] RollWords;
	
	//initialize the 3 dice word arrays
	private String[] dice1t = {"dog", "flower", "hot air balloon", "airplane" , "sheep", "pyramid"};
	private String[] dice2t = {"think", "house", "clock", "bee", "book", "fish"};
	private String[] dice3t = {"bug", "lock", "fire", "question", "compass", "key"};
	
	//initialize the three dice picture file location arrays
	private String[] dice1g = {"src/img/d1image1.jpg","src/img/d1image2.jpg","src/img/d1image3.jpg","src/img/d1image4.jpg","src/img/d1image5.jpg","src/img/d1image6.jpg"};
	private String[] dice2g = {"src/img/d2image1.jpg","src/img/d2image2.jpg","src/img/d2image3.jpg","src/img/d2image4.jpg","src/img/d2image5.jpg","src/img/d2image6.jpg"};
	private String[] dice3g = {"src/img/d3image1.jpg","src/img/d3image2.jpg","src/img/d3image3.jpg","src/img/d3image4.jpg","src/img/d3image5.jpg","src/img/d3image6.jpg"};
	/**
	 *constructor that creates 3 random rolls and then creates the two string arrays for Images and Words
	 */
	
	public Dice()
	{
		//initialize images and words to size 3
		RollImages = new String[3];
		RollWords = new String[3];
		
		//create the random object to call random
		Random dicer = new Random();
		
		//create 3 random rolls to use in the arrays
		int rand1 = dicer.nextInt(6);
		int rand2 = dicer.nextInt(6);
		int rand3 = dicer.nextInt(6);
		
		//put the randomly rolled numbers from the image file array to the RollImages array
		RollImages[0] = dice1g[rand1];
		RollImages[1] = dice2g[rand2];
		RollImages[2] = dice3g[rand3];
		
		//put the randomly rolled numbers from the image file array to the RollWords array
		RollWords[0] = dice1t[rand1];
		RollWords[1] = dice2t[rand2];
		RollWords[2] = dice3t[rand3];
		
	}
	/**
	 * This simple getter method returns the roll
	 * @return returns the string array of the roll Images file locations
	 */
	public String[] getRollImages()
	{
		return RollImages;
	}
	
	/**
	 * This simple getter method returns the roll
	 * @return returns the string array of the roll Images file locations
	 */
	public String[] getRollWords()
	{
		return RollWords;
	}
	
	/**
	 * This simple getter method returns the roll
	 * @return returns the string array of the roll Images file locations
	 * @parameter index to get the index for the images
	 */
	public String getRollImages(int index)
	{
		return RollImages[index];
	}
}
