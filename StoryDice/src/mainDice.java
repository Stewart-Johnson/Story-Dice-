
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class mainDice
{
	
	static int count = 1;
	static int numRounds = 1;
	public static void main(String[] args)
	{
		System.out.println("Welcome to Story Dice!");
		System.out.println("You need at least two people in order to play this game!");
		System.out.println("Write a story based on the 3 pictures you roll and then rate your friends stories!");
		System.out.println("The person with the highest average score at the end wins and gets a place in the Hall of Winners!");

		
		// show high scores
		
		System.out.println("Hall of Winners:");
		System.out.println();
		
		// The name of the file to open.
        String fileName = "src/storydice/winners.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();
            System.out.println();
        }
        catch(FileNotFoundException ex) {
                          
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
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
			int max = 0;
			for(int index = 0; index < numPlayers; index++)
			{
				if (player[index].getScore() > max) {
					max = index;
				}
				player[index].setCount(numRounds, numPlayers);
				System.out.println(player[index].getName() + "'s Score is: " + Double.toString(player[index].getScore()));
			}
			
			// file
			
			 // The name of the file to open.
	        String fileName = "src/storydice/winners.txt";

	        try {
	            // Assume default encoding.
	            FileWriter fileWriter =
	                new FileWriter(fileName, true);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);

	            // Note that write() does not automatically
	            // append a newline character.
	            bufferedWriter.write(player[max].getName() + ": " + player[max].getScore());
	            bufferedWriter.newLine();

	            // Always close files.
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
			
			return;
		}	
}
}
