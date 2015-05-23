class MainBoard 
{
	int numOfCol = 3;
	int numOfRow = 3;
	int player; // blank = 0 O = 1 X = 2 
	miniBoard [][] mainBoard = new miniBoard[numOfCol][numOfRow];
	int [][] finalView = new int[numOfCol][numOfRow];
	int nextRow;
	int nextCol;
		
	MainBoard()
	{
		for (int i = 0; i < numOfCol; i++)
		{
			 for (int j = 0; j < numOfRow; j++)
			 {
				 finalView[i][j] = 0;
				 mainBoard[i][j] = new miniBoard();
			 }
		}
		
		//code that lets user determine who goes first
		
		//code that lets user determine which big square they want to go to
		
		playerChoice(nextRow, nextCol);
	}
	
	public void playerChoice(int row, int col)
	{
		mainBoard[row][col].choice(player);
		
		if (mainBoard[row][col].isWinner());
		{
			finalView[row][col] = player;
		}
	}
	
	
}