package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import projectOne.GameEnvironment;

import javax.swing.JSlider;
import javax.swing.JLabel;

/**
 * 
 * GameSetName allows player to choose their name
 *
 */
public class GameSetName{

	/**
	 * sets up the basic frame
	 */
	private JFrame frame;

	/**
	 * main Launch the application.
	 *@param args test code
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameSetName window = new GameSetName();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * GameSetName Create the application.
	 * 
	 */
	public GameSetName() {
		
		initialize();
	}

	/**
	 * @param newGame inputs the original game environment
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GameEnvironment newGame = new GameEnvironment();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea characterOutput = new JTextArea();
		characterOutput.setBackground(SystemColor.menu);
		characterOutput.setBounds(102, 92, 348, 79);
		frame.getContentPane().add(characterOutput);
		
		JTextPane nameInput = new JTextPane();
		nameInput.setBounds(102, 61, 219, 20);
		frame.getContentPane().add(nameInput);
		
		JButton nameSetButton = new JButton("Set my name!");
		nameSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameSetButton.setBounds(331, 61, 119, 23);
		frame.getContentPane().add(nameSetButton);
		
		nameSetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String characterString = nameInput.getText();
				characterOutput.setText(newGame.setCharacterName(characterString));
				}
			
			
		});
		
		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(446, 316, 89, 23);
		frame.getContentPane().add(continueButton);
		
		JSlider daySelector = new JSlider(5,15);
		daySelector.setBounds(185, 225, 200, 79);
		frame.getContentPane().add(daySelector);
		
		daySelector.setMajorTickSpacing(1); 
		daySelector.setPaintTicks(true);
		daySelector.setPaintLabels(true);
		daySelector.setPaintTrack(true);
		
		JTextPane dayText = new JTextPane();
		dayText.setBackground(SystemColor.controlHighlight);
		dayText.setText("How many days would you like the game to last?");
		dayText.setBounds(163, 194, 239, 20);
		frame.getContentPane().add(dayText);
		
		JLabel nameLabel = new JLabel("Enter your name:");
		nameLabel.setBounds(159, 36, 119, 14);
		frame.getContentPane().add(nameLabel);
		
		daySelector.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			newGame.chooseGameLength(daySelector.getValue());

			
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetMonster.main(newGame);
				frame.dispose();
			}
		});
		
		
		}
		});
	}
}

