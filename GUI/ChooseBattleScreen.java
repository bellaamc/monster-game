package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import projectOne.GameEnvironment;
import projectOne.Monster;

import javax.swing.JLabel;

/**
 * 
 * ChooseBattleScreen allows the user to choose which battle they fight
 *
 */
public class ChooseBattleScreen {

	/** sets up the basic frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame inputs the gameEnvironment
	 * 
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseBattleScreen window = new ChooseBattleScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ChooseBattleScreen Create the application.
	 * @param newGame inputs the gameEnvironment
	 * 
	 */
	public ChooseBattleScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame inputs the gameEnvironment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		List<Monster> battleOptions = newGame.getEnemies();
		Collections.shuffle(battleOptions);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton battleOneButton = new JButton("Battle 1");
		battleOneButton.setBounds(42, 182, 89, 23);
		frame.getContentPane().add(battleOneButton);
		
		battleOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (newGame.getCurrentDay() <7) {
					newGame.getBattle().chooseEnemy(battleOptions.get(0));
				}
			}
		});
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 103, 89, 68);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(166, 103, 89, 68);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(291, 103, 89, 68);
		frame.getContentPane().add(panel_2);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(continueButton);
		
		JLabel lblNewLabel = new JLabel("Choose your battle:");
		lblNewLabel.setBounds(166, 45, 115, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton ShopButton = new JButton("Shop");
		ShopButton.setBounds(10, 11, 101, 40);
		frame.getContentPane().add(ShopButton);
		ShopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopScreen.main(newGame);
				frame.dispose();
			}
		}); 
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(323, 11, 101, 40);
		frame.getContentPane().add(btnInventory);
		
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.main(newGame);
				frame.dispose(); 
			}
		});
		
		
		
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleScreen.main(newGame);
				frame.dispose(); 
			}
		});
		
		JLabel battleOneLabel = new JLabel(battleOptions.get(0).getItemName());
		battleOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		battleOneLabel.setBounds(42, 78, 89, 14);
		frame.getContentPane().add(battleOneLabel);
		
		if (battleOptions.size() > 1) {
			JLabel battleTwoLabel = new JLabel(battleOptions.get(1).getItemName());
			battleTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			battleTwoLabel.setBounds(166, 78, 89, 14);
			frame.getContentPane().add(battleTwoLabel);
			
			JButton battleTwoButton = new JButton("Battle 2");
			battleTwoButton.setBounds(166, 182, 89, 23);
			frame.getContentPane().add(battleTwoButton);
			
			battleTwoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (newGame.getCurrentDay() <7) {
						newGame.getBattle().chooseEnemy(battleOptions.get(1));
					}
				}
			});
			
			if (battleOptions.size() > 2) {
				JLabel battleThreeLabel = new JLabel(battleOptions.get(2).getItemName());
				battleThreeLabel.setHorizontalAlignment(SwingConstants.CENTER);
				battleThreeLabel.setBounds(291, 78, 89, 14);
				frame.getContentPane().add(battleThreeLabel);
				
				JButton battleThreeButton = new JButton("Battle 3");
				battleThreeButton.setBounds(291, 182, 89, 23);
				frame.getContentPane().add(battleThreeButton);
				
				battleThreeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (newGame.getCurrentDay() <7) {
							newGame.getBattle().chooseEnemy(battleOptions.get(2));
						}
					}
				});
				
			}
		}
				
			
			
			
		
		
		
		JLabel dayLabel = new JLabel("Day " + newGame.getCurrentDay());
		dayLabel.setBounds(166, 11, 89, 14);
		frame.getContentPane().add(dayLabel);
		
		JButton endGameButton = new JButton("End Game");
		endGameButton.setBounds(10, 227, 121, 23);
		frame.getContentPane().add(endGameButton);
		endGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		
		
		
		
		
		
		
		
	}
}

			

	
		
	

