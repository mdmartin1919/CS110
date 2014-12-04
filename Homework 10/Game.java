//Matthew Martin
//CS 110
//Final Homework

public class Game {
	private Player player1;
	private Player player2;
	private long seed;
	private CardPile boardCards = new CardPile();
	private Card player1Card, player2Card;
	private boolean isWar = false;
	private int numWars = 0;
	
   
	public Game(String player1, String player2, long seed){
		this.player1 = new Player(player1);
		this.player2 = new Player(player2);
		this.seed = seed;
		
		dealCards();
	}
	
	

	//Deals the cards

	private void dealCards(){
		// Create a new deck
		Deck deck = new Deck();
		// Shuffle the deck
		deck.shuffle(this.seed);
		
		Card[] cards = deck.getAllCards();
		for(int top = cards.length - 1; top >= 0; top--){
			Card card = cards[top];
			// add card to the pile for the player
			if(top % 2 == 0)
				player2.addCard(card);
			else
				player1.addCard(card);
		}
	}
	
	public boolean gameComplete(){
		// make sure player 1 and player 2 have cards left
		return (!this.player1.hasCardsRemaining() || !this.player2.hasCardsRemaining());
	}
	
	public void nextCard(){
		// check if isWar to determine if 3 cards are dealt face down
		if(isWar){
			for(int i = 0; i < 3; i++){
				player1Card = player1.removeTopCard();
				boardCards.addCard(player1Card);
				
				player2Card = player2.removeTopCard();
				boardCards.addCard(player2Card);
			}
		}else{
			player1Card = player1.removeTopCard();
			boardCards.addCard(player1Card);
			
			player2Card = player2.removeTopCard();
			boardCards.addCard(player2Card);
		}		
	}
	
	public Player getWinner(){
		Player winningPlayer = null;
		// determine winner by comparing cards
		int winner = player1Card.compareTo(player2Card);
		
		// winner = 0 means tie, go to war
		if(winner == 0){
			numWars++;
			
			isWar = true;
		}else{
			winningPlayer = null;
			if(winner > 0)
				winningPlayer = player1;
			else
				winningPlayer = player2;
			
			// add winning board cards to player
			winningPlayer.wonCards(boardCards.getCards());
			// clear board cards
			boardCards.clear();
			// player won the war
			if(isWar)
				winningPlayer.wonWar();
			
			// reset war flag
			isWar = false;
		}
		
		return winningPlayer;
	}
	
	public Card getPlayer1Card(){
		return this.player1Card;
	}
	
	public Card getPlayer2Card(){
		return this.player2Card;
	}
	
	public boolean getIsWar(){
		return this.isWar;
	}
	
	public int getNumWars(){
		return this.numWars;
	}
}
