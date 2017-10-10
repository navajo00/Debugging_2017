package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Test;

import sourceCode.Dice;
import sourceCode.Game;

public class T001_run1_test {
	
	static Game game;
	static Dice di1;
	static Dice di2;
	static Dice di3;
	
	Logger loger = Logger.getLogger("T001_test");
	
	@After
	public void after() {
		
		di1 = null;
		di2 = null;
		di3 = null;
		game = null;
		
	}
	

	@Test
	public void testGetRandom() {
		loger.log(Level.INFO, "Testing Game class and DiceValue class.");
		for (int i = 0; i < 10; i++) {
			di1 = new Dice();
			di2 = new Dice();
			di3 = new Dice();
			game = new Game(di1, di2, di3);
			System.out.println(game.getDiceValues().toString());
		}

	}
	
	@Test
	public void testDiceValues() {
		loger.log(Level.INFO, "Testing Dice random values ");
		for (int i = 0; i < 10; i++) {
			di1 = new Dice();
			di2 = new Dice();
			di3 = new Dice();
			
			System.out.println(di1.toString()+" , "+di2.toString()+" , "+di3.toString());
		}
		
	}
	
	

}
