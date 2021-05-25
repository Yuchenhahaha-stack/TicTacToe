import java.awt.BorderLayout;
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



public class TicTacToeGame extends JFrame{
	public int xWin;
	public int oWin; 
	private Container pane;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem newGame;
	private JMenuItem playAI;
	private JMenuItem quit;
	//private JFrame frame; 
	private String currPlayer;
	private boolean isWinner;
	private JButton [][] board;
	//score board
	private JLabel score;
	private Container pane2;
	
	
	public TicTacToeGame() {

		super();

		//setVisible(true);
		pane = getContentPane();
		pane.setLayout(new GridLayout(4,4));
		setSize(300,300);
		setTitle("Tic Tac Toe Game");
		setResizable(false);
		currPlayer = "x";
		board = new JButton[3][3];
		isWinner = false;
		setVisible(true);
		intializeBoard();
		intializeMenuBar();
		xWin = 0;
		oWin = 0;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		/*
		 * //score board pane2 = getContentPane(); pane2.setLayout(new BorderLayout());
		 * setSize(100,100); setTitle("Score Board"); setResizable(false);
		 * setVisible(true);
		 */
	}
	
	private void intializeBoard() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c ++) {
				JButton button = new JButton();
				board[r][c] = button;
				button.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			if (((JButton)e.getSource()).getText().equals("") && isWinner == false)
				button.setText(currPlayer);
						isWinner();
						changePlayer();
						computer();
						}
				});
				pane.add(button);
				//board[r][c].setText("");
			}
		}
	}
	private void resetBoard() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				board[r][c].setText("");
			}
		}
		currPlayer = "x";
//		if(currPlayer.equals("x")) {
//			currPlayer = "o";
//		}
//		else {
//			currPlayer = "x";
//		}
		isWinner = false;
	}
	private void computer() {
		board[1][1].setText("x");
		changePlayer();
		if(board[1][1].getText().equals("x") && (board[0][1].getText().equals("o") || board[1][2].getText().equals("o") || board[1][0].getText().equals("o") || board[2][1].getText().equals("o")) ) {
			board[0][2].setText("x");
		}
		else if((board[1][1].getText().equals("x") && (board[0][0].getText().equals("o") || board[2][0].getText().equals("o") || board[0][2].getText().equals("o") || board[2][2].getText().equals("o")) )) {
			board[1][2].setText("x");
		}
		
	}
	
	private void changePlayer() {
		if(currPlayer.equals("x")) {
			currPlayer = "o";
		}
		else {
			currPlayer = "x";
		}
	}
	private void isWinner() { // all winning situations
		if(currPlayer.equals("x")) {
			if(board[0][0].getText().equals("x") && board[0][1].getText().equals("x") && board[0][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[1][0].getText().equals("x") && board[1][1].getText().equals("x") && board[1][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[2][0].getText().equals("x") && board[2][1].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[0][0].getText().equals("x") && board[1][0].getText().equals("x") && board[2][0].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[0][1].getText().equals("x") && board[1][1].getText().equals("x") && board[2][1].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[0][2].getText().equals("x") && board[1][2].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[0][0].getText().equals("x") && board[1][1].getText().equals("x") && board[2][2].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
			else if(board[0][2].getText().equals("x") && board[1][1].getText().equals("x") && board[2][0].getText().equals("x")) {
				isWinner = true;
				xWin ++;
				System.out.println("x has won " + xWin + " games");
			}
		}
		else if(currPlayer.equals("o")) {
			if(board[0][0].getText().equals("o") && board[0][1].getText().equals("o") && board[0][2].getText().equals("o")) {
				isWinner = true;				
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[1][0].getText().equals("o") && board[1][1].getText().equals("o") && board[1][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[2][0].getText().equals("o") && board[2][1].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[0][0].getText().equals("o") && board[1][0].getText().equals("o") && board[2][0].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[0][1].getText().equals("o") && board[1][1].getText().equals("o") && board[2][1].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[0][2].getText().equals("o") && board[1][2].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
			else if(board[0][0].getText().equals("o") && board[1][1].getText().equals("o") && board[2][2].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}

			else if(board[0][2].getText().equals("o") && board[1][1].getText().equals("o") && board[2][0].getText().equals("o")) {
				isWinner = true;
				oWin ++;
				System.out.println("o has won " + oWin + " games");
			}
		}
	}

	
	private void intializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
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
							computer();
							}
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//				computer();
//				
//			}
		});

		menu.add(quit);
		menu.add(newGame);
		menu.add(playAI);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
}

