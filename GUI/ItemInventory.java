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
 * displays access to weapons inventory and edible items inventory
 *
 */
public class ItemInventory {

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
					ItemInventory window = new ItemInventory(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ItemInventory Create the application.

	 * @param newGame inputs the original game environment
	 * 	 
	 */
	public ItemInventory(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel inventoryLabel = new JLabel("Item Inventory");
		inventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inventoryLabel.setBounds(237, 30, 205, 27);
		frame.getContentPane().add(inventoryLabel);
		
		JButton weaponsButton = new JButton("Weapons");
		weaponsButton.setBounds(87, 146, 154, 70);
		frame.getContentPane().add(weaponsButton);
		weaponsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeaponsInventory.main(newGame);
				frame.dispose(); 
		}
		});
		
		JButton ediblesButton = new JButton("Edibles");
		ediblesButton.setBounds(352, 146, 138, 70);
		frame.getContentPane().add(ediblesButton);
		ediblesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EdiblesInventory.main(newGame);
				frame.dispose(); 
		}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(452, 11, 89, 23);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.main(newGame);
				frame.dispose(); 
		}
		});
	}

}
