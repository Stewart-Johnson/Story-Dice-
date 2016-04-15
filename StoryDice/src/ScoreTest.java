import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void ScoringTest()
	{
		Scoring testScore = new Scoring(5);
		assertNotNull(Scoring.scoreFlags);
		assertNotNull(Scoring.Score);
	}
	
	@Test
	public void SetScoreTest()
	{
		Scoring testScore = new Scoring(5);
		testScore.setScore(10, 0);
		assertEquals(Scoring.Score[0],10);
	}
	
	@Test
	public void SetFlagTest()
	{
		Scoring testScore = new Scoring(5);
		testScore.setScore(10, 0);
		assertEquals(testScore.scoreFlags[0],true);
	}
	
	@Test
	public void GetFlagTest()
	{
		Scoring testScore = new Scoring(5);
		testScore.setScore(10, 0);
		boolean test = testScore.getFlag(0);
		assertEquals(test,true);
	}
}
