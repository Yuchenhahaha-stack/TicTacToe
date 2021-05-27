
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
public class TicTacToeGame  extends JFrame{
	private Container pane;
	private JFrame frame; 
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem newGame;
	private JMenuItem quit;
	private JMenuItem playAI;
	private String currPlayer;
	private JButton [][] board;
	private JLabel[][] label;
	private JLabel score;
	private JLabel xScore;
	private JLabel oScore;
	private boolean isWinner;
	private int xWin;
	private int oWin;
	private boolean wholeBoardUsed;
	private boolean isComputer;

	//score board
	//private JLabel score;
	//private Container pane2;

	public TicTacToeGame() {

		super();
		//setVisible(true);
		pane = getContentPane();
		pane.setLayout(new GridLayout(4,3));
		setSize(500,500);
		setTitle("Tic Tac Toe");
		setResizable(true);
		currPlayer = "x";
		board = new JButton[3][3];
		label = new JLabel[2][3];
		isWinner = false;
		setVisible(true);
		intializeBoard();
		intializeMenuBar();
		xWin = 0;
		oWin = 0;

		/*
		 * //score board pane2 = getContentPane(); pane2.setLayout(new BorderLayout());
		 * setSize(100,100); setTitle("Score Board"); setResizable(false);
		 * setVisible(true);
		 * 
		 * 
		 */
	}

	private void intializeBoard() {

		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c ++) {
				JButton button = new JButton();
				board[r][c] = button;
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (((JButton)e.getSource()).getText().equals("") && isWinner == false) {
							button.setText(currPlayer);
							wholeBoardUsed();
							isWinner();
							changePlayer();
						}
					}
				});
				pane.add(button);
				//board[r][c].setText("");
			}
		}


		JLabel score = new JLabel();
		score.setText("Score:");
		score.setForeground(Color.BLUE);
		label[1][0] = score;
		score.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(score);

		JLabel xScore = new JLabel();
		this.xScore = xScore;
		xScore.setText("" + 0);
		xScore.setForeground(Color.BLUE);
		label[1][1] = xScore;
		xScore.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(xScore);

		JLabel oScore = new JLabel();
		this.oScore = oScore;
		oScore.setText(""+ 0);
		oScore.setForeground(Color.BLUE);
		label[1][2] = oScore;
		oScore.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(oScore);

	}


	private void intializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		newGame = new JMenuItem("New Game");
		quit = new JMenuItem("Quit Game");
		playAI = new JMenuItem("Play with Computer");


		quit.addActionListener(new ActionListener(){

			@Override

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//resetBoard();
				System.exit(0);
			}
		});

		newGame.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetBoard();
			}
		});
		
		playAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							isComputer = true;
							computer();
							}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		menu.add(playAI);
	}


	private void resetBoard() {

		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c ++) {
				board[r][c].setText("");
			}
		}
		
		currPlayer = "x";
		isWinner = false;
		wholeBoardUsed = false;
	}
	
	private int countEmpty() {
		int count = 0;
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c].getText().equals("")) {
					count++;
				}
			}
		}
		return count;
	}
	private void computer() {

	board[1][1].setText("x");
	changePlayer();
	if(board[1][1].getText().equals("x") && (board[0][1].getText().equals("o") || board[1][2].getText().equals("o") || board[1][0].getText().equals("o") || board[2][1].getText().equals("o")) && (countEmpty()==7)) {
		board[0][2].setText("x");
		currPlayer = "o";
	}
	else if((board[1][1].getText().equals("x") && (board[0][0].getText().equals("o") || board[2][0].getText().equals("o") || board[0][2].getText().equals("o") || board[2][2].getText().equals("o")) && (countEmpty()==7) )) {
		board[1][2].setText("x");
		currPlayer = "o"; 
		}
	}
	


	private void changePlayer() {
		if(currPlayer.equals("x")) {
			currPlayer = "o";
		}

		else if(currPlayer.equals("o")){
			currPlayer = "x";
		}
	}

	private void wholeBoardUsed() {
		if(!board[0][0].getText().isBlank() && !board[0][1].getText().isBlank() && !board[0][2].getText().isBlank() &&!board[1][0].getText().isBlank() &&
				!board[1][1].getText().isBlank() && !board[1][2].getText().isBlank() && !board[2][0].getText().isBlank() &&
				!board[2][1].getText().isBlank() && !board[2][2].getText().isBlank()){
			System.out.println("Whole Board Used");
			wholeBoardUsed = true;
		}
	}


	private void isWinner() { // all winning situations
		if(wholeBoardUsed == true){ //Cats game
			System.out.println("Reached");
			resetBoard();
			board[0][0].setText("Cat's");
			board[0][1].setText("Game");
			board[1][0].setText("Click");
			board[1][1].setText("New Game");
		}
		else if(currPlayer.equals("x")) {
			if(board[0][0].getText().equals("x") && board[0][1].getText().equals("x") && board[0][2].getText().equals("x")) {
				isWinner = true;
				xWin ++; 
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}
			
			else if(board[1][0].getText().equals("x") && board[1][1].getText().equals("x") && board[1][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[2][0].getText().equals("x") && board[2][1].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[0][0].getText().equals("x") && board[1][0].getText().equals("x") && board[2][0].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[0][1].getText().equals("x") && board[1][1].getText().equals("x") && board[2][1].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[0][2].getText().equals("x") && board[1][2].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[0][0].getText().equals("x") && board[1][1].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}

			else if(board[0][2].getText().equals("x") && board[1][1].getText().equals("x") && board[2][0].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
				xScore.setText("" + xWin);
			}
		}

		else if(currPlayer.equals("o")) {
			if(board[0][0].getText().equals("o") && board[0][1].getText().equals("o") && board[0][2].getText().equals("o")) {
				isWinner = true;				
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[1][0].getText().equals("o") && board[1][1].getText().equals("o") && board[1][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[2][0].getText().equals("o") && board[2][1].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[0][0].getText().equals("o") && board[1][0].getText().equals("o") && board[2][0].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[0][1].getText().equals("o") && board[1][1].getText().equals("o") && board[2][1].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[0][2].getText().equals("o") && board[1][2].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[0][0].getText().equals("o") && board[1][1].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}

			else if(board[0][2].getText().equals("o") && board[1][1].getText().equals("o") && board[2][0].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
				oScore.setText("" + oWin);
			}
		}
	}
}
