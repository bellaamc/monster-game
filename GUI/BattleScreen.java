package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;

import projectOne.Battle;
import projectOne.GameEnvironment;
import projectOne.Monster;

import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * 
 * BattleScreen creates a window with enemies fighting
 *
 */
public class BattleScreen {

	/** sets up the basic frame */
	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param newGame inputs the game environment
	 * 
	 */
	public static void main(GameEnvironment newGame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * BattleScreen Create the application.
	 * @param newGame inputs the gameEnvironment
	 * 
	 */
	public BattleScreen(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame inputs the gameEnvironment
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		Battle battle = newGame.getBattle();
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton fightButton = new JButton("Fight!");
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		fightButton.setBounds(229, 156, 89, 23);
		frame.getContentPane().add(fightButton);
		
		JTextPane txtpnCurrentMonster = new JTextPane();
		txtpnCurrentMonster.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnCurrentMonster.setBackground(SystemColor.control);
		txtpnCurrentMonster.setText("My monster: " + newGame.getCurrentFighter().getItemName());
		txtpnCurrentMonster.setBounds(235, 11, 172, 20);
		frame.getContentPane().add(txtpnCurrentMonster);
		txtpnCurrentMonster.setEditable(false);
		
		JTextPane txtpnCurrentEnemy = new JTextPane();
		txtpnCurrentEnemy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtpnCurrentEnemy.setBackground(SystemColor.control);
		txtpnCurrentEnemy.setText("Opponent: " + battle.getCurrentEnemy().getItemName());
		txtpnCurrentEnemy.setBounds(235, 190, 184, 20);
		frame.getContentPane().add(txtpnCurrentEnemy);
		txtpnCurrentEnemy.setEditable(false); 
		
		JPanel monsterPanel = new JPanel();
		monsterPanel.setBounds(38, 56, 121, 80);
		frame.getContentPane().add(monsterPanel);
		
		JPanel enemyPanel = new JPanel();
		enemyPanel.setBounds(38, 235, 121, 80);
		frame.getContentPane().add(enemyPanel);
		
		JTextPane monsterText = new JTextPane();
		monsterText.setBackground(SystemColor.control);
		monsterText.setBounds(235, 30, 152, 127);
		frame.getContentPane().add(monsterText);
		
		
		JTextPane enemyText = new JTextPane();
		enemyText.setBackground(SystemColor.control);
		enemyText.setBounds(235, 209, 138, 127);
		frame.getContentPane().add(enemyText);
		
		JTextPane outcomeText = new JTextPane();
		outcomeText.setBackground(SystemColor.control);
		outcomeText.setBounds(38, 175, 121, 20);
		frame.getContentPane().add(outcomeText);
		outcomeText.setText("Fight your monsters");
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(407, 41, 111, 23);
		frame.getContentPane().add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String outcome = battle.getOutcome();
				if (outcome == "You won!" && newGame.getCurrentDay() < newGame.getGameLength()) {
					newGame.battleSuccess();
					WinScreen.main(newGame);
					frame.dispose();
					}
				
				else if (outcome == "You won!" && newGame.getCurrentDay() == newGame.getGameLength()) {
					newGame.battleSuccess(); 
					CompletionScreen.main(newGame);
					frame.dispose(); 
				}
				
				 else {
					LossScreen.main(newGame);
					frame.dispose();
				}
			}
		});
		int currentDay = newGame.getCurrentDay();
		if (currentDay == 6 || currentDay == 12) {
			newGame.increaseDifficulty();
		}
	
		Monster currentFighter = newGame.getCurrentFighter();

		monsterText.setText("Level: " + newGame.getCurrentFighter().getLevel() + "\nCurrent Health: "+ newGame.getCurrentFighter().getCurrentHealth() + "\nMax Health: "+newGame.getCurrentFighter().getMaxHealth()+"\n"
				+"Damage: "+newGame.getCurrentFighter().getDamage()+"\nSpeed: "+newGame.getCurrentFighter().getSpeed()+"\n"
				+newGame.getCurrentFighter().getItemName()+" is "
				+newGame.getCurrentFighter().getRarity()+ "\nWeapon: " + newGame.getCurrentFighter().getWeaponName());
		
		Monster currentEnemy = battle.getCurrentEnemy();
		enemyText.setText("Level: " + currentEnemy.getLevel() + "\nCurrent Health: "+ currentEnemy.getCurrentHealth() + "\nMax Health: "+currentEnemy.getMaxHealth()+"\n"
				+"Damage: "+currentEnemy.getDamage()+"\nSpeed: "+currentEnemy.getSpeed()+"\n"
				+currentEnemy.getItemName()+" is "
				+currentEnemy.getRarity()+ "\nWeapon: " + currentEnemy.getWeaponName()); 
		

		
		JLabel dayLabel = new JLabel("New label");
		dayLabel.setBounds(20, 11, 121, 14);
		frame.getContentPane().add(dayLabel);
		dayLabel.setText("Day "+newGame.getCurrentDay());
		
		
		fightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battle.roundWinner(currentFighter,currentEnemy);
				outcomeText.setText(battle.getOutcome());

			}
		
		});
			
			
		}
		
	}
