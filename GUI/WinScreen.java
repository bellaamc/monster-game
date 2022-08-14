package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import projectOne.GameEnvironment;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * class WinScreen, generates when you win the game
 *
 */
public class WinScreen {
	/** The set up game frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame inputs game environment
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinScreen window = new WinScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * WinScreen Create the application.
	 * @param newGame inputs game environment
	 */
	public WinScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel winLabel = new JLabel("YOU WON!");
		winLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		winLabel.setBounds(161, 79, 143, 62);
		frame.getContentPane().add(winLabel);
		
		JLabel pointsLabel = new JLabel("Total Points: " + newGame.getPoints());
		pointsLabel.setBounds(128, 152, 232, 14);
		frame.getContentPane().add(pointsLabel);
		
		JLabel goldLabel = new JLabel("Total Gold:  " + newGame.getGold() + "g");
		goldLabel.setBounds(128, 188, 123, 14);
		frame.getContentPane().add(goldLabel);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatedInventoryWon.main(newGame);
				frame.dispose();
			}
		});
	}

}
