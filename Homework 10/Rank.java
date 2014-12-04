//Matthew Martin
//CS 110
//Final Homework


//store the rank of the 13 ranks in the deck
public enum Rank {
	ACE('a', "Ace"),
	TWO('2', "Two"),
	THREE('3', "Three"),
	FOUR('4', "Four"),
	FIVE('5', "Five"),
	SIX('6', "Six"),
	SEVEN('7', "Seven"),
	EIGHT('8', "Eight"),
	NINE('9', "Nine"),
	TEN('t', "Ten"),
	JACK('j', "Jack"), 
	QUEEN('q', "Queen"),
	KING('k', "King");
	
	private final char symbol;
	private final String name;

	private Rank(char symbol, String name){
		this.symbol = symbol;
		this.name = name;
	}
	
	public char getSymbol(){
		return this.symbol;
	}
	
	public String getName(){
		return this.name;
	}
}
