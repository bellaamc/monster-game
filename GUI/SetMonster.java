package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

import projectOne.GameEnvironment;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

 /**
  * 
  * SetMonster creates a window allowing you to choose the monster you would like to use
  *
  */
public class SetMonster {

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
					SetMonster window = new SetMonster(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * SetMonster Create the application.
	 * @param newGame passes the game setup into the window
	 * 
	 */
	public SetMonster(GameEnvironment newGame) {
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
		
		JLabel monsterLabel = new JLabel("Choose your monster:");
		monsterLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		monsterLabel.setBounds(127, 21, 183, 22);
		frame.getContentPane().add(monsterLabel);
		
		JLabel goldLabel = new JLabel("Gold available: "+newGame.getGold()+"g");
		goldLabel.setBounds(5, 11,200, 32);
		frame.getContentPane().add(goldLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 32, 52, 22);
		frame.getContentPane().add(textArea);
		
		JTextArea monsterChosen = new JTextArea();
		monsterChosen.setBackground(SystemColor.menu);
		monsterChosen.setBounds(25, 49, 382, 22);
		frame.getContentPane().add(monsterChosen);
		
		JButton vampireButton = new JButton("Vampire");
		vampireButton.setBounds(25, 82, 89, 23);
		frame.getContentPane().add(vampireButton);
		vampireButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vampireButton.setForeground(Color.RED);
			monsterChosen.setText(newGame.buyMonster(newGame.getVampire()));
		}
	});
		
		JButton bansheeButton = new JButton("Banshee");
		bansheeButton.setBounds(169, 82, 89, 23);
		frame.getContentPane().add(bansheeButton);
		bansheeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bansheeButton.setForeground(Color.RED);
				monsterChosen.setText(newGame.buyMonster(newGame.getBanshee()));
			}
		});
		
		JButton goblinButton = new JButton("Goblin");
		goblinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goblinButton.setForeground(Color.RED);
				monsterChosen.setText(newGame.buyMonster(newGame.getGoblin()));
			}
		});
		goblinButton.setBounds(318, 82, 89, 23);
		frame.getContentPane().add(goblinButton);
		
		JButton werewolfButton = new JButton("Werewolf");
		werewolfButton.setBounds(25, 168, 89, 23);
		frame.getContentPane().add(werewolfButton);
		werewolfButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				werewolfButton.setForeground(Color.RED);
				monsterChosen.setText(newGame.buyMonster(newGame.getWerewolf()));
			}
		});
		
		JButton dragonButton = new JButton("Dragon");
		dragonButton.setBounds(169, 168, 89, 23);
		frame.getContentPane().add(dragonButton);
		dragonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dragonButton.setForeground(Color.RED);
				monsterChosen.setText(newGame.buyMonster(newGame.getDragon()));
			}
		});
		
		JButton elfButton = new JButton("Elf");
		elfButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elfButton.setForeground(Color.RED);
				monsterChosen.setText(newGame.buyMonster(newGame.getElf()));
			}
		});
		elfButton.setBounds(318, 168, 89, 23);
		frame.getContentPane().add(elfButton);
		
		JTextArea vampireDescription = new JTextArea();
		vampireDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		vampireDescription.setText("Max Health: "+newGame.getVampire().getMaxHealth()+"\n"
				+"Damage: "+newGame.getVampire().getDamage()+"\nSpeed: "+newGame.getVampire().getSpeed()+"\n"
				+"Price: "+newGame.getVampire().getItemPrice()+"g\n"+newGame.getVampire().getItemName()+" is "
				+newGame.getVampire().getRarity());
		vampireDescription.setBackground(SystemColor.menu);
		vampireDescription.setBounds(25, 110, 107, 59);
		frame.getContentPane().add(vampireDescription);
		
		JTextArea bansheeDescription = new JTextArea();
		bansheeDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		bansheeDescription.setText("Max Health: "+newGame.getBanshee().getMaxHealth()+"\n"
				+"Damage: "+newGame.getBanshee().getDamage()+"\nSpeed: "+newGame.getBanshee().getSpeed()+"\n"
				+"Price: "+newGame.getBanshee().getItemPrice()+"g\n"+newGame.getBanshee().getItemName()+" is "
				+newGame.getBanshee().getRarity());
		bansheeDescription.setBackground(SystemColor.menu);
		bansheeDescription.setBounds(169, 110, 117, 59);
		frame.getContentPane().add(bansheeDescription);
		
		JTextArea goblinDescription = new JTextArea();
		goblinDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		goblinDescription.setText("Max Health: "+newGame.getGoblin().getMaxHealth()+"\n"
				+"Damage: "+newGame.getGoblin().getDamage()+"\nSpeed: "+newGame.getGoblin().getSpeed()+"\n"
				+"Price: "+newGame.getGoblin().getItemPrice()+"g\n"+newGame.getGoblin().getItemName()+" is "
				+newGame.getGoblin().getRarity());
		goblinDescription.setBackground(SystemColor.menu);
		goblinDescription.setBounds(318, 110, 106, 59);
		frame.getContentPane().add(goblinDescription);
		
		JTextArea werewolfDescription = new JTextArea();
		werewolfDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		werewolfDescription.setText("Max Health: "+newGame.getWerewolf().getMaxHealth()+"\n"
				+"Damage: "+newGame.getWerewolf().getDamage()+"\nSpeed: "+newGame.getWerewolf().getSpeed()+"\n"
				+"Price: "+newGame.getWerewolf().getItemPrice()+"g\n"+newGame.getWerewolf().getItemName()+" is "
				+newGame.getWerewolf().getRarity());
		werewolfDescription.setBackground(SystemColor.menu);
		werewolfDescription.setBounds(25, 196, 117, 54);
		frame.getContentPane().add(werewolfDescription);
		
		JTextArea dragonDescription = new JTextArea();
		dragonDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		dragonDescription.setText("Max Health: "+newGame.getDragon().getMaxHealth()+"\n"
				+"Damage: "+newGame.getDragon().getDamage()+"\nSpeed: "+newGame.getDragon().getSpeed()+"\n"
				+"Price: "+newGame.getDragon().getItemPrice()+"g\n"+newGame.getDragon().getItemName()+" is "
				+newGame.getDragon().getRarity());
		dragonDescription.setBackground(SystemColor.menu);
		dragonDescription.setBounds(169, 196, 117, 54);
		dragonDescription.setEditable(false);
		frame.getContentPane().add(dragonDescription);
		
		JTextArea elfDescription = new JTextArea();
		elfDescription.setFont(new Font("Monospaced", Font.PLAIN, 8));
		elfDescription.setText("Max Health: "+newGame.getElf().getMaxHealth()+"\n"
				+"Damage: "+newGame.getElf().getDamage()+"\nSpeed: "+newGame.getElf().getSpeed()+"\n"
				+"Price: "+newGame.getElf().getItemPrice()+"g\n"+newGame.getElf().getItemName()+" is "
				+newGame.getElf().getRarity());
		elfDescription.setBackground(SystemColor.menu);
		elfDescription.setBounds(318, 196, 106, 54);
		frame.getContentPane().add(elfDescription);
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(335, 20, 89, 23);
		frame.getContentPane().add(continueButton);
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DifficultyChoice.main(newGame);
				frame.dispose();

			}
		});
		
		
	}
}
