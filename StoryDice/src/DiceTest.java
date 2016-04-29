import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest 
{
	//test constructor
	@Test
	public void DiceTest() 
	{
		Dice diceTest = new Dice();
		assertNotNull(diceTest);
	}
	
	//test getRollImages
	@Test
	public void getDiceImagesTest()
	{
		Dice diceTest = new Dice();
		assertNotNull(diceTest.getRollImages());
	}
	
	//test getRollWords
	@Test
	public void getDiceWordssTest()
	{
		Dice diceTest = new Dice();
		assertNotNull(diceTest.getRollWords());
	}
	
	//test getRollWords with index
	@Test
	public void getDiceImagesIndexTest()
	{
		Dice diceTest = new Dice();
		assertNotNull(diceTest.getRollImages(1));
	}	

}
