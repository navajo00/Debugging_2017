package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sourceCode.Dice;
import sourceCode.DiceValue;
import sourceCode.Game;
import sourceCode.Player;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class T002_test {
	
	Game gameOneOrNoMatches;
	Game gameTwoMatches;
	Game gameThreeMatches;
	Player player;
	DiceValue pickAnchor;
	DiceValue pickSpade;
	Dice dieSpade;
	Dice dieHeart;
	Dice dieDiamond;
	final static int START_BALANCE = 100;

	public T002_test()
	{
		dieSpade = mock(Dice.class);
		dieHeart = mock(Dice.class);
		dieDiamond = mock(Dice.class);

		
		pickAnchor = DiceValue.ANCHOR;
		pickSpade = DiceValue.SPADE;

		
		player = new Player("Nelly", START_BALANCE);

		when(dieSpade.roll()).thenReturn(DiceValue.SPADE);
		when(dieHeart.roll()).thenReturn(DiceValue.HEART);
		when(dieDiamond.roll()).thenReturn(DiceValue.DIAMOND);

		when(dieSpade.getValue()).thenReturn(DiceValue.SPADE);
		when(dieHeart.getValue()).thenReturn(DiceValue.HEART);
		when(dieDiamond.getValue()).thenReturn(DiceValue.DIAMOND);

		gameOneOrNoMatches = new Game(dieSpade, dieHeart, dieDiamond);
		gameTwoMatches = new Game(dieSpade, dieSpade, dieDiamond);
		gameThreeMatches = new Game(dieSpade, dieSpade, dieSpade);
	}

	@Test
	public void testPlayGame()
	{
		gameOneOrNoMatches.playRound(player, pickAnchor, 0);
		assertEquals(START_BALANCE, player.getBalance()); 

		int bet = START_BALANCE/4; 
		gameOneOrNoMatches.playRound(player, pickAnchor, bet);
		assertEquals(START_BALANCE - bet, player.getBalance()); 

		player.setBalance(START_BALANCE); 
	}
}
