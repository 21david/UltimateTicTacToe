
public class miniBoard 
{
	int board[][] = new int[3][3]; //0 blank 1 = 0 2 = X
	int choice;
	
	miniBoard()
	{
		for (int i = 0; i < 3; i++)
		{
			 for (int j = 0; j < 3; j++)
			 {
				 board[i][j] = 0;
			 }
		}
	}
	
	int [] choice(int cho) // has to return a row and column value
	{
		//CODE THAT LETS PLAYER MAKE CHOICE GRAPHICALLY
		int row = -99;
		int col = -99;

		boolean taken = true;		


		while (taken)
		{
			if (board[row][col] == 0)
			{
				board[row][col] = cho;
				taken = false;
			}
			else
			//PRINT A MESSAGE SAYING ITS ALREADY TAKEN
		}

		int [] coordinates = new int[2];
		
		// coordinates[0] = what row the player chose
		// coordinates[1] = what column the player chose
		return coordinates;
	}
	
	boolean isWinner(int cho)
	{
		if (board[0][0] == cho && board[0][1] == cho && board[0][2] == cho) //vertical
		{
			return true;
		}
		else if (board[1][0] == cho && board[1][1] == cho && board[1][2] == cho)
		{
			return true;
		}
		else if (board[2][0] == cho && board[2][1] == cho && board[2][2] == cho)
		{
			return true;
		}
		else if (board[0][0] == cho && board[1][0] == cho && board[2][0] == cho) //horizontal wins
		{
			return true;
		}
		else if (board[0][1] == cho && board[1][1] == cho && board[2][1] == cho)
		{
			return true;
		}
		else if (board[0][2] == cho && board[1][2] == cho && board[2][2] == cho)
		{
			return true;
		}
		else if (board[0][0] == cho && board[1][1] == cho && board[2][2] == cho) //diagonal wins
		{
			return true;
		}
		else if (board[0][2] == cho && board[1][1] == cho && board[2][0] == cho)
		{
			return true;
		}
		else
			return false;
	}
	
}
