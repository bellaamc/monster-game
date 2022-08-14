package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import projectOne.GameEnvironment;

import javax.swing.JButton;

/**
 * gives a window view of the inventory
 * 
 *
 */
public class Inventory {
	
	/** sets up the basic frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame inputs the original game environment
	 * 
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inventory Create the application.
	 * @param newGame inputs the original game environment
	 * 
	 */
	public Inventory(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame inputs the original game environment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton monsterButton = new JButton("Monsters");
		monsterButton.setBounds(59, 96, 111, 65);
		frame.getContentPane().add(monsterButton);
		monsterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonsterInventory.main(newGame);
				frame.dispose();
			}
		});
		
		JButton btnItems = new JButton("Items");
		btnItems.setBounds(263, 96, 111, 65);
		frame.getContentPane().add(btnItems);
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemInventory.main(newGame);
				frame.dispose();
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseBattleScreen.main(newGame);
				frame.dispose(); 
		}
		});
	}

}
