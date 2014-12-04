//Matthew Martin
//CS 110
//Final Homework

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;

public class WarCard extends JFrame implements ActionListener{
	private JLabel player1Deck, player2Deck, player1Turned, player2Turned;
	private JButton btnNext, btnNew, btnExit;
	JLabel lblPlayer1Wins, lblPlayer2Wins, lblNumWars;
	private Game game;
	SpringLayout layout;

	public WarCard(){
		buildGui();
		
		Random r = new Random();
		game = new Game("Matt", "Martin", r.nextLong());
	}

	
	// Builds the user interface using the spring layout manager
	private void buildGui(){
		layout = new SpringLayout();
		this.setLayout(layout);

		// User panel to house playing deck and turned deck
		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setBorder(BorderFactory.createTitledBorder("User"));
		layout.putConstraint(SpringLayout.NORTH, panelPlayer1, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelPlayer1, 10, SpringLayout.WEST, this);

		// User playing deck
		player1Deck = new JLabel();
		player1Deck.setIcon(new ImageIcon("images/cardstack.png"));
		layout.putConstraint(SpringLayout.NORTH, player1Deck, 10, SpringLayout.NORTH, panelPlayer1);
		layout.putConstraint(SpringLayout.WEST, player1Deck, 10, SpringLayout.WEST, panelPlayer1);
		panelPlayer1.add(player1Deck);

		// User turned deck
		player1Turned = new JLabel();
		// added spaces to label as a place holder for width of deck on startup
		player1Turned.setText("                           ");
		layout.putConstraint(SpringLayout.NORTH, player1Turned, 10, SpringLayout.NORTH, panelPlayer1);
		layout.putConstraint(SpringLayout.WEST, player1Turned, 10, SpringLayout.EAST, player1Deck);
		panelPlayer1.add(player1Turned);

		// panel to hold the nextTurn button
		JPanel panelButton = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, panelButton, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelButton, 10, SpringLayout.EAST, panelPlayer1);

		// create new JButton to turn the cards
		btnNext = new JButton("Play!");
		// add listener
		btnNext.addActionListener(this);
		layout.putConstraint(SpringLayout.NORTH, btnNext, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, btnNext, 10, SpringLayout.EAST, player1Turned);
		panelButton.add(btnNext);

		// Computer panel to hold playing deck and turned deck
		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setBorder(BorderFactory.createTitledBorder("Computer"));
		layout.putConstraint(SpringLayout.NORTH, panelPlayer2, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelPlayer2, 10, SpringLayout.EAST, panelButton);

		// computer playing deck
		player2Deck = new JLabel();
		player2Deck.setIcon(new ImageIcon("images/cardstack.png"));
		layout.putConstraint(SpringLayout.NORTH, player2Deck, 10, SpringLayout.NORTH, panelPlayer2);
		layout.putConstraint(SpringLayout.WEST, player2Deck, 10, SpringLayout.WEST, panelPlayer2);
		panelPlayer2.add(player2Deck);

		// computer turned deck
		player2Turned = new JLabel();
		// spaces added to label to hold spacing for turned deck on startup
		player2Turned.setText("                           ");
		layout.putConstraint(SpringLayout.NORTH, player2Turned, 10, SpringLayout.NORTH, panelPlayer2);
		layout.putConstraint(SpringLayout.WEST, player2Turned, 10, SpringLayout.EAST, player2Deck);
		panelPlayer2.add(player2Turned);

		// Panel to hold stats of the game
		JPanel panelStats = new JPanel();
		panelStats.setLayout(new GridLayout(3,1));
		panelStats.setBorder(BorderFactory.createTitledBorder("Stats"));
		layout.putConstraint(SpringLayout.NORTH, panelStats, 10, SpringLayout.SOUTH, panelPlayer1);
		layout.putConstraint(SpringLayout.WEST, panelStats, 10, SpringLayout.WEST, this);

		JLabel player1 = new JLabel("User wins: ");
		lblPlayer1Wins = new JLabel("0");
		layout.putConstraint(SpringLayout.NORTH, player1, 10, SpringLayout.NORTH, panelStats);
		layout.putConstraint(SpringLayout.WEST, player1, 10, SpringLayout.WEST, panelStats);
		layout.putConstraint(SpringLayout.NORTH, lblPlayer1Wins, 10, SpringLayout.NORTH, panelStats);
		layout.putConstraint(SpringLayout.WEST, lblPlayer1Wins, 5, SpringLayout.EAST, player1);
		panelStats.add(player1);
		panelStats.add(lblPlayer1Wins);

		JLabel player2 = new JLabel("Computer wins: ");
		lblPlayer2Wins = new JLabel("0");
		layout.putConstraint(SpringLayout.NORTH, player2, 25, SpringLayout.NORTH, panelStats);
		layout.putConstraint(SpringLayout.WEST, player2, 10, SpringLayout.WEST, panelStats);
		layout.putConstraint(SpringLayout.NORTH, lblPlayer2Wins, 25, SpringLayout.NORTH, panelStats);
		layout.putConstraint(SpringLayout.WEST, lblPlayer2Wins, 5, SpringLayout.EAST, player2);
		panelStats.add(player2);
		panelStats.add(lblPlayer2Wins);
		
		JLabel wars = new JLabel("Number of wars: ");
		lblNumWars = new JLabel("0");
		panelStats.add(wars);
		panelStats.add(lblNumWars);

		btnNew = new JButton("New Game");
		btnNew.addActionListener(this);
		layout.putConstraint(SpringLayout.NORTH, btnNew, 20, SpringLayout.SOUTH, panelPlayer2);
		layout.putConstraint(SpringLayout.WEST, btnNew, 145, SpringLayout.EAST, panelStats);

		btnExit = new JButton("      Exit       ");
		btnExit.addActionListener(this);
		layout.putConstraint(SpringLayout.NORTH, btnExit, 10, SpringLayout.SOUTH, btnNew);
		layout.putConstraint(SpringLayout.WEST, btnExit, 145, SpringLayout.EAST, panelStats);


		this.add(panelPlayer1);
		this.add(panelPlayer2);
		this.add(panelButton);
		this.add(panelStats);
		this.add(btnNew);
		this.add(btnExit);
		this.setTitle("Game Of War");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(570, 300);
      this.setVisible(true);
      this.setLocationRelativeTo(null);
	}

	// start new game
	public static void main(String[] args){
		new WarCard();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// source is the exit button
		if(e.getSource().equals(btnExit)){
			System.exit(0);
		// source is the new button, start new game and close old screen
		}else if(e.getSource().equals(btnNew)){
			this.setVisible(false);
			new WarCard();
		// deal next card
		}else if(e.getSource().equals(btnNext)){
			// make sure game is not over 
			if(!game.gameComplete()){
				game.nextCard();
				boolean isWar = game.getIsWar();
				Card player1Card = game.getPlayer1Card();
				// remove spacing from label and set correct background image
				player1Turned.setText("");
				player1Turned.setIcon(player1Card.getCardImage(isWar));
				Card player2Card = game.getPlayer2Card();
				player2Turned.setText("");
				player2Turned.setIcon(player2Card.getCardImage(isWar));
				
				Player winner = game.getWinner();
				if(winner != null){
					if(winner.getName().equals("Matt")){
						lblPlayer1Wins.setText(winner.getNumCardsWon() + "");
					}else{
						lblPlayer2Wins.setText(winner.getNumCardsWon() + "");
					}
				}
				lblNumWars.setText(game.getNumWars() + "");
				
				if(game.gameComplete()){
					player1Deck.setIcon(null);
					player2Deck.setIcon(null);
				}
			}	
		}
	}
}
