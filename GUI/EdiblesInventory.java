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

import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * 
 * EdiblesInventory shows the user the food items they have
 *
 */
public class EdiblesInventory {

	/** sets up the main frame */
	private JFrame frame;
	/**
	 * main runs window
	 * @param newGame inputs game environment
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdiblesInventory window = new EdiblesInventory(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * EdiblesInventory generates object
	 * @param newGame inputs the gameEnvironment
	 * Create the application.
	 */
	public EdiblesInventory(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * initialize generates window
	 * @param newGame inputs the gameEnvironments
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List<Item> edibles = newGame.getEdiblesList(); 
		
		JLabel EdiblesInventoryLabel = new JLabel("Food & Potions Inventory");
		EdiblesInventoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EdiblesInventoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		EdiblesInventoryLabel.setBounds(163, 25, 203, 19);
		frame.getContentPane().add(EdiblesInventoryLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(461, 11, 89, 23);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory.main(newGame);
				frame.dispose(); 
		}
		});
		
		if (edibles.size() > 0 && edibles.get(0).getItemCount() >= 1) {
			JLabel edible11Label = new JLabel(edibles.get(0).getItemName());
			edible11Label.setBounds(88, 110, 115, 14);
			frame.getContentPane().add(edible11Label);
			
			JTextArea textAreaEdible1 = new JTextArea(edibles.get(0).propertyAdjustment() + "\nAvailable: " + edibles.get(0).getItemCount()); 
			textAreaEdible1.setBounds(30, 135, 151, 116);
			frame.getContentPane().add(textAreaEdible1);
			textAreaEdible1.setEditable(false);
			
			JButton edible1Button = new JButton("Use");
			edible1Button.setBounds(40, 262, 124, 23);
			frame.getContentPane().add(edible1Button);
			edible1Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newGame.setSelectedEdible(edibles.get(0)); 
					AssignEdibleToMonster.main(newGame);
					frame.dispose(); 
			}
			});
			
			
			
			if (edibles.size() > 1 && edibles.get(1).getItemCount() >= 1) {
				JLabel edible2Label = new JLabel(edibles.get(1).getItemName());
				edible2Label.setBounds(258, 110, 115, 14);
				frame.getContentPane().add(edible2Label);
				
				JTextArea textAreaEdible2 = new JTextArea(edibles.get(1).propertyAdjustment() + "\nAvailable: " + edibles.get(1).getItemCount()); 
				textAreaEdible2.setBounds(209, 135, 151, 116);
				frame.getContentPane().add(textAreaEdible2);
				
				JButton edible2Button = new JButton("Use");
				edible2Button.setBounds(216, 262, 124, 23);
				frame.getContentPane().add(edible2Button);
				edible2Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						newGame.setSelectedEdible(edibles.get(1)); 
						AssignEdibleToMonster.main(newGame);
						frame.dispose(); 
				}
				});
				
				
				if (edibles.size() > 2 && edibles.get(2).getItemCount() >= 1) {
					JLabel edible3Label = new JLabel(edibles.get(2).getItemName());
					edible3Label.setBounds(420, 110, 115, 14);
					frame.getContentPane().add(edible3Label);
					
					JTextArea edibleWeapon3 = new JTextArea(edibles.get(2).propertyAdjustment() + "\nAvailable: " + edibles.get(2).getItemCount()); 
					edibleWeapon3.setBounds(384, 135, 151, 116);
					frame.getContentPane().add(edibleWeapon3);
					
					JButton edible3Button = new JButton("Use");
					edible3Button.setBounds(394, 262, 124, 23);
					frame.getContentPane().add(edible3Button);
					edible3Button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							newGame.setSelectedWeapon(edibles.get(2)); 
							AssignItemToMonster.main(newGame);
							frame.dispose(); 
						}
					});
					
	
				}
					
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		

		
	
		

	


}
