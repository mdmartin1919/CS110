//Matthew Martin
//CS 110
//Final Homework

import java.util.List;

public class Player {
	private String playerName;
	private CardPile cardPile = new CardPile();
	private CardPile winCardPile = new CardPile();
	private int warsWon;
	private int wins = 0;

	public Player(String name){
		this.playerName = name;
	}

	//Adds cards a player won to won pile
	public void wonCards(List<Card> cards){
      wins++;
		for(Card card : cards){
			this.winCardPile.addCard(card);
			
		}
	}


	//Adds a card to playing pile
	public void addCard(Card card){
		this.cardPile.addCard(card);
	}


	//Removes top card from playing pile
	public Card removeTopCard(){
		return this.cardPile.removeTopCard();
	}

	public String getName(){
		return this.playerName;
	}

	//Player still has cards to play
	public boolean hasCardsRemaining(){
		// if card pile is empty and player has won cards, move to playing pile
		if(this.cardPile.size() == 0 && this.winCardPile.size() > 0){
			for(int i = 0; i < winCardPile.size(); i++){
				cardPile.addCard(winCardPile.removeTopCard());
			}
		}
		return this.cardPile.size() > 0;
	}

	public void wonWar(){
		warsWon++;
	}

	public int getNumWarsWon(){
		return this.warsWon;
	}

	public int getNumCardsWon(){
		return this.wins;
	}
}
