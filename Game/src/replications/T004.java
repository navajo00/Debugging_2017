package replications;

import sourceCode.Main;


public class T004 {
	
	public static void main(String[] args) throws Exception
	{
		String[] argsTest = {"7"};
		int totalWins = 0;
		int totalLosses = 0;
		for(int i = 0; i < 2000; i ++)
		{
			Main.main(argsTest);
			totalWins += totalWins;
			totalLosses += totalLosses;
		}
		System.out.println(String.format("Win count = %d, Lose count = %d\n", totalWins, totalLosses));
		System.out.println(String.format("Overall win rate = %.4f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
	}
	
}
