//Matthew Martin
//CS 110
//Final Project

import javax.swing.ImageIcon;
public class Card {
	private Rank rank;
	private Suit suit;
	
	
	//New card constructor
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank(){
		return this.rank;
	}
	
	public void setRank(Rank rank){
		this.rank = rank;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public void setSuit(Suit suit){
		this.suit = suit;
	}
	
	//Returns the image unless war is called then it shows a card face down
	public ImageIcon getCardImage(boolean isWar){
		ImageIcon icon;
		if(isWar)
			icon = new ImageIcon("images/cardback.png");
		else
			icon = new ImageIcon("images/" + this.suit.getSymbol() + this.rank.getSymbol() + ".png");
		
		return icon;
	}
	

	 //Returns the winning crad or tie
	 //returns 0 for tie, 1 for card1, 2 for card2

	public int compareTo(Card card2){
		// gets rank of current card
		char card1Rank = this.getRank().getSymbol();
		// gets rank of parameter card
		char card2Rank = card2.getRank().getSymbol();
		
		// Tie
		if(card1Rank == card2Rank)
			return 0;
		
		// Nothing past here can be a tie
		// Ace wins
		if(card1Rank == 'a')
			return 1;
		
		if(card2Rank == 'a')
			return -1;
		
		// compare rank 
		int winnerCard = this.getRank().compareTo(card2.getRank());
		if(winnerCard > 0)
			// card 1 is larger
			return 1;
		else
			// card 2 is larger
			return -1;
	}
}
