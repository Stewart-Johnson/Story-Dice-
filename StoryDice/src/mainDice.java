
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class mainDice
{
	
	static int count = 1;
	static int numRounds = 1;
	public static void main(String[] args)
	{
		//get number of players from console
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of players");
		int numPlayers = sc.nextInt();
		//create new player array
		Player [] player = new Player[numPlayers];
		//instantiate player array
		for(int index = 0;index <= player.length-1;index++)
		{
			player[index] = new Player();
		}
		
		//get player names
		
		for(int index = 0;index <= player.length-1;index ++)
		{	
			
			System.out.println("Please enter Player " + count + "'s name");
			String name = sc.next();
			player[index].setName(name);
			count++;
		}
		
		
		playGame(player, numPlayers, numRounds);
	}
		
public static void playGame(Player[] player, int numPlayers, int numRounds)
{
		Scanner scannedStory=new Scanner(System.in);
		Dice [] storyPics = new Dice[numPlayers];
		for (int index = 0;index <= player.length-1;index ++)
		{
			System.out.println(player[index].getName() + "'s turn");
			storyPics[index] = new Dice(true);
			JFrame window = new JFrame("Your Dice Roll");
			GridLayout pictureGrid  = new GridLayout(0,3);
			window.setSize(900, 300);
			window.setLayout(pictureGrid);
	        window.add(new drawsImage(storyPics[index].getRoll(0)));
	        window.add(new drawsImage(storyPics[index].getRoll(1)));
	        window.add(new drawsImage(storyPics[index].getRoll(2)));
	        window.setLocationRelativeTo(null);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true); 
			System.out.println("What's the Story? \n");
			String story = scannedStory.nextLine();
			player[index].setStory(story);
			window.setVisible(false);
		}
		for (int index = 0; index <= player.length-1;index++)
		{
			int highcount = index+1;
			int lowcount = index -1;
			System.out.println(Arrays.toString(storyPics[index].getRoll()));
		}
		
		//allow for ratings of the stories
		for(int index = 0; index < numPlayers; index++)
		{
			for(int rate = 0; rate < numPlayers; rate++)
			{
				if(index == rate)
					System.out.println("\n");
				else
				{
					System.out.println(player[index].getName()+" Please rate these stories ");	
					JFrame window = new JFrame("Your Dice Roll");
					GridLayout pictureGrid  = new GridLayout(0,3);
					window.setSize(900, 300);
					window.setLayout(pictureGrid);
			        window.add(new drawsImage(storyPics[rate].getRoll(0)));
			        window.add(new drawsImage(storyPics[rate].getRoll(1)));
			        window.add(new drawsImage(storyPics[rate].getRoll(2)));
			        window.setLocationRelativeTo(null);
			        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        window.setVisible(true); 
					System.out.println(player[rate].getStory());
					System.out.println("1 - 5 how would you rate this story");
					int score = scannedStory.nextInt();
					player[rate].setScore(score);
					window.setVisible(false); 
				}
			}
		}
		for(int index = 0; index < numPlayers; index++)
		{
			player[index].setCount(numRounds, numPlayers);
			System.out.println(player[index].getName() + "'s Score is: " + Double.toString(player[index].getScore()));
		}
		
		System.out.println("Play another round? Y/N ");
		String nextRound = scannedStory.next();
		if(nextRound.equals("Y"))
		{
			numRounds++;
			System.out.println("Let's play again!");
			playGame(player, numPlayers, numRounds);
		}
		else
		{
			System.out.println("Final Score is: ");
			for(int index = 0; index < numPlayers; index++)
			{
				player[index].setCount(numRounds, numPlayers);
				System.out.println(player[index].getName() + "'s Score is: " + Double.toString(player[index].getScore()));
			}
			return;
		}
}			
			
			
}	
				
	
	
	//menu to start new game, quit or see high scores
		
		//start new game
			//ask user to for number of players playing the game
				//create array of objects "players" from player class with size being number of players
					
				//for loop that gets player names
				
				//for loop that displays images and gets story for each player

				//for loop that displays stories and images from other players to each player and sets score for each
				
				//save and sort high scores to text file
				
				//ask player if another round y or n
				
				//n = exit program y = return to image and story for loop
		
		// quit exit program
		
		// high scores prints names and scores from text file

