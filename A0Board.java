
public class A0Board extends MainBoard 
{
	int [][]board = new int[numOfCol][numOfRow];;

	A0Board()
	{
		for (int i = 0; i < numOfCol; i++)
		{
			 for (int j = 0; j < numOfRow; i++)
			 {
				 board[i][j] = 0;
			 }
		}
	}
	
}
