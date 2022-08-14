package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import projectOne.GameEnvironment;

import javax.swing.JButton;

/**
 * 
 * FinalTeam gives the final stats of your monster team
 *
 */
public class FinalTeam {

	/** sets up the basic frame */
	private JFrame frame;

	/**
	 * main generates application
	 *@param newGame inputs environment
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalTeam window = new FinalTeam(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * FinalTeam generates final team window
	 * @param newGame inputs the gameEnvironment
	 * Create the application.
	 */
	public FinalTeam(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame inputs the gameEnvironment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel monsterInventoryLabel = new JLabel("Updated Monster Inventory");
		monsterInventoryLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		monsterInventoryLabel.setBounds(288, 11, 194, 26);
		frame.getContentPane().add(monsterInventoryLabel);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(591, 15, 89, 23);
		frame.getContentPane().add(backButton);
	
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompletionScreen.main(newGame);
				frame.dispose(); 
		}
		});
		
		if (newGame.getMonsterInventory().size() > 0) { 
			JLabel monster1Label = new JLabel(newGame.getMonsterInventory().get(0).getItemName());
			monster1Label.setFont(new Font("Tahoma", Font.BOLD, 13));
			monster1Label.setBounds(36, 48, 100, 26);
			frame.getContentPane().add(monster1Label);
			
			JTextArea monster1Description = new JTextArea();
			monster1Description.setFont(new Font("Monospaced", Font.PLAIN, 10));
			monster1Description.setText("Level: " + newGame.getMonsterInventory().get(0).getLevel() + "\nCurrent Health: "+ newGame.getMonsterInventory().get(0).getCurrentHealth() +"\nMax Health: "+newGame.getMonsterInventory().get(0).getMaxHealth()+"\n"
					+"Damage: "+newGame.getMonsterInventory().get(0).getDamage()+"\nSpeed: "+newGame.getMonsterInventory().get(0).getSpeed()+"\n"
					+"Sellback Price: "+newGame.getMonsterInventory().get(0).getSellBackPrice()+"g\n"+newGame.getMonsterInventory().get(0).getItemName()+" is "
					+newGame.getMonsterInventory().get(0).getRarity()+ "\nWeapon: " + newGame.getMonsterInventory().get(0).getWeaponName());
			monster1Description.setBounds(10, 218, 166, 110);
			monster1Description.setEditable(false);
			frame.getContentPane().add(monster1Description);
			
			
		
			
			if (newGame.getMonsterInventory().size() > 1) {
				JLabel monster2Label = new JLabel(newGame.getMonsterInventory().get(1).getItemName());
				monster2Label.setFont(new Font("Tahoma", Font.BOLD, 13));
				monster2Label.setBounds(232, 48, 100, 26);
				frame.getContentPane().add(monster2Label);
				
				JTextArea monster2Description = new JTextArea();
				monster2Description.setFont(new Font("Monospaced", Font.PLAIN, 10));
				monster2Description.setText("Level: " + newGame.getMonsterInventory().get(1).getLevel() + "\nCurrent Health: "+ newGame.getMonsterInventory().get(1).getCurrentHealth() + "\nMax Health: "+newGame.getMonsterInventory().get(1).getMaxHealth()+"\n"
						+"Damage: "+newGame.getMonsterInventory().get(1).getDamage()+"\nSpeed: "+newGame.getMonsterInventory().get(1).getSpeed()+"\n"
						+"Sellback Price: "+newGame.getMonsterInventory().get(1).getSellBackPrice()+"g\n"+newGame.getMonsterInventory().get(1).getItemName()+" is "
						+newGame.getMonsterInventory().get(1).getRarity()+ "\nWeapon: " + newGame.getMonsterInventory().get(1).getWeaponName());
				monster2Description.setBounds(186, 220, 163, 108);
				monster2Description.setEditable(false);
				frame.getContentPane().add(monster2Description);
				
				
					
				
				
				
				if (newGame.getMonsterInventory().size() > 2) {
					JLabel monster3Label = new JLabel(newGame.getMonsterInventory().get(2).getItemName());
					monster3Label.setFont(new Font("Tahoma", Font.BOLD, 13));
					monster3Label.setBounds(402, 48, 100, 26);
					frame.getContentPane().add(monster3Label);
					
					JTextArea monster3Description = new JTextArea();
					monster3Description.setFont(new Font("Monospaced", Font.PLAIN, 10));
					monster3Description.setText("Level: " + newGame.getMonsterInventory().get(2).getLevel() + "\nCurrent Health: "+ newGame.getMonsterInventory().get(2).getCurrentHealth() +"\nMax Health: "+newGame.getMonsterInventory().get(2).getMaxHealth()+"\n"
							+"Damage: "+newGame.getMonsterInventory().get(2).getDamage()+"\nSpeed: "+newGame.getMonsterInventory().get(2).getSpeed()+"\n"
							+"Sellback Price: "+newGame.getMonsterInventory().get(2).getSellBackPrice()+"g\n"+newGame.getMonsterInventory().get(2).getItemName()+" is "
							+newGame.getMonsterInventory().get(1).getRarity()+ "\nWeapon: " + newGame.getMonsterInventory().get(2).getWeaponName());
					monster3Description.setEditable(false);
					monster3Description.setBounds(359, 220, 161, 108);
					frame.getContentPane().add(monster3Description);
					
					
					
					
					
					
					
					
					if (newGame.getMonsterInventory().size() > 3) {
						JLabel monster4Label = new JLabel(newGame.getMonsterInventory().get(3).getItemName());
						monster4Label.setFont(new Font("Tahoma", Font.BOLD, 13));
						monster4Label.setBounds(573, 48, 105, 26);
						frame.getContentPane().add(monster4Label);
						

						JTextArea monster4Description = new JTextArea();
						monster4Description.setFont(new Font("Monospaced", Font.PLAIN, 10));
						monster4Description.setText("Level: " + newGame.getMonsterInventory().get(3).getLevel() + "\nCurrent Health: "+ newGame.getMonsterInventory().get(3).getCurrentHealth() +"\nMax Health: "+newGame.getMonsterInventory().get(3).getMaxHealth()+"\n"
								+"Damage: "+newGame.getMonsterInventory().get(3).getDamage()+"\nSpeed: "+newGame.getMonsterInventory().get(3).getSpeed()+"\n"
								+"Sellback Price: "+newGame.getMonsterInventory().get(3).getSellBackPrice()+"g\n"+newGame.getMonsterInventory().get(3).getItemName()+" is "
								+newGame.getMonsterInventory().get(3).getRarity() + "\nWeapon: " + newGame.getMonsterInventory().get(3).getWeaponName());
						monster4Description.setEditable(false);
						monster4Description.setBounds(530, 220, 161, 108);
						frame.getContentPane().add(monster4Description);
						
						
						
					}
					
				}
			}
		}
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	
		
	
		
		
		
		
	}
}
