public class Scoring
{
	static boolean[] scoreFlags;
	static int[] Score;
	public Scoring(int numPlayers)
	{
		Score = new int[numPlayers];
		scoreFlags = new boolean[numPlayers];
		
	}
	
	static public void setScore(int score, int index)
	{
		//either implement or call a search function
		//which returns the index in our name Array
		Score[index] = score;
		setFlag(index, true);		
	}
	
	static public int getScore(int index)
	{
		//implement search to return index from name
		setFlag(index, true);
		return Score[index];
		
	}
	
	static public void setFlag(int index, boolean flagValue)
	{
		scoreFlags[index] = flagValue;
	}

	static public boolean getFlag(int index)
	{
		//again depending on search finds name
		//and returns the index
		return scoreFlags[index];
	}
}
