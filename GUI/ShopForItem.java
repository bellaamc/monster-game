package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

import projectOne.GameEnvironment;
import projectOne.Item;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

/** 
 * 
 * ShopForItem generates a window for users to purchase items
 *
 */
public class ShopForItem {

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
					ShopForItem window = new ShopForItem(newGame);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ShopForItem  Create the application.
	 * @param newGame passes the game setup into the window
	 *
	 */
	public ShopForItem(GameEnvironment newGame) {
		initialize(newGame);
	}

	/**
	 * @param newGame passes the game setup into the window
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnvironment newGame) {
		List<Item> newList = newGame.getShuffledItemList(); 
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel itemChosen = new JLabel();
		itemChosen.setBounds(37, 68, 427, 32);
		frame.getContentPane().add(itemChosen);
		
		JLabel itemLabel = new JLabel("Select Items to Buy");
		itemLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		itemLabel.setBounds(176, 21, 183, 22);
		frame.getContentPane().add(itemLabel);
		
		JLabel goldLabel = new JLabel("Gold available: "+newGame.getGold()+"g");
		goldLabel.setBounds(27, 13, 200, 32);
		frame.getContentPane().add(goldLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(10, 32, 52, 22);
		frame.getContentPane().add(textArea);
		
		
		JButton item1Button = new JButton(newList.get(0).getItemName());
		item1Button.setBounds(32, 177, 133, 22);
		frame.getContentPane().add(item1Button);
		item1Button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			item1Button.setForeground(Color.RED);
			itemChosen.setText(newGame.buyItem(newList.get(0)));

		}
	});
		
		JButton item2Button = new JButton(newList.get(1).getItemName());
		item2Button.setBounds(214, 177, 133, 22);
		frame.getContentPane().add(item2Button);
		item2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item2Button.setForeground(Color.RED);
				itemChosen.setText(newGame.buyItem(newList.get(1)));

			}
		});
		
		JButton item3Button = new JButton(newList.get(2).getItemName());
		item3Button.setBounds(402, 177, 133, 22);
		frame.getContentPane().add(item3Button);
		item3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item3Button.setForeground(Color.RED);
				itemChosen.setText(newGame.buyItem(newList.get(2)));

			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(384, 20, 89, 23);
		frame.getContentPane().add(backButton);
		
		
		JLabel item1Price = new JLabel();
		item1Price.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item1Price.setText("Price: "+newList.get(0).getItemPrice() +"g"); 
		item1Price.setBackground(SystemColor.menu);
		item1Price.setBounds(42, 210, 123, 22);
		frame.getContentPane().add(item1Price);
		
		JLabel item1Type = new JLabel();
		item1Type.setText("Type: " + newList.get(0).getItemType());
		item1Type.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item1Type.setBackground(SystemColor.menu);
		item1Type.setBounds(42, 240, 172, 22);
		frame.getContentPane().add(item1Type);
		
		JLabel item1Effects = new JLabel();
		item1Effects.setText(newList.get(0).propertyAdjustment());
		item1Effects.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item1Effects.setBackground(SystemColor.menu);
		item1Effects.setBounds(42, 273, 149, 22);
		frame.getContentPane().add(item1Effects);
		
		JLabel item2Price = new JLabel();
		item2Price.setText("Price: "+newList.get(1).getItemPrice() +"g"); 
		item2Price.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item2Price.setBackground(SystemColor.menu);
		item2Price.setBounds(224, 210, 123, 22);
		frame.getContentPane().add(item2Price);
		
		JLabel item2Type = new JLabel();
		item2Type.setText("Type: " + newList.get(1).getItemType());
		item2Type.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item2Type.setBackground(SystemColor.menu);
		item2Type.setBounds(224, 240, 178, 22);
		frame.getContentPane().add(item2Type);
		
		JLabel item2Effects = new JLabel();
		item2Effects.setText(newList.get(1).propertyAdjustment());
		item2Effects.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item2Effects.setBackground(SystemColor.menu);
		item2Effects.setBounds(224, 273, 147, 22);
		frame.getContentPane().add(item2Effects);
		
		JLabel item3Price = new JLabel();
		item3Price.setText("Price: "+newList.get(2).getItemPrice() +"g"); 
		item3Price.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item3Price.setBackground(SystemColor.menu);
		item3Price.setBounds(402, 210, 123, 22);
		frame.getContentPane().add(item3Price);
		
		JLabel item3Type = new JLabel();
		item3Type.setText("Type: " + newList.get(2).getItemType());
		item3Type.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item3Type.setBackground(SystemColor.menu);
		item3Type.setBounds(402, 240, 147, 22);
		frame.getContentPane().add(item3Type);
		
		JLabel item3Effects = new JLabel();
		item3Effects.setText(newList.get(2).propertyAdjustment());
		item3Effects.setFont(new Font("Monospaced", Font.PLAIN, 14));
		item3Effects.setBackground(SystemColor.menu);
		item3Effects.setBounds(402, 273, 137, 22);
		frame.getContentPane().add(item3Effects);
		
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopScreen.main(newGame);
				frame.dispose();
			}
		});
		
		
		
		
	}
}
