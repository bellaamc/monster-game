package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
/**
 * 
 * launches the game 
 *
 */
public class LaunchScreen {

	private JFrame frame;

	/**
	 * main Launch the application.
	 * @param args runs code
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchScreen window = new LaunchScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaunchScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 581, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mythical Monsters: Into the Darkness");
		lblNewLabel.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 64, 485, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JButton playButton = new JButton("Play!");
		playButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		playButton.setForeground(Color.RED);
		playButton.setBackground(Color.BLACK);
		playButton.setBounds(243, 266, 89, 23);
		frame.getContentPane().add(playButton);
		
		JLabel vampire = new JLabel("");
		vampire.setIcon(new ImageIcon(LaunchScreen.class.getResource("/images/1164493_30.png")));
		vampire.setBounds(61, 137, 95, 126);
		frame.getContentPane().add(vampire);
		
		JLabel cyclops = new JLabel("");
		cyclops.setIcon(new ImageIcon(LaunchScreen.class.getResource("/images/80518_1_15.gif")));
		cyclops.setBounds(239, 149, 110, 92);
		frame.getContentPane().add(cyclops);
		
		JLabel elf = new JLabel("New label");
		elf.setIcon(new ImageIcon(LaunchScreen.class.getResource("/images/elf.png")));
		elf.setBounds(390, 116, 125, 168);
		frame.getContentPane().add(elf);
		
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameSetName.main(null); 
				frame.dispose();

		}
		});
		
	}

}
