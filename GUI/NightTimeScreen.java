package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import projectOne.GameEnvironment;
import projectOne.RandomEvent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * NightTimeScreen is instantiated after a battle is won to recharge a monster's health
 *
 */
public class NightTimeScreen {

	/** setup basic frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame passes the game setup into the window
	 * 
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NightTimeScreen window = new NightTimeScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * NightTimeScreen Create the application.
	 * @param newGame passes the game setup into the window
	 * 
	 */
	public NightTimeScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame passes the game setup into the window
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		newGame.sleepingMonsters();
		
		RandomEvent randomEvent = new RandomEvent(); 
		String string = randomEvent.generateRandom(newGame); 
		JLabel randomLabel = new JLabel(string);
		randomLabel.setBounds(24, 216, 286, 34);
		frame.getContentPane().add(randomLabel);
		
		JLabel lblNewLabel = new JLabel("Your monsters are sleeping");
		lblNewLabel.setBounds(145, 92, 173, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nighttime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(169, 36, 138, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton nextDayButton = new JButton("Next Day");
		nextDayButton.setBounds(320, 227, 89, 23);
		frame.getContentPane().add(nextDayButton);
		
		if (newGame.checkPoints() == "Level up") {
			JButton levelUpButton = new JButton("Level Up");
			levelUpButton.setBounds(24, 21, 89, 23);
			frame.getContentPane().add(levelUpButton);
			levelUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LevelUpMonster.main(newGame);
					frame.dispose();

			}
			});
			

		}
		
		
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame.incrementCurrentDay(); 
				ChooseBattleScreen.main(newGame);
				frame.dispose();

		}
		});

	}

}
