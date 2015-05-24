import java.awt.BorderLayout;
import java.util.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

import static java.lang.System.out;

class MainBoard
{
	final String NAME_OF_GAME = "Ultimate Tic Tac Toe";
	int numOfCol = 3;
	int numOfRow = 3;
	int player; // blank = 0 O = 1 X = 2 
	int nextRow;
	int nextCol;
	boolean firstTurn = true;
	
	miniBoard [][] mainBoard = new miniBoard[numOfCol][numOfRow];
	int [][] finalView = new int[numOfCol][numOfRow];

	JFrame jframe;
	JButton button;
	GameCanvas gameCanvas;
	MenuJPanel menuJPanel;
	
	MainBoard()
	{
		initialSetUp();
		player = 2;
		for (int i = 0; i < numOfCol; i++)
		{
			 for (int j = 0; j < numOfRow; j++)
			 {
				 finalView[i][j] = 0;
				 mainBoard[i][j] = new miniBoard();
			 }
		}
	}
		
	void initialSetUp()
	{
		// button component
		button = new JButton("Press mee");
		button.setText("Press me");
		button.addActionListener(new ButtonActionListener());
		
		// menu jpanel
		menuJPanel = new MenuJPanel();
		menuJPanel.add(button);
		
		// canvas component
		gameCanvas = new GameCanvas();
		gameCanvas.addMouseListener(gameCanvas);
		
		// set up the jframe
		setUpJFrame();
		jframe.add(menuJPanel);
		
		// display jframe
		jframe.setVisible(true);
	}
	
	void setUpJFrame()
	{
		// Jframe set-up
		jframe = new JFrame(NAME_OF_GAME);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(730, 730);
	}
	
	// checks if player 'cho' won
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
			return false;
	}
	
	// classes:
	
	class MenuJPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(Color.black);
			g.drawString("Ultimate Tic Tac Toe", 100, 100);
			g.setFont(new Font("Arial", Font.PLAIN, 14));
			g.drawString("Rules:", 100, 150);
			g.drawString("The rules for ultimate tic tac toe are similar to it's regular counterpart.", 100, 200);
			g.drawString("The game is composed of 9 big tic tac toe tables. The first player gets the first big table. ", 100, 250);
			g.drawString("Example: If P1 marks a small top right square then P2 has to mark a small square ", 100, 300);
			g.drawString("in a top right big square.", 100, 320);
			g.drawString("The game continues until you get three big squares in a row.", 100, 350);
			g.drawString("If the next big square you have to choose is full then you can pick any big square.", 100, 400);
			g.drawString("Hit Press Me and maximize the window to begin.", 100, 600);
		}
	}
	
	
	int row, col;
	
	// class for drawing the game screen 
	class GameCanvas extends Canvas implements MouseListener
	{
		// draws the game screen itself
		public void paint(Graphics g)
		{
			out.println("painted()");
			
			// white background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			g.setColor(Color.black);
			
			// draws the big 3x3 grid
			g.drawLine(240, 0, 240, 720);
			g.drawLine(241, 0, 241, 720);
			g.drawLine(480, 0, 480, 720);
			g.drawLine(481, 0, 481, 720);
			g.drawLine(0, 240, 720, 240);
			g.drawLine(0, 241, 720, 241);
			g.drawLine(0, 480, 720, 480);
			g.drawLine(0, 481, 720, 481);
			
			// draws each of the 9 smaller 3x3 grids
			for(int i = 0; i < 9; i++)
				drawMiniBoard(g, i / 3 * 240, i % 3 * 240);
			
			// iterates through all the miniBoards in mainBoard
			// and draws O if it has a 1, X if it has a 2
			// and leaves it alone if it has a 0
			for(int r = 0; r < numOfRow * 3; r++)
				for(int c = 0; c < numOfCol * 3; c++)
				{
					int playr = mainBoard[r/3][c/3].board[r%3][c%3];
					if(playr == 1)
						g.drawString("O", c * 80 + 40, r * 80 + 40);
					else if(playr == 2)
						g.drawString("X", c * 80 + 40, r * 80 + 40);
				}
			
		}
		
		// draws a small 3x3 grid
		public void drawMiniBoard(Graphics g, int x, int y)
		{
			g.drawLine(x + 80, y + 0, x + 80, y + 240);
			g.drawLine(x + 160, y + 0, x + 160, y + 240);
			g.drawLine(x + 0, y + 80, x + 240, y + 80);
			g.drawLine(x + 0, y + 160, x + 240, y + 160);
		}
		
		// when user clicks, this code is run
		public void mousePressed(MouseEvent e)
		{
			out.println("mouse clicked");
			// raw x and y coordinates
		
			int x = e.getX();
			int y = e.getY();
			
			// the row and col of the big box they clicked in
			int mainCol = x / 240;
			int mainRow = y / 240;
			
			row = x;
			col = y;
				
			// the row and col of the small box they clicked in
			int miniCol = x % 240 / 80;
			int miniRow = y % 240 / 80;
			
			out.println(x + "  " + y);
			out.println(mainCol + "  " + mainRow);
			out.println(miniCol + "  " + miniRow);
				
			if (!OK_To_Mark(mainRow, mainCol, miniRow, miniCol))
			{
				
			}
			else
			{
				player = 2 - player/2;
				mainBoard[mainRow][mainCol].board[miniRow][miniCol] = player;
				firstTurn = false;
				nextRow = miniRow;
				nextCol = miniCol;
				
				
				if (mainBoard[mainRow][mainCol].isWinner(player))
				{
					if (finalView[mainRow][mainCol] == 0)
					{
					finalView[mainRow][mainCol] = player;
					out.println("Player " + player + " won block " + (mainRow + 1) + " " + (mainCol + 1));
					out.println(Arrays.deepToString(finalView).replace("],","]\n"));
					if (finalWin(player))
					{
						out.println("winner");
						displayWinMessage(player);
					}
					}
					
				}
				gameCanvas.repaint();
				
			}
			
		}

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		
		public void displayWinMessage(int player)
		{
			JFrame jframe = new JFrame(NAME_OF_GAME);
			jframe.setSize(200, 100);
			
			if(player == 1)
				jframe.add(new Button("O wins!"));
			else if(player == 2)
				jframe.add(new Button("X wins!"));
			jframe.setVisible(true);
		}
		
		boolean OK_To_Mark(int R, int C, int r, int c)
		{
			if (firstTurn)
				return true;
			
			if (finalView[nextRow][nextCol] != 0) // if your next one is full
			{
				return true;
			}
			
			if (mainBoard[R][C].board[r][c] == 0) //is blank or not
			{
				if (R == nextRow)
				{
					if (C == nextCol)
					{
						return true;
					}
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
			
		}

	}
	
	// class for button actionListener
	class ButtonActionListener implements ActionListener
	{
		// when user clicks button, this code runs
		public void actionPerformed(ActionEvent event)
		{
			jframe.remove(button);
			jframe.remove(menuJPanel);
			jframe.getContentPane().add(gameCanvas);
			jframe.repaint();
		}
	}
	
	
}