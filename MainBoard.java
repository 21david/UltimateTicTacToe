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
		
		//CODE THAT LETS USER DETERMINE WHO GOES FIRST
		
		//CODE THAT LETS USER DETERMINE THE FIRST BIG SQUARE THEY WANT TO GO TO
		
		//INITIALIZE FIRST PLAYER FIRST ROW AND FIRST COLUMN VARIABLES
		
		do //will loop till there is a winner
		{
			playerChoice(nextRow, nextCol);/// nextRow and nextCol determine the big square the player has to go to next
		} while (!finalWin(player));
	}
	
	public void playerChoice(int row, int col)
	{
		int [] arr = new int[2];
		arr = mainBoard[row][col].choice(player);
		
		if (mainBoard[row][col].isWinner(player));
		{
			finalView[row][col] = player;
		}
		
		
		nextRow = arr[0];
		nextCol = arr[1];
	}
	
	boolean finalWin(int cho)
	{
		if (finalView[0][0] == cho && finalView[0][1] == cho && finalView[0][2] == cho) //vertical
		{
			return true;
		}
		else if (finalView[1][0] == cho && finalView[1][1] == cho && finalView[1][2] == cho)
		{
			return true;
		}
		else if (finalView[2][0] == cho && finalView[2][1] == cho && finalView[2][2] == cho)
		{
			return true;
		}
		else if (finalView[0][0] == cho && finalView[1][0] == cho && finalView[2][0] == cho) //horizontal wins
		{
			return true;
		}
		else if (finalView[0][1] == cho && finalView[1][1] == cho && finalView[2][1] == cho)
		{
			return true;
		}
		else if (finalView[0][2] == cho && finalView[1][2] == cho && finalView[2][2] == cho)
		{
			return true;
		}
		else if (finalView[0][0] == cho && finalView[1][1] == cho && finalView[2][2] == cho) //diagonal wins
		{
			return true;
		}
		else if (finalView[0][2] == cho && finalView[1][1] == cho && finalView[2][0] == cho)
		{
			return true;
		}
		else
		{
			if (player == 1)
				player = 2;
			else
				player = 1;
			
			return false;
			
		}
	}
	
	
}