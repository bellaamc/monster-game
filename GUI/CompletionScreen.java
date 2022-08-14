package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import projectOne.GameEnvironment;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.awt.Color;

/**
 * 
 * CompletionScreen sets a window to show that you have completed the game
 *
 */
public class CompletionScreen {

	private JFrame frame;

	/**
	 * main runs window
	 * @param newGame inputs the gameEnvironment
	 * Launch the application.
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletionScreen window = new CompletionScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CompletionScreen generates completion window
	 * @param newGame inputs the gameEnvironment
	 * Create the application.
	 */
	public CompletionScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**@param newGame inputs the gameEnvironment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulations!");
		lblNewLabel.setFont(new Font("Ravie", Font.BOLD, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(125, 57, 234, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea txtrYouveCompletedMidnight = new JTextArea();
		txtrYouveCompletedMidnight.setForeground(Color.BLACK);
		txtrYouveCompletedMidnight.setBackground(Color.RED);
		txtrYouveCompletedMidnight.setFont(new Font("Ravie", Font.PLAIN, 11));
		txtrYouveCompletedMidnight.setText("You've completed:\n \nMythical Monsters: Into the Darkness");
		txtrYouveCompletedMidnight.setBounds(83, 117, 291, 49);
		frame.getContentPane().add(txtrYouveCompletedMidnight);
		
		JLabel goldLabel = new JLabel("Total gold earned: " + (newGame.getGold() - 60) + "g");
		goldLabel.setFont(new Font("Ravie", Font.PLAIN, 11));
		goldLabel.setBounds(114, 177, 176, 14);
		frame.getContentPane().add(goldLabel);
		
		JLabel pointsLabel = new JLabel("Total points earned: " + newGame.getPoints());
		pointsLabel.setFont(new Font("Ravie", Font.PLAIN, 11));
		pointsLabel.setBounds(114, 202, 305, 14);
		frame.getContentPane().add(pointsLabel);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(319, 11, 89, 23);
		frame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 

		}
		});
		
		JButton tryAgainButton = new JButton("Play again");
		tryAgainButton.setBounds(159, 227, 106, 23);
		frame.getContentPane().add(tryAgainButton);
		
		JButton finalStats = new JButton("View Final Team Stats");
		finalStats.setBounds(10, 11, 168, 23);
		frame.getContentPane().add(finalStats);
		finalStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinalTeam.main(newGame);
				frame.dispose();

		}
		});
		tryAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameSetName.main(null); 
				frame.dispose();

		}
		});
	}

}
