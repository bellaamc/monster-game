package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

import projectOne.GameEnvironment;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

/**
 * 
 * DifficultyChoice allows the user to choose which difficulty to play
 *
 */
public class DifficultyChoice {

	/** sets up the basic frame */
	private JFrame frame;

	/**
	 * main generates window
	 * @param newGame inputs the gameEnvironment
	 * Launch the application.
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DifficultyChoice window = new DifficultyChoice(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * DifficultyChoice constructs difficulty window
	 * @param newGame inputs the gameEnvironment
	 * Create the application.
	 */
	public DifficultyChoice(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame inputs the gameEnvironment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton easyButton = new JButton("Easy");
		easyButton.setBounds(112, 122, 89, 60);
		frame.getContentPane().add(easyButton);
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseBattleScreen.main(newGame);
				frame.dispose();
			}
		});
		
		JButton hardButton = new JButton("Hard");
		hardButton.setBounds(237, 122, 89, 60);
		frame.getContentPane().add(hardButton);
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame.increaseDifficulty();
				ChooseBattleScreen.main(newGame);
				frame.dispose();
			}
		});
		
		JTextArea txtrChooseYourDifficulty = new JTextArea();
		txtrChooseYourDifficulty.setFont(new Font("Calibri", Font.PLAIN, 19));
		txtrChooseYourDifficulty.setText("Choose your difficulty:");
		txtrChooseYourDifficulty.setBackground(SystemColor.menu);
		txtrChooseYourDifficulty.setBounds(129, 71, 174, 28);
		txtrChooseYourDifficulty.setEditable(false);
		frame.getContentPane().add(txtrChooseYourDifficulty);
	}

}
