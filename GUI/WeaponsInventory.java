package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import projectOne.GameEnvironment;
import projectOne.Item;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * 
 * WeaponsInventory The class that generates the inventory of weapons for the monster to use
 *
 */
public class WeaponsInventory {

	/** set ups the main frame */
	private JFrame frame;
	/**
	 * main Launch the application.
	 * @param newGame inputs game environment
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeaponsInventory window = new WeaponsInventory(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * WeaponsInventory Create the application.
	 * @param newGame passes the setup game environment into the window
	 * 
	 */
	public WeaponsInventory(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame passes the game setup into the window
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List<Item> weapons = newGame.getWeaponList(); 
		
		JLabel weaponInventoryLabel = new JLabel("Weapons Inventory");
		weaponInventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		weaponInventoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		weaponInventoryLabel.setBounds(216, 25, 144, 19);
		frame.getContentPane().add(weaponInventoryLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(461, 11, 89, 23);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.main(newGame);
				frame.dispose(); 
		}
		});
		
		if (weapons.size() > 0 && weapons.get(0).getItemCount() >= 1) {
			JLabel weapon1Label = new JLabel(weapons.get(0).getItemName());
			weapon1Label.setBounds(88, 110, 115, 14);
			frame.getContentPane().add(weapon1Label);
			
			JTextArea textAreaWeapon1 = new JTextArea(weapons.get(0).getPropertyAdjustment() + "\nAvailable: " + weapons.get(0).getItemCount() + "\nSellback Price: " + weapons.get(0).getSellBackPrice()); 
			textAreaWeapon1.setBounds(30, 135, 151, 116);
			frame.getContentPane().add(textAreaWeapon1);
			textAreaWeapon1.setEditable(false);
			
			JButton weapon1Button = new JButton("Assign Weapon");
			weapon1Button.setBounds(40, 262, 124, 23);
			frame.getContentPane().add(weapon1Button);
			weapon1Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newGame.setSelectedWeapon(weapons.get(0)); 
					AssignItemToMonster.main(newGame);
					frame.dispose(); 
			}
			});
			
			JButton sellWeapon1 = new JButton("Sell Weapon");
			sellWeapon1.setBounds(50, 296, 114, 23);
			frame.getContentPane().add(sellWeapon1);
			sellWeapon1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newGame.sellItem(weapons.get(0));
					WeaponsInventory.main(newGame);
					frame.dispose();

				}
			});
			
			if (weapons.size() > 1 && weapons.get(1).getItemCount() >= 1) {
				JLabel weapon2Label = new JLabel(weapons.get(1).getItemName());
				weapon2Label.setBounds(258, 110, 115, 14);
				frame.getContentPane().add(weapon2Label);
				
				JTextArea textAreaWeapon2 = new JTextArea(weapons.get(1).getPropertyAdjustment() + "\nAvailable: " + weapons.get(1).getItemCount() + "\nSellback Price: " + weapons.get(1).getSellBackPrice()); 
				textAreaWeapon2.setBounds(209, 135, 151, 116);
				frame.getContentPane().add(textAreaWeapon2);
				
				JButton weapon2Button = new JButton("Assign Weapon");
				weapon2Button.setBounds(216, 262, 124, 23);
				frame.getContentPane().add(weapon2Button);
				weapon2Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newGame.setSelectedWeapon(weapons.get(1)); 
						AssignItemToMonster.main(newGame);
						frame.dispose(); 
					}
				});
				
				JButton sellWeapon2 = new JButton("Sell Weapon");
				sellWeapon2.setBounds(226, 296, 114, 23);
				frame.getContentPane().add(sellWeapon2);
				sellWeapon2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newGame.sellItem(weapons.get(1));
						WeaponsInventory.main(newGame);
						frame.dispose();

					}
				});
				
				if (weapons.size() > 2 && weapons.get(2).getItemCount() >= 1) {
					JLabel weapon3Label = new JLabel(weapons.get(2).getItemName());
					weapon3Label.setBounds(420, 110, 115, 14);
					frame.getContentPane().add(weapon3Label);
					
					JTextArea textAreaWeapon3 = new JTextArea(weapons.get(2).getPropertyAdjustment() + "\nAvailable: " + weapons.get(2).getItemCount() + "\nSellback Price: " + weapons.get(2).getSellBackPrice()); 
					textAreaWeapon3.setBounds(384, 135, 151, 116);
					frame.getContentPane().add(textAreaWeapon3);
					
					JButton weapon3Button = new JButton("Assign Weapon");
					weapon3Button.setBounds(394, 262, 124, 23);
					frame.getContentPane().add(weapon3Button);
					weapon3Button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							newGame.setSelectedWeapon(weapons.get(2)); 
							AssignItemToMonster.main(newGame);
							frame.dispose(); 
						}
					});
					
					JButton sellWeapon3 = new JButton("Sell Weapon");
					sellWeapon3.setBounds(404, 296, 114, 23);
					frame.getContentPane().add(sellWeapon3);
					sellWeapon3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							newGame.sellItem(weapons.get(2));
							WeaponsInventory.main(newGame);
							frame.dispose();
						}
					});
				}
					
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		

		
	
		

	


}
