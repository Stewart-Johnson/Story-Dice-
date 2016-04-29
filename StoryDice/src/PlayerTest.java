import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player player = new Player("Jimmy");
		assertNotNull(player);
		assertEquals("Jimmy", player.getName());
	}
	
	@Test
	public void testName() {
		Player player = new Player();
		player.setName("Jimmy");
		assertEquals("Jimmy", player.getName());
	}
	
	@Test
	public void testStory() {
		Player player = new Player();
		assertEquals(0, player.setStory("This is my story."));
		assertEquals("This is my story.", player.getStory());
		
		assertEquals(-1, player.setStory("This is my story. This is my story. This is my story. This is my story. This is my story. This is my story. This is my story. This is my story. This is my story."));
		assertEquals("This is my story.", player.getStory());
	}
	
	@Test
	public void testRoll() {
		// it is random so we cannot test specifics, just that the dice are being rolled
		Player player = new Player();
		assertNotNull(player.getRoll());
		assertNotNull(player.getRoll(0));
		assertNotNull(player.getRoll(0));
		assertNotNull(player.getRoll(0));
	}
	
	@Test
	public void testScore() {
		Player player = new Player();
		player.setCount(1, 4);
		player.setScore(5);
		player.setScore(4);
		player.setScore(3);
		assertEquals(4, player.getScore(), 0);
	}

}
