package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import projectOne.GameEnvironment;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * LossScreen generates when a user loses the game
 *
 */
public class LossScreen {

	/** generates the setup frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame inputs gameEnvironment
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LossScreen window = new LossScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * LossScreen Create the application.
	 * @param newGame passes the game setup into the window
	 * 
	 */
	public LossScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame passes the game setup into the window
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnYouLose = new JTextPane();
		txtpnYouLose.setBackground(SystemColor.control);
		txtpnYouLose.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtpnYouLose.setText("You Lose!");
		txtpnYouLose.setBounds(153, 60, 102, 36);
		frame.getContentPane().add(txtpnYouLose);
		txtpnYouLose.setEditable(false); 
		
		if (newGame.getGold() < 50) { 
			JTextArea txtrUnfortunatelyYouHave = new JTextArea();
			txtrUnfortunatelyYouHave.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
			txtrUnfortunatelyYouHave.setText("Unfortunately, you have run out of monsters and money! \nTry again by clicking the button below.");
			txtrUnfortunatelyYouHave.setBounds(39, 107, 371, 45);
			frame.getContentPane().add(txtrUnfortunatelyYouHave);
			
			JButton tryAgainButton = new JButton("Try again");
			tryAgainButton.setBounds(166, 163, 89, 23);
			frame.getContentPane().add(tryAgainButton);
			tryAgainButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GameSetName.main(null); 
					frame.dispose();
	
			}
			});
		
		
			JButton exitButton = new JButton("Exit");
			exitButton.setBounds(321, 21, 89, 23);
			frame.getContentPane().add(exitButton);
			exitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0); 
	
			}
			});
		
			JLabel goldLabel = new JLabel("Total gold earned: " + (newGame.getGold() - 60) + "g");
			goldLabel.setBounds(106, 218, 133, 14);
			frame.getContentPane().add(goldLabel);
			
			JLabel pointsLabel = new JLabel("Total points earned: " + newGame.getPoints());
			pointsLabel.setBounds(105, 244, 305, 14);
			frame.getContentPane().add(pointsLabel);
		}
		
		else if (newGame.getGold() >= 50) {
			JTextArea txtrUnfortunatelyYouHave = new JTextArea();
			txtrUnfortunatelyYouHave.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
			txtrUnfortunatelyYouHave.setText("Unfortunately, you have run out of monsters. \nBuy another one at the shop to fight again!");
			txtrUnfortunatelyYouHave.setBounds(39, 107, 371, 45);
			frame.getContentPane().add(txtrUnfortunatelyYouHave);
			
			
			JButton shopButton = new JButton("Shop");
			shopButton.setBounds(166, 163, 89, 23);
			frame.getContentPane().add(shopButton);
			shopButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShopScreen.main(newGame); 
					frame.dispose();
	
			}
			});
			
			
		}
	
	}
}

