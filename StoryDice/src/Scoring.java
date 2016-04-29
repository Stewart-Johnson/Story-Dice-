public class Scoring
{
	static int totalScore;
	static int scoreNum;
	static double average;
	public Scoring()
	{
		totalScore = 0;
		scoreNum = 0;
		average = 0.0;
		
	}
	
	static public void setScore(int scoreEntered)
	{
		totalScore += scoreEntered;
		scoreNum += 1;
	}
	
	static public int getTotalScore()
	{
		return totalScore;
		
	}
	
	static public int getScoreNum()
	{
		return scoreNum;
	}

	static public double getAverage()
	{
		average = totalScore/scoreNum;
		return average;
	}
}