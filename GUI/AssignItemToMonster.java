package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import projectOne.GameEnvironment;
import projectOne.Item;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * AssignItemToMonster assigns items to monsters
 *
 */
public class AssignItemToMonster {

	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame passes newGame in
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignItemToMonster window = new AssignItemToMonster(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * AssignItemToMonster Create the application.
	 * @param newGame inputs the game environment
	 */
	public AssignItemToMonster(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {


		frame = new JFrame();
		frame.setBounds(100, 100, 717, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel monsterInventoryLabel = new JLabel("Monster Inventory");
		monsterInventoryLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		monsterInventoryLabel.setBounds(288, 11, 161, 26);
		frame.getContentPane().add(monsterInventoryLabel);
		
		
		
		if (newGame.getMonsterInventory().size() > 0) { 
			JButton monster1 = new JButton(newGame.getMonsterInventory().get(0).getItemName());
			monster1.setFont(new Font("Tahoma", Font.BOLD, 13));
			monster1.setBounds(36, 48, 100, 26);
			frame.getContentPane().add(monster1);
			monster1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Item weapon = newGame.getSelectedWeapon() ;
					newGame.changeProperty(newGame.getMonsterInventory().get(0), weapon);
					WeaponsInventory.main(newGame);
					frame.dispose(); 
			}
			});
			
			
			
			if (newGame.getMonsterInventory().size() > 1) {
				JButton monster2 = new JButton(newGame.getMonsterInventory().get(1).getItemName());
				monster2.setFont(new Font("Tahoma", Font.BOLD, 13));
				monster2.setBounds(232, 48, 100, 26);
				frame.getContentPane().add(monster2);
				monster2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Item weapon = newGame.getSelectedWeapon() ;
						newGame.changeProperty(newGame.getMonsterInventory().get(1), weapon);
						WeaponsInventory.main(newGame);
						frame.dispose(); 
				}
				});
				
				
				
				if (newGame.getMonsterInventory().size() > 2) {
					JButton monster3 = new JButton(newGame.getMonsterInventory().get(2).getItemName());
					monster3.setFont(new Font("Tahoma", Font.BOLD, 13));
					monster3.setBounds(402, 48, 100, 26);
					frame.getContentPane().add(monster3);
					monster3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Item weapon = newGame.getSelectedWeapon() ;
							newGame.changeProperty(newGame.getMonsterInventory().get(2), weapon);
							WeaponsInventory.main(newGame);
							frame.dispose(); 
					}
					});
					
					
					
					
					
					
					if (newGame.getMonsterInventory().size() > 3) {
						JButton monster4 = new JButton(newGame.getMonsterInventory().get(3).getItemName());
						monster4.setFont(new Font("Tahoma", Font.BOLD, 13));
						monster4.setBounds(573, 48, 105, 26);
						frame.getContentPane().add(monster4);
						monster4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Item weapon = newGame.getSelectedWeapon() ;
								newGame.changeProperty(newGame.getMonsterInventory().get(3), weapon);
								WeaponsInventory.main(newGame);
								frame.dispose(); 
						}
						});
						
						
					}
					
				}
			}
		}
		
			
		
	}
}
