import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

/** 
 * The mainDice Class provides the main method for our program and is what should be run
 * to initialize and play the game.
 * 
 * @author Samuel Friedman, Ryan Gonzalez, Stewart Johnson
 * 
 * @version April 29, 2016
 * 
 */

public class mainDice
{
	
	static int count = 1;
	static int numRounds = 1;
	
	/**
	 * Main Method runs through the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// Introduction to the game.
		
		System.out.println("Welcome to Story Dice!");
		System.out.println("You need at least two people in order to play this game!");
		System.out.println("Write a story based on the 3 pictures you roll and then rate your friends stories!");
		System.out.println("The person with the highest average score at the end wins and gets a place in the Hall of Winners!");
		
		// Show previous winners by reading from winners.txt if it exists.
		
		System.out.println("Hall of Winners:");
		System.out.println();
		
        String fileName = "src/winners.txt";

        String line = null;

        try {
        	
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            bufferedReader.close();
            System.out.println();
        }
        catch(FileNotFoundException ex) {
        	// Avoid any error messages if the file doesn't exist yet.
        }
        catch(IOException ex) {                
            ex.printStackTrace();
        }
        
		// Get number of players from console.
        
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of players");
		int numPlayers = sc.nextInt();
		
		// Create a player object array to story the players.
		
		Player [] player = new Player[numPlayers];
		
		// Instantiate player array with new players. 
		
		for(int index = 0;index <= player.length-1;index++)
		{
			player[index] = new Player();
		}
		
		// Get the names of the players.
		
		for(int index = 0;index <= player.length-1;index ++)
		{	
			
			System.out.println("Please enter Player " + count + "'s name");
			String name = sc.next();
			player[index].setName(name);
			count++;
		}		
		
		// Start the game.
		
		playGame(player, numPlayers, numRounds);
		
	}
	
	/**
	 * Once all information has been gathered from the players, begin playing the game. This
	 * class involves showing and retrieving stories, playing new rounds, and saving to the
	 * hall of winners.
	 * 
	 * @param player Array of players for the game
	 * @param numPlayers The number of players
	 * @param numRounds The number of rounds; this is incremented when the group wants to play another round
	 */
	
	public static void playGame(Player[] player, int numPlayers, int numRounds)
	{
		
		// Create Scanner and Dice array objects.
		
		Scanner scannedStory=new Scanner(System.in);
		Dice[] storyPics = new Dice[numPlayers];
		
		// Show and retrieve the stories for each player.
		
		for (int index = 0;index <= player.length-1;index ++) {
			
			System.out.println(player[index].getName() + "'s turn");
			storyPics[index] = new Dice();
			JFrame window = new JFrame("Your Dice Roll");
			GridLayout pictureGrid  = new GridLayout(0,3);
			window.setSize(900, 300);
			window.setLayout(pictureGrid);
	        window.add(new drawsImage(storyPics[index].getRollImages(0)));
	        window.add(new drawsImage(storyPics[index].getRollImages(1)));
	        window.add(new drawsImage(storyPics[index].getRollImages(2)));
	        window.setLocationRelativeTo(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true); 
	        System.out.println(Arrays.toString(storyPics[index].getRollWords()));
			System.out.println("What's the Story? \n");
			String story = scannedStory.nextLine();
			player[index].setStory(story);
			window.setVisible(false);
			
		}
		
		// Loop through each player and allow them to rate all the other stories.
		
		for(int index = 0; index < numPlayers; index++) {
			
			for(int rate = 0; rate < numPlayers; rate++) {
				
				if(index == rate) {
					
					System.out.println("\n");
				
				} else {
					
					System.out.println(player[index].getName()+" Please rate these stories ");	
					JFrame window = new JFrame("Your Dice Roll");
					GridLayout pictureGrid  = new GridLayout(0,3);
					window.setSize(900, 300);
					window.setLayout(pictureGrid);
			        window.add(new drawsImage(storyPics[rate].getRollImages(0)));
			        window.add(new drawsImage(storyPics[rate].getRollImages(1)));
			        window.add(new drawsImage(storyPics[rate].getRollImages(2)));
			        window.setLocationRelativeTo(null);
			        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        window.setVisible(true); 
			        System.out.println(Arrays.toString(storyPics[index].getRollWords()));
					System.out.println(player[rate].getStory());
					System.out.println("1 - 5 how would you rate this story");
					int score = scannedStory.nextInt();
					player[rate].setScore(score);
					window.setVisible(false); 
				}
			}
		}
		
		// Display all scores to the users.
		
		for (int index = 0; index < numPlayers; index++) {
			
			player[index].setCount(numRounds, numPlayers);
			System.out.println(player[index].getName() + "'s Score is: " + Double.toString(player[index].getScore()));
		
		}
		
		// Ask to player another round.
		
		System.out.println("Play another round? Y/N ");
		String nextRound = scannedStory.next();
		
		if(nextRound.equals("Y")) {
			
			// Increment number of rounds and replay.
			
			numRounds++;
			System.out.println("Let's play again!");
			playGame(player, numPlayers, numRounds);
			
		} else {
			
			// Display final scores for all rounds.
			
			System.out.println("Final Score is: ");
			int max = 0;
			for(int index = 0; index < numPlayers; index++) {
				if (player[index].getScore() > max) {
					max = index;
				}
				player[index].setCount(numRounds, numPlayers);
				System.out.println(player[index].getName() + "'s Score is: " + Double.toString(player[index].getScore()));
			}
						
			
			// Install the victor into the immortalized hall of winners.
			
	        String fileName = "src/winners.txt";

	        try {
	        	
	            FileWriter fileWriter =
	                new FileWriter(fileName, true);

	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);

	            bufferedWriter.write(player[max].getName() + ": " + player[max].getScore());
	            bufferedWriter.newLine();

	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
			
			return;
		}	
	}
}