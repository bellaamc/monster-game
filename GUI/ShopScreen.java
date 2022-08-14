package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import projectOne.GameEnvironment;

/**
 * 
 * ShopScreen displays the shop with options to buy monsters or items
 *
 */
public class ShopScreen {

	/** generates the main frame */
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
					ShopScreen window = new ShopScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ShopScreen Create the application.
	 * @param newGame passes the game setup into the window
	 * 
	 */
	public ShopScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ShopForMonster = new JButton("Shop for Monsters");
		ShopForMonster.setBounds(51, 97, 145, 78);
		frame.getContentPane().add(ShopForMonster);
		
		JButton ShopForItems = new JButton("Shop for Items");
		ShopForItems.setBounds(244, 97, 145, 78);
		frame.getContentPane().add(ShopForItems);
	
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(backButton);
		
		JLabel goldLabel = new JLabel("Gold available: "+newGame.getGold()+"g");
		goldLabel.setBounds(27, 13, 200, 32);
		frame.getContentPane().add(goldLabel);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseBattleScreen.main(newGame);
				frame.dispose(); 
		}
		}); 
		
		ShopForMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopForMonsters.main(newGame);
				frame.dispose();
			}
		});
		
		ShopForItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopForItem.main(newGame);
				frame.dispose();
			}
		}); 
	}
}

