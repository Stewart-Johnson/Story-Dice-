/** 
 * The Player class for the Story-Dice game. This class stores all relevant data for
 * each individual player and has the ability to set and get those data as needed during
 * the course of the game.
 * 
 * @author Samuel Friedman, Ryan Gonzalez
 * 
 * @version April 29, 2016
 * 
 */

public class Player {
	
	private char[] story = new char[140];
	private boolean[] flag = new boolean[10];
	private String name;
	private Dice roll;
	private int score;
	private int count;
	
	/** 
	 * The constructor method for the Player class, which initializes all parameters to
	 * their default values.
	 * 
	 * @param none
	 * 
	 */
	
	public Player() {
		
		name = "";
		flag[0] = false;
		story = "".toCharArray();
		roll = new Dice();
		score = 0;
		
	}
	
	/** 
	 * The constructor method for the Player class, which initializes all parameters to
	 * their default values. It takes in a name as well.
	 * 
	 * @param nm The name of the new player.
	 * 
	 */
	
	public Player(String nm) {
		
		name = nm;
		flag[0] = false;
		story = "".toCharArray();
		roll = new Dice();
		score = 0;
		count = 0;
		
	}
	
	/** 
	 * Set the player's name.
	 * 
	 * @param newName The new name to be assigned to the player.
	 * 
	 */
		
	public void setName(String newName) {
		
		name = newName;
		
	}
	
	/** 
	 * Get the name of the player.
	 * 
	 * @param none
	 * 
	 * @return the name of the player
	 *  
	 */
	
	public String getName() {
		
		return name;
		
	}
	
	/** 
	 * Set the story for the player to a specified String. This class uses a char array
	 * for purposes of ensuring that only 140 characters are stored. If the String
	 * given is more than 140 characters, an error is displayed and -1 is returned. 
	 * Otherwise, 0 is returned and the method proceeds naturally.
	 * 
	 * @param newStory the new story for this player
	 * 
	 * @return an integer value, either 0 or -1, that specifies whether or not the 
	 * method succeeded in assigning the given String to the story char array
	 *  
	 */
	
	public int setStory(String newStory) {
		
		if (newStory.length() > 140) {
			System.out.println("Your story excceds the 140 character limit. Please try again!");
			return -1;
		} else {
			story = newStory.toCharArray();
			return 0;
		}
		
	}
	
	/** 
	 * Get the value stored in the story char array.
	 * 
	 * @param none
	 * 
	 * @return the value of the story char array converted to a String for ease of use
	 *  
	 */
	
	public String getStory() {
		
		return String.valueOf(story);
		
	}
	
	/** 
	 * Get the entire String array containing all three images yielded by the player's
	 * roll.
	 * 
	 * @param none
	 * 
	 * @return a string array of the three image file names
	 *  
	 */
	
	public String[] getRoll() {
		
		return roll.getRollImages();
		
	}
	
	/** 
	 * Get the image for a specific die (first, second, or third) and return its
	 * file name.
	 * 
	 * @param index the die to get the file name from
	 * 
	 * @return a string containing the file name of the specified die's image
	 *  
	 */
	
	public String getRoll(int index) {
		
		return roll.getRollImages(index);
		
	}	
	
	/** 
	 * Add a score to the player's current score using the Scoring class.
	 * 
	 * @param newScore The new score to be added to the player's overall score
	 * 
	 */
		
	public void setScore(int newScore) {
		
		score += newScore;
	}
	
	/**
	 * Set the number of rounds and players so we know how many ratings this
	 * player's story will get.
	 * 
	 * @param numRounds The number of rounds for the game.
	 * @param numPlayers The number of players competing in the game.
	 */
	
	public void setCount(int numRounds, int numPlayers)
	{
		count = (numPlayers-1)*(numRounds);
	}
	
	/** 
	 * Get the player's average score.
	 * 
	 * @param none
	 * 
	 * @return a float containing the average score for the player
	 *  
	 */
	
	public double getScore() {
		
		return score/count;
		
	}
}