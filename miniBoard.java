
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
	
	boolean choice(int cho)
	{
		//CODE THAT LETS PLAYER MAKE CHOICE GRAPHICALLY
		
		if (isWinner())
		{
			return true; //return who won
		}
		else
			return false;
		
	}
	
	boolean isWinner()
	{
		if (board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0) //vertical
		{
			return true;
		}
		else if (board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0)
		{
			return true;
		}
		else if (board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0)
		{
			return true;
		}
		else if (board[0][0] != 0 && board[1][0] != 0 && board[2][0] != 0) //horizontal wins
		{
			return true;
		}
		else if (board[0][1] != 0 && board[1][1] != 0 && board[2][1] != 0)
		{
			return true;
		}
		else if (board[0][2] != 0 && board[1][2] != 0 && board[2][2] != 0)
		{
			return true;
		}
		else if (board[0][0] != 0 && board[1][1] != 0 && board[2][2] != 0) //diagonal wins
		{
			return true;
		}
		else if (board[0][2] != 0 && board[1][1] != 0 && board[2][0] != 0)
		{
			return true;
		}
		else
			return false;
	}
	
}
