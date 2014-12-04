//Matthew Martin
//CS 110
//Final Homework

//Enum used to store the 4 suits in the deck
public enum Suit {
	CLUBS('c', "Clubs"),
	DIAMONDS('d', "Diamonds"),
	HEARTS('h', "Hearts"),
	SPADES('s', "Spades");
	
	private final char symbol;
	private final String name;
	

	//Internal constructor used to create suit
	private Suit(char symbol, String name){
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
