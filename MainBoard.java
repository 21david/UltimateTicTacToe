class MainBoard 
{
	int numOfCol = 3;
	int numOfRow = 3;
	int player; // blank = 0 O = 1 X = 2 
	miniBoard [][] mainBoard = new miniBoard[numOfCol][numOfRow];
	int [][] finalView = new int[numOfCol][numOfRow];
		
	MainBoard()
	{
		for (int i = 0; i < numOfCol; i++)
		{
			 for (int j = 0; j < numOfRow; j++)
			 {
				 finalView[i][j] = 0;
			 }
		}
	}
	
	
}